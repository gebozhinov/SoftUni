package generics.exercises.genericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GenericBoxOfInteger<Integer> genericBoxOfInteger = new GenericBoxOfInteger<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            genericBoxOfInteger.add(num);
        }

        System.out.print(genericBoxOfInteger);

    }
}
