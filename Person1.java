import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;

// Base class
class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void displayName() {
        System.out.println("Name: " + name);
    }

    public void displayAge(String dobStr) {
        SimpleDateFormat formatter;
        if (dobStr.contains("-") && dobStr.indexOf('-') == 2) {
            formatter = new SimpleDateFormat("dd-MM-yyyy");
        } else {
            formatter = new SimpleDateFormat("yyyy-MM-dd");
        }

        try {
            Date dob = formatter.parse(dobStr);
            Calendar dobCal = Calendar.getInstance();
            dobCal.setTime(dob);

            Calendar today = Calendar.getInstance();
            int age = today.get(Calendar.YEAR) - dobCal.get(Calendar.YEAR);

            if (today.get(Calendar.DAY_OF_YEAR) < dobCal.get(Calendar.DAY_OF_YEAR)) {
                age--;
            }

            System.out.println("Age: " + age + " years");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use DD-MM-YYYY or YYYY-MM-DD.");
        }
    }
}

// Derived class
class Employee extends Person {
    private int empId;
    private double salary;

    public Employee(String name, int empId, double salary) {
        super(name);
        this.empId = empId;
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: ₹" + salary);
    }
}

// Main class
public class Person1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee ID: ");
        int empId = scanner.nextInt();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // consume leftover newline

        System.out.print("Enter date of birth (DD-MM-YYYY or YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        // Create Employee object
        Employee emp = new Employee(name, empId, salary);

        // Display information
        emp.displayName();
        emp.displayAge(dob);
        emp.displayEmployeeDetails();

        scanner.close();
    }
}
