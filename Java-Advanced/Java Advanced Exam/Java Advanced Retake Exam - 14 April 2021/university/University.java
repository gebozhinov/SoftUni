package exam.april2021.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        StringBuilder sb = new StringBuilder();
        if (students.contains(student)) {
            return "Student is already in the exam.april2021.university";
        }
        if (capacity > students.size()) {
            students.add(student);
            sb.append(String.format("Added student %s %s", student.getFirstName(), student.getLastName()));
        } else {
            sb.append("No seats in the exam.april2021.university");
        }
        return sb.toString().trim();
    }

    public String dismissStudent(Student student) {
        String result = "";
        if (students.contains(student)) {
            students.remove(student);
            result =  String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            result = "Student not found";
        }
        return result;
    }

    public Student getStudent(String firstName, String lastName) {
        return students.stream().filter(e -> e.getFirstName().equals(firstName))
                .filter(e -> e.getLastName().equals(lastName))
                .findFirst().get();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        students.forEach(e -> sb.append(String.format("==Student: First Name = %s, ", e.getFirstName()))
                .append(String.format("Last Name = %s, ", e.getLastName()))
                .append(String.format("Best Subject = %s", e.getBestSubject()))
                .append(String.format("%n")));
        return sb.toString().trim();
    }
}
