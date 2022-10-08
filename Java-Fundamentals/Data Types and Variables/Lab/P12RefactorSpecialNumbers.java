import java.util.Scanner;

public class P12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= inputNumber; i++) {
            int sumOfDigits = 0;
            int currentNumber = i;
            while (i > 0) {
                sumOfDigits += i % 10;
                i = i / 10;
            }
            boolean isSpecial = (sumOfDigits == 5) || (sumOfDigits == 7) || (sumOfDigits == 11);
            String boolToStr = Boolean.toString(isSpecial);
            System.out.printf("%d -> %s%n", currentNumber, boolToStr.substring(0, 1).toUpperCase() + boolToStr.substring(1));
            i = currentNumber;
        }
    }
}
