import java.text.DecimalFormat;
import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNumber = Integer.parseInt(scanner.nextLine());
        DecimalFormat df = new DecimalFormat("0.##");
        double result = 0;
        switch (operator) {
            case "+":
                result = sumOperation(firstNumber, secondNumber);
                break;
            case "-":
                result = subtractOperation(firstNumber, secondNumber);
                break;
            case "/":
                result = divideOperation(firstNumber, secondNumber);
                break;
            case "*":
                result = multiplyOperation(firstNumber, secondNumber);
                break;
        }
        System.out.println(df.format(result));

    }
    public static int sumOperation(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
    public static int subtractOperation(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
    public static int multiplyOperation(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
    public static int divideOperation(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }
}
