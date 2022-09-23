import java.util.Scanner;

public class HappyCatParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double totalTax = 0;
        for (int i = 1; i <= days; i++) {
            double dayTax = 0;
            for (int j = 1; j <= hours; j++) {
                if (i % 2 == 0 && j % 2 != 0) {
                    dayTax += 2.5;
                } else if (i % 2 != 0 && j % 2 == 0) {
                    dayTax += 1.25;
                } else {
                    dayTax += 1;
                }
            }
            totalTax += dayTax;
            System.out.printf("Day: %d - %.2f leva%n", i, dayTax);
        }
        System.out.printf("Total: %.2f leva", totalTax);
    }
}
