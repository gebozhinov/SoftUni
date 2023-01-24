package setsAndMapsAdvanced.lab;

import java.util.*;


public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Double> studentsMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            String[] grades = scanner.nextLine().split(" ");
            double gradeSum = 0;
            for (String grade : grades) {
                gradeSum += Double.parseDouble(grade);
            }
            studentsMap.putIfAbsent(student, gradeSum / grades.length);

        }

        for (var student : studentsMap.entrySet()) {
            System.out.println(student.getKey() + " is graduated with " + student.getValue());
        }

    }
}
