package udemy_Stream_Api.FP_01;

import java.util.ArrayList;
import java.util.List;

public class CreateListObjects {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Adding students to the list
        students.add(new Student("Rahul", 85, "Delhi"));
        students.add(new Student("Anjali", 90, "Mumbai"));
        students.add(new Student("Vikram", 75, "Bangalore"));
        students.add(new Student("Neha", 95, "Pune"));

        // Printing initial list of students
        System.out.println("Initial Student List:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Updating a student's details (example: updating Vikram's marks)
        for (Student student : students) {
            if (student.getName().equals("Vikram")) {
                student.setMarks(80);  // Updating marks
                student.setCity("Hyderabad");  // Updating city
            }
        }

        // Printing updated list of students
        System.out.println("\nUpdated Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

// Define the Student class with Getters and Setters
class Student {
    private String name;
    private int marks;
    private String city;

    // Constructor
    public Student(String name, int marks, String city) {
        this.name = name;
        this.marks = marks;
        this.city = city;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public String getCity() {
        return city;
    }

    // Setters - Allow modifying values
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Override toString() to display student details
    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + ", city='" + city + "'}";
    }
}
