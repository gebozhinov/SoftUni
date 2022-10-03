import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n1DigitOne = n1 / 1000;
        int n1DigitTwo = n1 / 100 % 10;
        int n1DigitThree = n1 % 100 / 10;
        int n1DigitFour = n1 % 10;
        int n2DigitOne = n2 / 1000;
        int n2DigitTwo = n2 / 100 % 10;
        int n2DigitThree = n2 % 100 / 10;
        int n2DigitFour = n2 % 10;

        for (int i = n1DigitOne; i <= n2DigitOne; i++) {
            for (int j = n1DigitTwo; j <= n2DigitTwo; j++) {
                for (int k = n1DigitThree; k <= n2DigitThree; k++) {
                    for (int l = n1DigitFour; l <= n2DigitFour; l++) {
                        if (i % 2 != 0 && j % 2 != 0 && k % 2 != 0 && l % 2 != 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}

