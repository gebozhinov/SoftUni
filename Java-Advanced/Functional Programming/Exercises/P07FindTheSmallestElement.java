package functionalProgramming.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> function = list -> {
            int index = 0;
            int smallestNum = numbers.get(0);
            for (int i = 1; i < numbers.size(); i++) {
                int currentNum = numbers.get(i);
                if (currentNum <= smallestNum) {
                    smallestNum = currentNum;
                    index = i;
                }
            }
            return index;
        };

        System.out.println(function.apply(numbers));


    }
}
