package generics.exercises.genericSwapMethodInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Integer> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            box.add(num);
        }

        String input = scanner.nextLine();
        int firstIndex = Integer.parseInt(input.split(" ")[0]);
        int secondIndex = Integer.parseInt(input.split(" ")[1]);
        box.swap(firstIndex, secondIndex);
        System.out.println(box);

    }
}
