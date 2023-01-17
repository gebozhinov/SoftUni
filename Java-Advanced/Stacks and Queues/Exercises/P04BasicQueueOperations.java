package setsAndMapsAdvanced.exercises.stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int s = input[1];
        int x = input[2];

        int[] numArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        Arrays.stream(numArr).forEach(numbers::offer);

        for (int i = 0; i < s; i++) {
            numbers.poll();
        }
        if (numbers.contains(x)) {
            System.out.println("true");
        } else {
            int min;
            if (numbers.isEmpty()) {
                min = 0;
            } else {
                min = Collections.min(numbers);
            }
            System.out.println(min);
        }

    }
}
