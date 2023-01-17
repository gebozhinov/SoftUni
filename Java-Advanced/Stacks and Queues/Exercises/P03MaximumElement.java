package setsAndMapsAdvanced.exercises.stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String command = input.split(" ")[0];
            switch (command) {
                case "1":
                    int num = Integer.parseInt(input.split(" ")[1]);
                    numbers.push(num);
                    break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    int max = Collections.max(numbers);
                    System.out.println(max);
                    break;
            }
        }


    }
}
