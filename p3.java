import java.util.Scanner;

class Student {
    private int studentID;
    private String name;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }
}

class Grade {
    private int studentID;
    private int courseID;
    private char grade;

    public Grade(int studentID, int courseID, char grade) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public char getGrade() {
        return grade;
    }

    public int gradeToPoints(char grade) {
        switch (grade) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            default:
                return 0;
        }
    }
}

class GradingSystem {
    private Student[] students;
    private Grade[] grades;
    private int studentCount;
    private int gradeCount;

    public GradingSystem(int capacity) {
        students = new Student[capacity];
        grades = new Grade[capacity];
        studentCount = 0;
        gradeCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount] = student;
            studentCount++;
        } else {
            System.out.println("Student capacity exceeded.");
        }
    }

    public void addGrade(Grade grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount] = grade;
            gradeCount++;
        } else {
            System.out.println("Grade capacity exceeded.");
        }
    }

    public double calculateGPA(int studentID) {
        double totalPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentID() == studentID) {
                int points = grades[i].gradeToPoints(grades[i].getGrade());
                totalPoints += points;
                totalCredits++;
            }
        }

        if (totalCredits == 0) {
            return 0.0;
        } else {
            return totalPoints / totalCredits;
        }
    }

    public void printGradeReport(int studentID) {
        System.out.println("Grade Report for Student " + studentID);
        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentID() == studentID) {
                System.out.println("Course " + grades[i].getCourseID() + ": " + grades[i].getGrade());
            }
        }
        System.out.println("GPA: " + calculateGPA(studentID));
    }

}

public class p3{
    public static void main(String[] args) {
        GradingSystem gradingSystem = new GradingSystem(100);
    
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.println("Grading System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Calculate GPA");
            System.out.println("4. Print Grade Report");
            System.out.println("5. Exit");
    
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    System.out.print("Enter student name: ");
                    String studentName = scanner.next();
                    gradingSystem.addStudent(new Student(studentID, studentName));
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    int gradeStudentID = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseID = scanner.nextInt();
                    System.out.print("Enter grade (A, B, C, D): ");
                    char grade = scanner.next().charAt(0);
                    gradingSystem.addGrade(new Grade(gradeStudentID, courseID, grade));
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int gpaStudentID = scanner.nextInt();
                    double gpa = gradingSystem.calculateGPA(gpaStudentID);
                    System.out.println("GPA: " + gpa);
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    int reportStudentID = scanner.nextInt();
                    gradingSystem.printGradeReport(reportStudentID);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}