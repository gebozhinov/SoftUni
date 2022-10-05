import java.util.Scanner;

public class P11MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int multiplier = scanner.nextInt();

        for (int i = multiplier; i <= 10; i++) {
            System.out.printf("%d X %d = %d%n", number, i, number * i);
        }
        if (multiplier > 10) {
            System.out.printf("%d X %d = %d%n", number, multiplier, number * multiplier);
        }

    }
}
