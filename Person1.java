import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    // Method to display person's name
    public void displayName() {
        System.out.println("Name: " + name);
    }

    // Method to display person's age from date of birth
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
                age--; // Not yet had birthday this year
            }

            System.out.println("Age: " + age + " years");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use DD-MM-YYYY or YYYY-MM-DD.");
        }
    }
}

public class Person1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        Person person = new Person(name);
        person.displayName();

        System.out.print("Enter date of birth (DD-MM-YYYY or YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        person.displayAge(dob);

        scanner.close();
    }
}
