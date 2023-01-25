package generics.exercises.genericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GenericBox genericBox = new GenericBox();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            genericBox.add(input);
        }

        System.out.print(genericBox);

    }
}
