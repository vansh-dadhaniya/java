import java.util.Scanner;

class Student {

    int studentId, age;
    String name, department;

    public Student(int studentId, String name, int age, String department) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Age: " + age + ", Department: " + department;
    }
}

class StudentRecordSystem {

    Student[] students;
    int count;

    public StudentRecordSystem(int max) {
        students = new Student[max];
        count = 0;
    }

    public void addStudent(int stu_id, String stu_name, int stu_age, String stu_dept) {
        if (count > students.length) {
            System.out.println("maximum limit reached");
            return;
        }

        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == stu_id) {
                System.out.println("Entered id is alredy exist");
                return;
            }
        }

        Student student = new Student(stu_id, stu_name, stu_age, stu_dept);
        students[count] = student;
        count++;

    }

    public void getStudent(int stu_id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == stu_id) {
                System.out.println(students[i].toString());
                return;
            }
        }
        System.out.println("Id is not Found !!");
    }

    public void displayAllStudents() {
        if (count == 0) {
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(students[i].toString());
        }
    }

}

class StudentRecordMGMT {

    public static void main(String[] args) {

        StudentRecordSystem recordSystem = new StudentRecordSystem(100);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Record System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter student department: ");
                    String department = sc.nextLine();
                    recordSystem.addStudent(studentId, name, age, department);
                    break;
                case 2:
                    recordSystem.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter student ID to search: ");
                    studentId = sc.nextInt();
                    recordSystem.getStudent(studentId);
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