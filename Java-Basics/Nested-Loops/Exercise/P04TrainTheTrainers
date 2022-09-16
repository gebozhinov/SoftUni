import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int jury = Integer.parseInt(scanner.nextLine());
        double totalGrade = 0;
        int totalTasks = 0;
        String task = scanner.nextLine();
        while (!task.equals("Finish")) {
            totalTasks++;
            double gradeSum = 0;
            for (int i = 0; i < jury; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                gradeSum += grade;
            }
            double averageGrade = gradeSum / jury;
            totalGrade += averageGrade;
            System.out.printf("%s - %.2f.%n", task, averageGrade);
            task = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", totalGrade / totalTasks);
    }
}
