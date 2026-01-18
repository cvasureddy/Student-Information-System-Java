import java.util.Scanner;

public class StudentInformationSystem {

    private static Scanner sc = new Scanner(System.in);
    private static StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== STUDENT INFORMATION SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Student ID: ");
        String id = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();

        System.out.print("Grade: ");
        double grade = sc.nextDouble();
        sc.nextLine();

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        if (!ValidationUtils.isValidAge(age) || !ValidationUtils.isValidGrade(grade)) {
            System.out.println("Invalid age or grade!");
            return;
        }

        manager.addStudent(new Student(id, name, age, grade, contact));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (manager.getAllStudents().isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        for (Student s : manager.getAllStudents()) {
            s.display();
        }
    }

    private static void searchStudent() {
        System.out.print("Enter ID or Name: ");
        String key = sc.nextLine();

        Student s = manager.searchById(key);
        if (s == null) s = manager.searchByName(key);

        if (s != null) s.display();
        else System.out.println("Student not found!");
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        Student s = manager.searchById(id);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("New Name: ");
        s.setName(sc.nextLine());

        System.out.print("New Age: ");
        s.setAge(sc.nextInt());

        System.out.print("New Grade: ");
        s.setGrade(sc.nextDouble());
        sc.nextLine();

        System.out.print("New Contact: ");
        s.setContact(sc.nextLine());

        System.out.println("Student updated!");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        if (manager.deleteStudent(id))
            System.out.println("Student deleted!");
        else
            System.out.println("Student not found!");
    }
}