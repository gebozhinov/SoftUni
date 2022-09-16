import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputOne = Integer.parseInt(scanner.nextLine());
        int inputTwo = Integer.parseInt(scanner.nextLine());

        for (int i = inputOne; i <= inputTwo; i++) {
            String number = String.valueOf(i);
            int evenSum = 0;
            int oddSum = 0;
            for (int j = 0; j < number.length(); j++) {
                int currentNum = Integer.parseInt(number.charAt(j) + "");
                if (j % 2 == 0) {
                    evenSum += currentNum;
                } else {
                    oddSum += currentNum;
                }
            }
            if (evenSum == oddSum) {
                System.out.print(i + " ");
            }
        }
    }
}
