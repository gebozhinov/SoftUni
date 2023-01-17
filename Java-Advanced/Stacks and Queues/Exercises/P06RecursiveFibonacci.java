package setsAndMapsAdvanced.exercises.stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> fib = new ArrayDeque<>();
        fib.push(1L);
        fib.push(1L);
        for (int i = 0; i < n; i++) {
            long currentFib = fib.pop();
            long sum = currentFib + fib.pop();
            fib.push(currentFib);
            fib.push(sum);
        }
        fib.pop();
        System.out.println(fib.pop());
    }
}
