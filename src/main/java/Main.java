import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        // сортируем коллекцию
        staff.sort(Comparator.comparing(Employee::getSalary));

        // добавляем зарплату каждому сотруднику
        int bonus = 990;
        staff.forEach(e -> e.setSalary(e.getSalary() + bonus));

        // сортируем коллекцию по заплатам и именам
        staff.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
        System.out.println("Список по зарплатам:");
        staff.forEach(System.out::println);

        // печатаем только тех сотрудников у которых зарплата больше 70000
        /* базовая версия с объявлением
            Stream<Employee> stream = staff.stream();
            stream.filter(e -> e.getSalary() >= 100_000).forEach(System.out::println);
        */
        System.out.println("\nСотрудники у которых зарплата больше 100.000:\n");
        staff.stream().filter(e -> e.getSalary() >= 100_000).forEach(System.out::println);
        System.out.println();

        // Пример стрима от из целых чисел. Стрим необязательно коллекция, любой набор элементов
        Stream<Integer> numbers = Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
        numbers.filter(num -> num % 4 == 0).forEach(System.out::println);
        System.out.println();

        // Тот же самый пример - реализованный без класса стрим, но методом стрим
        Integer[] numbers2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        Arrays.stream(numbers2).filter(n -> n % 4 == 0).forEach(System.out::println);
        System.out.println();

        /**
         * Теперь все то же самое, что было выше, только реализуем все через
         * метод стрим. У нас есть коллекция staff - будем ее сортировать,
         * выводить на экран и так далее
         */
        System.out.println("NAME ----------------");
        staff.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
        System.out.println();

        System.out.println("DATE ----------------");
        staff.stream().sorted(Comparator.comparing(Employee::getWorkStart)).forEach(System.out::println);
        System.out.println();

        System.out.println("SALARY ----------------");
        List<Employee> sorted = staff.stream().sorted((o1, o2) -> o2.getSalary().compareTo(o1.getSalary())).collect(Collectors.toList());
        sorted.forEach(System.out::println);

        System.out.println();
        System.out.println(staff.stream().max(Comparator.comparing(Employee::getSalary)).get());

    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.
        /**
        staff.sort(((o1, o2) -> {
            int result = o1.getSalary().compareTo(o2.getSalary());
            return (result == 0 ? o1.getName().compareTo(o2.getName()) : result);
        }));
         */
        staff.sort((Comparator.comparingInt(Employee::getSalary).thenComparing(Employee::getName)));


    }
}