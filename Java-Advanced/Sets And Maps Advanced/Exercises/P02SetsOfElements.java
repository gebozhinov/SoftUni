package setsAndMapsAdvanced.exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        int m = Integer.parseInt(input.split(" ")[1]);
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));

    }
}
