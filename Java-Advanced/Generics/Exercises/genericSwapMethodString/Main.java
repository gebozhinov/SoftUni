package generics.exercises.genericSwapMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<String> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            box.add(input);
        }

        String input = scanner.nextLine();
        int firstIndex = Integer.parseInt(input.split(" ")[0]);
        int secondIndex = Integer.parseInt(input.split(" ")[1]);

        box.swap(firstIndex, secondIndex);
        System.out.print(box);

    }
}
