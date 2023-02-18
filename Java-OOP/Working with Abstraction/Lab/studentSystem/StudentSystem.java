package workingWithAbstraction.lab.studentSystem;

import java.util.HashMap;
import java.util.Map;


public class StudentSystem {
    private Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void createStudent(String... arguments) {
        String name = arguments[1];
        int age = Integer.parseInt(arguments[2]);
        double grade = Double.parseDouble(arguments[3]);

        if (!isStudentExist(name)) {
            Student student = new Student(name, age, grade);
            students.put(name, student);
        }
    }

    public void showStudent(String... arguments) {
        String name = arguments[1];

        if (isStudentExist(name)) {
            Student student = students.get(name);
            System.out.println(student);
        }

    }

    private boolean isStudentExist(String name) {
        return students.containsKey(name);
    }


}
