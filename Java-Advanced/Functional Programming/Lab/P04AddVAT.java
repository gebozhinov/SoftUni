package functionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Double> numbersList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Function<Double, Double> function = number -> number * 1.2;

        System.out.println("Prices with VAT:");
        numbersList.forEach(num -> System.out.printf("%.2f%n", function.apply(num)));


    }
}
