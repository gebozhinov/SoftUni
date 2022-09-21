import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        double fail = 0;
        double average = 0;
        double good = 0;
        double topStudents = 0;
        double totalGrades = 0;
        for (int i = 0; i < students; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            totalGrades += grade;
            if (grade < 3) {
                fail++;
            } else if (grade < 4) {
                average++;
            } else if (grade < 5) {
                good++;
            } else {
                topStudents++;
            }
        }
        double averageGrade = totalGrades / students;
        System.out.printf("Top students: %.2f%%%n", topStudents / students * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", good / students * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", average / students * 100);
        System.out.printf("Fail: %.2f%%%n", fail / students * 100);
        System.out.printf("Average: %.2f", averageGrade);
    }
}
