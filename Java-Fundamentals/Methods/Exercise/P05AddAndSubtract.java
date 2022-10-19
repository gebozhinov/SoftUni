import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int result = subtractThird(firstNumber, secondNumber, thirdNumber);
        System.out.println(result);
    }

    public static int addFirstAndSecondNum(int first, int second) {
        return first + second;
    }

    public static int subtractThird(int first, int second, int third) {
        return addFirstAndSecondNum(first, second) - third;
    }
}
