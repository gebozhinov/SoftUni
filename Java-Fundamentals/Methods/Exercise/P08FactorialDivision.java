import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());

        double result = divisionFactorial(numOne, numTwo);
        System.out.printf("%.2f", result);

    }

    public static double calculateFactorial(int number) {
        double result = 1;
        for (int i = number; i >= 1; i--) {
            result = result * i;
        }
        return result;
    }

    public static double divisionFactorial(int n1, int n2) {
        return calculateFactorial(n1) / calculateFactorial(n2);
    }
}
