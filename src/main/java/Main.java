import java.util.Comparator;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        sortBySalaryAndAlphabet(staff);

        staff.sort(Comparator.comparing(Employee::getSalary));

        System.out.println("Список по зарплатам (старые)");
        //staff.forEach(employee -> System.out.println(employee));
        staff.forEach(System.out::println);
        System.out.println();

        int bonus = 990;
        staff.forEach(e -> e.setSalary(e.getSalary() + bonus));
        System.out.println("Список по зарплатам (старые)");
        staff.forEach(System.out::println);
        System.out.println();

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