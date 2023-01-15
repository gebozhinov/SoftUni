package exam.mid.february2020;

import java.util.Scanner;

public class P01GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double food = Double.parseDouble(scanner.nextLine());
        double hay = Double.parseDouble(scanner.nextLine());
        double cover = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());

        double foodGr = food * 1000;
        double hayGr = hay * 1000;
        boolean isEnough = true;
        for (int i = 1; i <= 30; i++) {
            foodGr -= 300;
            if (i % 2 == 0) {
                double amountOfHay = foodGr * 0.05;
                hayGr -= amountOfHay;
            }
            if (i % 3 == 0) {
                double coverQuantity = weight / 3;
                cover -= coverQuantity;
            }
            if (foodGr <= 0 || hayGr <= 0 || cover <= 0) {
                isEnough = false;
                break;
            }
        }

        if (isEnough) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.%n",
                    foodGr / 1000, hayGr / 1000, cover);
        } else {
            System.out.println("Merry must go to the pet store!");
        }

    }
}
