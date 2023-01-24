package functionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String condition = scanner.nextLine();
        int low = input[0];
        int high = input[1];

        System.out.println(IntStream.rangeClosed(low, high)
                .boxed()
                .filter(filterNumbersByCondition(condition))
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));


    }

    public static Predicate<Integer> filterNumbersByCondition(String condition) {
        if (condition.equals("odd")) {
            return n -> n % 2 != 0;
        }
        return n -> n % 2 == 0;
    }
}
