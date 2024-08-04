import java.util.Scanner;

class Course {

    private int courseId;
    private String courseName;
    private int credits;

    public Course(int courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Course{"
                + "courseId=" + courseId
                + ", courseName='" + courseName + '\''
                + ", credits=" + credits
                + '}';
    }
}

class Enrollment {

    private int[][] studentCourses;
    private int[] count;

    public Enrollment(int numStudents, int numCourses) {
        studentCourses = new int[numStudents][numCourses];
        count = new int[numStudents];
    }

    public void enroll(int studentID, int courseId) {
        studentCourses[studentID][count[studentID]] = courseId;
        count[studentID]++;
    }

    public void drop(int studentID, int courseId) {
        for (int i = 0; i < count[studentID]; i++) {
            if (studentCourses[studentID][i] == courseId) {
                studentCourses[studentID][i] = 0;
                count[studentID]--;
                return;
            }
        }
    }

    public void getEnrolledCourses(int studentID, Course[] courseCatalog) {
        System.out.println("Enrolled courses for student " + studentID + ":");
        for (int i = 0; i < count[studentID]; i++) {
            int courseId = studentCourses[studentID][i];
            for (Course course : courseCatalog) {
                if (course.getCourseId() == courseId) {
                    System.out.println(course);
                }
            }
        }
    }
}

public class p2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        Course course1 = new Course(1, "Introduction to Computer Science", 3);
        Course course2 = new Course(2, "COA", 4);
        Course course3 = new Course(3, "Maths", 3);

        Course[] courseCatalog = {course1, course2, course3};

        
        Enrollment enrollment = new Enrollment(100, 3);

        while (true) {
            System.out.println("1. Enroll in a course");
            System.out.println("2. Drop a course");
            System.out.println("3. View enrolled courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Student ID between 1 - 100");
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    System.out.println("Enter 1 : Introduction to Computer Science");
                    System.out.println("Enter 2 : COA");
                    System.out.println("Enter 3 : Maths");
                    System.out.print("Enter course ID: ");
                    int courseID = scanner.nextInt();
                    enrollment.enroll(studentID, courseID);
                    System.out.println("Enrolled successfully!");
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    courseID = scanner.nextInt();
                    enrollment.drop(studentID, courseID);
                    System.out.println("Dropped successfully!");
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextInt();
                    enrollment.getEnrolledCourses(studentID, courseCatalog);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}