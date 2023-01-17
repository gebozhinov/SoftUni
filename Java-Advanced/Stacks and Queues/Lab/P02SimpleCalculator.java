package setsAndMapsAdvanced.exercises.stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> result = new ArrayDeque<>();
        Collections.addAll(result, input);


        int sum = Integer.parseInt(result.pop());
        while (!result.isEmpty()) {
            String getOperator = result.pop();
            if (getOperator.equals("+")) {
                sum += Integer.parseInt(result.pop());
            } else if (getOperator.equals("-")) {
                sum -= Integer.parseInt(result.pop());;
            }

        }
        System.out.println(sum);
    }
}
