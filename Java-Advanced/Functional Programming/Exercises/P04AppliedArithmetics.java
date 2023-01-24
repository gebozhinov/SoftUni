package functionalProgramming.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

//        Consumer<List<Integer>> printer = e -> numbers.stream().map(String::valueOf)
//                .forEach(i -> System.out.print(i + " "));

        UnaryOperator<List<Integer>> addFunction = list -> list.stream().map(e -> e + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractFunction = list -> list.stream().map(e -> e - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyFunction = list -> list.stream().map(e -> e * 2).collect(Collectors.toList());
        Consumer<Integer> printer = n -> System.out.printf("%d ", n);
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    numbers = addFunction.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractFunction.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyFunction.apply(numbers);
                    break;
                case "print":
                    numbers.forEach(printer);
                    System.out.println();
                    break;
            }


//            if (input.equals("print")) {
//                printer.accept(numbers);
//                System.out.println();
//            } else {
//                for (int i = 0; i < numbers.size(); i++) {
//                    numbers.set(i, doCalculation(numbers.get(i), input));
//                }
//            }

            input = scanner.nextLine();
        }

    }

//    private static int doCalculation(int integer, String input) {
//        Function<Integer, Integer> addFunction = n -> n + 1;
//        Function<Integer, Integer> multiplyFunction = n -> n * 2;
//        Function<Integer, Integer> subtractFunction = n -> n - 1;
//        switch (input) {
//            case "add":
//                return addFunction.apply(integer);
//            case "multiply":
//                return multiplyFunction.apply(integer);
//            case "subtract":
//                return subtractFunction.apply(integer);
//            default:
//                throw new IllegalArgumentException();
//        }
//    }

}
