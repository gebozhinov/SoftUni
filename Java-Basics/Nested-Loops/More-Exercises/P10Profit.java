import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int oneLev = Integer.parseInt(scanner.nextLine());
        int twoLev = Integer.parseInt(scanner.nextLine());
        int fiveLev = Integer.parseInt(scanner.nextLine());
        int amount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= oneLev; i++) {
            for (int j = 0; j <= twoLev; j++) {
                for (int k = 0; k <= fiveLev; k++) {
                    if (i * 1 + j * 2 + k * 5 == amount) {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n", i, j, k, amount);
                    }
                }
            }
        }

    }
}
