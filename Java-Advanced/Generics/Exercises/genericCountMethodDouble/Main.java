package generics.exercises.genericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Double> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(scanner.nextLine());
            box.add(num);
        }

        double toCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(box.compare(toCompare));
    }
}
