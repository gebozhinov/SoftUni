import java.util.Scanner;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split(" ");
        int[] numbers = new int[inputLine.length];

        for (int i = 0; i < inputLine.length; i++) {
            numbers[i] = Integer.parseInt(inputLine[i]);
        }
        int leftSum = 0;
        int rightSum = 0;
        boolean isFound = false;
        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];
            leftSum += numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }
            if ((leftSum - currentNum) == rightSum) {
                System.out.printf("%d", i);
                isFound = true;
                break;
            }
            rightSum = 0;
        }
        if (!isFound) {
            System.out.println("no");
        }
    }
}
