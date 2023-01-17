package setsAndMapsAdvanced.exercises.stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        ArrayDeque<Integer> index = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '(') {
                index.push(i);
            } else if (symbol == ')') {
                int startIndex = index.pop();
                String substring = input.substring(startIndex, i + 1);
                System.out.println(substring);
            }
        }

    }
}
