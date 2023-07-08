import java.util.Scanner;
import Operation.ManagerOperation;
import Operation.StudentOperation;
import Persons.Student;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("----- E-School Operations -----");
            System.out.println("1. Student Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.print("Make your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Read the newline character

            switch (choice) {
                case 1 ->
                    // Student Login
                        studentLogin();
                case 2 ->
                    // Admin Login
                        adminLogin();
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }

    public static void studentLogin() {
        // Student login process
        System.out.println("Enter your student number:");
        Scanner scanner = new Scanner(System.in);
        String schoolNumber = scanner.nextLine();

        if (StudentOperation.isStudent(schoolNumber)) {
            System.out.println("Login successful.\n");
            Student person = StudentOperation.getStudent(schoolNumber);
            assert person != null;
            System.out.println("Student:" +
                    "\nnameSurname='" + person.getNameSurname() + '\'' +
                    "\nschoolNumber='" + schoolNumber + '\'' +
                    "\ngrades=");
            for (int d=0;d<5;d++){
                System.out.println((d+1)+". Grade is "+ person.getGrades()[d]);
            }
            System.out.println("Avarage is "+person.calculateAverageGrade());
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void adminLogin() {
        // Admin login process
        System.out.println("Enter your username:");
        Scanner scanner = new Scanner(System.in);
        String adminName = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (ManagerOperation.isManager(adminName, password)) {
            System.out.println("Login successful.\n");
            int choice = 0;

            while (choice != 3) {
                System.out.println("----- Manager Operations -----");
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Exit");
                System.out.print("Make your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter the name and surname of the student:");
                        String name = scanner.nextLine();
                        System.out.println("Enter the student number:");
                        String schoolNumber = scanner.nextLine();
                        System.out.println("Enter the grades in order:");
                        int[] grades = new int[5];
                        for (int i = 0; i < 5; i++) {
                            System.out.println("Grade " + (i + 1) + ":");
                            grades[i] = scanner.nextInt();
                        }
                        Student student = new Student(name, schoolNumber, grades);
                        ManagerOperation.addStudent(student);
                    }
                    case 2 -> {
                        System.out.println("Enter the school number of the student to remove:");
                        ManagerOperation.removeStudent(scanner.nextLine());
                    }
                    case 3 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            }
        } else {
            System.out.println("Incorrect credentials.");
        }
    }
}