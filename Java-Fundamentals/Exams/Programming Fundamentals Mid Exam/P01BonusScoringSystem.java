package exam.mid;

import java.util.Scanner;

public class P01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double totalBonus = 0;
        int studentAttendance = 0;
        for (int i = 0; i < students; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());
            double currentBonus = attendance * 1.0 / lectures * (5 + additionalBonus);
            if (currentBonus > totalBonus) {
                totalBonus = currentBonus;
                studentAttendance = attendance;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(totalBonus));
        System.out.printf("The student has attended %d lectures.", studentAttendance);


    }
}
