package setsAndMapsAdvanced.exercises.stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, input);
        int n = Integer.parseInt(scanner.nextLine());
        int i = 1;
        while (children.size() > 1) {
            String person = children.poll();
            if (i == n) {
                i = 1;
                System.out.printf("Removed %s%n", person);
            } else {
                i++;
                children.offer(person);
            }

        }
        children.forEach(e -> System.out.printf("Last is %s", children.poll()));
    }
}
