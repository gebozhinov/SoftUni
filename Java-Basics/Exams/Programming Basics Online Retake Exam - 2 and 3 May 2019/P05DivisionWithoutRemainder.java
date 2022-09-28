import java.util.Scanner;

public class DivisionWithoutRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        double p1Count = 0;
        double p2Count = 0;
        double p3Count = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number % 2 == 0) {
                p1Count++;
            }
            if (number % 3 == 0) {
                p2Count++;
            }
            if (number % 4 == 0) {
                p3Count++;
            }
        }
        double p1Percent = p1Count / n * 100;
        double p2Percent = p2Count / n * 100;
        double p3Percent = p3Count / n * 100;
        System.out.printf("%.2f%%%n", p1Percent);
        System.out.printf("%.2f%%%n", p2Percent);
        System.out.printf("%.2f%%%n", p3Percent);
    }
}
