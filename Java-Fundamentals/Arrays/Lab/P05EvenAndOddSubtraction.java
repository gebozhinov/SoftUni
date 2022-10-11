import java.util.Scanner;

public class P05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] inputLine = scanner.nextLine().split(" ");

        int[] numbers = new int[inputLine.length];
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < inputLine.length; i++) {
            numbers[i] = Integer.parseInt(inputLine[i]);
            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];
            } else {
                oddSum += numbers[i];
            }
        }
        System.out.println(evenSum - oddSum);
    }
}
