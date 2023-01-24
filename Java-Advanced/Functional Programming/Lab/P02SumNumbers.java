package functionalProgramming.lab;

import java.util.Arrays;

import java.util.Scanner;
import java.util.function.Function;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersArr = scanner.nextLine().split(", ");

        Function<String, Integer> function = Integer::parseInt;

        int sum = Arrays.stream(numbersArr).mapToInt(function::apply).sum();
        System.out.printf("Count = %d%n", numbersArr.length);
        System.out.printf("Sum = %d", sum);
    }
}
