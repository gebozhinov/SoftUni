package functionalProgramming.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

//        Function<int[], Integer> function = n -> {
//            int minNum = Integer.MAX_VALUE;
//            for (int num : numbers) {
//                if (num < minNum) {
//                    minNum = num;
//                }
//            }
//            return minNum;
//        };

//        Function<int[], Integer> function = arr -> Arrays.stream(arr).min().getAsInt();

        Function<int[], Integer> function = arr -> Collections.min(Arrays.stream(arr).boxed().collect(Collectors.toList()));

        int min = function.apply(numbers);
        System.out.println(min);
    }
}
