import java.util.Scanner;

public class P03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        String[] inputLineArr = inputLine.split(" ");
        int[] numbers = new int[inputLineArr.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputLineArr[i]);
        }
        int evenSum = 0;
        for (int number : numbers)
            if (number % 2 == 0) {
                evenSum += number;
            }

        System.out.println(evenSum);


    }
}
