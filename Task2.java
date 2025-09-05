import java.util.Scanner;

class Student {
    private int rollNumber;
    private String name;
    private String course;
    private double marks;
    private char grade;
    
    // Default constructor
    public Student() {}
    
    // Parameterized constructor
    public Student(int rollNumber, String name, String course, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.course = course;
        setMarks(marks);
    }
    
    // Setter Functions
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }
    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
    public void setMarks(double marks) {
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    // Getter Functions
    public int getRollNumber() { return rollNumber; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }
    public char getGrade() { return grade; }

    private char calculateGrade(double marks) {
        if (marks >= 90) return 'A';
        else if (marks >= 80) return 'B';
        else if (marks >= 70) return 'C';
        else if (marks >= 60) return 'D';
        else return 'F';
    }

    public void displayStudent() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("---------------------------");
    }

    public void inputStudent(Scanner scanner) {
        System.out.print("Enter Roll Number: ");
        this.rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter Student Name: ");
        this.name = scanner.nextLine();
        
        System.out.print("Enter Course: ");
        this.course = scanner.nextLine();
        
        System.out.print("Enter Marks: ");
        this.marks = scanner.nextDouble();
        this.grade = calculateGrade(marks);
    }
}

public class Task2 {
    private static Student[] students;
    private static int studentCount;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void initializeSystem(int size) {
        students = new Student[size];
        studentCount = 0;
    }
    
    public static void addStudent() {
        if (studentCount >= students.length) {
            System.out.println("Cannot add more students. Maximum capacity reached!\n");
            return;
        }
        
        Student student = new Student();
        student.inputStudent(scanner);
        students[studentCount] = student;
        studentCount++;
        System.out.println("Student added successfully!\n");
    }
    
    public static void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No student records available!\n");
            return;
        }
        
        System.out.println("\n======= Student Records =======");
        for (int i = 0; i < studentCount; i++) {
            students[i].displayStudent();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Student Management System");
        System.out.println("=========================\n");
        
        System.out.print("Enter maximum number of students: ");
        int maxStudents = scanner.nextInt();
        initializeSystem(maxStudents);
        
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    System.out.println("Thank you for using Student Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
        
        scanner.close();
    }
}