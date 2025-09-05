class Students{
    private int rollNumber;
    private String name;
    private String course;
    private double marks;
    private char grade;
    
    //Setter Functions
    public void setRollNumber(int rollNumber) {this.rollNumber = rollNumber;}
    public void setName(String name) {this.name = name;}
    public void setCourse(String course) {this.course = course;}
    public void setMarks(double marks) {
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    //Getter Functions
    public int getRollNumber() {return rollNumber;}
    public String getName() {return name;}
    public String getCourse() {return course;}
    public double getMarks() {return marks;}
    public char getGrade() {return grade;}

    private char calculateGrade(double marks) {
        if (marks >= 90) return 'A';
        else if (marks >= 80) return 'B';
        else if (marks >= 70) return 'C';
        else if (marks >= 60) return 'D';
        else return 'F';
    }

    public void displayStudent(){
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name : " + name);
        System.out.println("Course : " + course);
        System.out.println("Marks : " + marks);
        System.out.println("Grade : " + grade);
        System.out.println("---------------------------");
    }

}

public class Task1 {
    public static void main(String[] args) {
    Students s1 = new Students();
    s1.setRollNumber(1);
    s1.setName("Alice");
    s1.setCourse("Math");
    s1.setMarks(95);
    s1.displayStudent();
    

    Students s2 = new Students();
    s2.setRollNumber(2);
    s2.setName("Bob");
    s2.setCourse("Science");
    s2.setMarks(82);
    s2.displayStudent();

    }
}