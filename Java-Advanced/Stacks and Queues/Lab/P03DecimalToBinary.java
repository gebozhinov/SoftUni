package setsAndMapsAdvanced.exercises.stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        while (n > 0) {
            if (n % 2 == 0) {
                binary.push(0);
            } else {
                binary.push(1);
            }
            n /= 2;
        }

        binary.stream().forEach(e -> System.out.print(binary.pop()));

    }
}
