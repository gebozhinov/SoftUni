package setsAndMapsAdvanced.exercises.stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, input);
        int n = Integer.parseInt(scanner.nextLine());
        int i = 1;
        int cycle = 1;
        while (children.size() > 1) {
            for (int j = 1; j < n; j++) {
                String currentChild = children.poll();
                if (currentChild != null) {
                    children.offer(currentChild);
                }
            }
            if (isPrime(cycle)) {
                System.out.printf("Prime %s%n", children.peek());
            } else {
                System.out.printf("Removed %s%n", children.pop());
            }
            cycle++;
        }
        children.forEach(e -> System.out.printf("Last is %s", children.poll()));
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        boolean flag = true;
        for (int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
