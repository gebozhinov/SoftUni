import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05Students {
    static class Student {
        String firstName;
        String lastName;
        String age;
        String town;


        public Student(String firstName, String lastName, String age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAge() {
            return this.age;
        }

        public String getTown() {
            return this.town;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] studentData = input.split(" ");
            String firstName = studentData[0];
            String lastName = studentData[1];
            String age = studentData[2];
            String town = studentData[3];
            Student student = new Student(firstName, lastName, age, town);
            studentList.add(student);


            input = scanner.nextLine();
        }

        String inputTown = scanner.nextLine();
        for (Student currentStudent : studentList) {
            if (currentStudent.getTown().equals(inputTown)) {
                System.out.printf("%s %s is %s years old%n", currentStudent.getFirstName(), currentStudent.getLastName(),
                        currentStudent.getAge());
            }
        }

    }
}
