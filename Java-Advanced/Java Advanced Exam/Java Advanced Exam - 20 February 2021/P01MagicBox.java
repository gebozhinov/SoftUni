package exam.february2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] first = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        for (int n : first) {
            firstBox.offer(n);
        }

        int[] second = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        for (int n : second) {
            secondBox.push(n);
        }

        int total = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstItem = firstBox.peek();
            int secondItem = secondBox.peek();
            int sum = firstItem + secondItem;

            if (sum % 2 == 0) {
                total += sum;
                firstBox.poll();
                secondBox.pop();
            } else {
                firstBox.offer(secondBox.pop());
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (total >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", total);
        } else {
            System.out.printf("Poor prey... Value: %d%n", total);
        }
    }
}
