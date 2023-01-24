package setsAndMapsAdvanced.exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> userSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String username = scanner.nextLine();
            userSet.add(username);
        }
        userSet.forEach(System.out::println);

    }
}
