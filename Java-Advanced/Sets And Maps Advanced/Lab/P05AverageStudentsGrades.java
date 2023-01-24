package setsAndMapsAdvanced.lab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int students = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsMap = new TreeMap<>();
        for (int i = 0; i < students; i++) {
            String currentStudent = scanner.nextLine();
            String name = currentStudent.split("\\s+")[0];
            double grade = Double.parseDouble(currentStudent.split("\\s+")[1]);
            studentsMap.putIfAbsent(name, new ArrayList<>());
            studentsMap.get(name).add(grade);

        }

        for (Map.Entry<String, List<Double>> student : studentsMap.entrySet()) {
            System.out.print(student.getKey() + " -> ");
            double averageGrade = 0;
            for (Double grade : student.getValue()) {
                averageGrade += grade;
                System.out.printf("%.2f ", grade);
            }
            System.out.printf("(avg: %.2f)%n", averageGrade / student.getValue().size());
        }


    }
}
