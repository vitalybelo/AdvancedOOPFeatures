import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        sortBySalaryAndAlphabet(staff);
        for (Employee worker : staff)
            System.out.println(worker);


        //System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.
        staff.sort(((o1, o2) -> {
            int result = o1.getSalary().compareTo(o2.getSalary());
            return result == 0 ? o1.getName().compareTo(o2.getName()) : result;
        }));

    }
}