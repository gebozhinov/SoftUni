package setsAndMapsAdvanced.exercises.stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> numbers = new ArrayDeque<>();
        Arrays.stream(input).forEach(numbers::push);
        numbers.forEach(e -> System.out.print(numbers.pop() + " "));
    }
}
