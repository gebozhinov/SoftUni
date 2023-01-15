package exam.mid.july2020;

import java.util.Scanner;

public class P01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());

        int answeredQuestionsPer = firstEmployee + secondEmployee + thirdEmployee;
        int hours = 0;
        while (students > 0) {
            for (int i = 0; i < 3; i++) {
                students -= answeredQuestionsPer;
                hours++;
                if (students <= 0) {
                    break;
                }
            }
            if (students <= 0) {
                break;
            }
            hours++;
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
