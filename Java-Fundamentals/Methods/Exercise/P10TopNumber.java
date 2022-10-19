import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        printTopNumber(number);

    }

    public static void printTopNumber(int n) {
        for (int i = 1; i <= n; i++) {
            int currentNum = i;
            int sumDigits = 0;
            boolean isDigitOdd = false;
            while (currentNum > 0) {
                int currentDigit = currentNum % 10;
                sumDigits += currentDigit;
                if (currentDigit % 2 != 0) {
                    isDigitOdd = true;
                }
                currentNum /= 10;
            }
            if (sumDigits % 8 == 0 && isDigitOdd) {
                System.out.println(i);
            }
        }
    }
}
