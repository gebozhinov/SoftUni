package functionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(numbersList.stream().filter(e -> e % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        System.out.println(numbersList.stream().filter(e -> e % 2 == 0)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

    }
}
