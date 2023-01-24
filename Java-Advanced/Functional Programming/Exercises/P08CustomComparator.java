package functionalProgramming.exercises;

import java.util.Arrays;

import java.util.Comparator;
import java.util.Scanner;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
//                .mapToInt(Integer::parseInt).toArray();
        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);

//        int[] evenNumbers = Arrays.stream(numbers).boxed()
//                .filter(e -> e % 2 == 0)
//                .sorted()
//                .mapToInt(Integer::intValue)
//                .toArray();
//        int[] oddNumbers = Arrays.stream(numbers).boxed()
//                .filter(e -> e % 2 != 0)
//                .sorted()
//                .mapToInt(Integer::intValue)
//                .toArray();
//
//        Arrays.stream(evenNumbers).forEach(e -> System.out.print(e + " "));
//        Arrays.stream(oddNumbers).forEach(e -> System.out.print(e + " "));

        Comparator<Integer> comparator = (num1, num2) -> {
            if (num1 % 2 == 0 && num2 % 2 != 0) {
                return -1;
            } else if (num1 % 2 != 0 && num2 % 2 == 0) {
                return 1;
            } else {
                return num1.compareTo(num2);
            }
        };

        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(e -> System.out.printf("%d ", e));

    }
}
