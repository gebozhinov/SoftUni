package exceptionsAndErrorHandling;

import java.util.Scanner;

public class P02SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        try {
            System.out.printf("%.2f%n", sqrt(input));
        } catch (IllegalArgumentException ignored) {
            System.out.println("Invalid");
        }

        System.out.println("Goodbye");

    }

    private static double sqrt(String input) {
        int num = Integer.parseInt(input);

        if (num < 0) {
            throw new IllegalArgumentException("Invalid number");
        }

        return Math.sqrt(num);


    }
}
