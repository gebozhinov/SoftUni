import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int fistNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        smallestNumber(fistNumber, secondNumber, thirdNumber);


    }
    public static void smallestNumber(int firstNumber, int secondNumber, int thirdNumber) {
        int result = Math.min(firstNumber, Math.min(secondNumber, thirdNumber));
        System.out.println(result);
    }
}
