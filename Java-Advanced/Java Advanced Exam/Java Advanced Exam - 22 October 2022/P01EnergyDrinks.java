package exam.october2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;


public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> milligramsOfCoffin = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(milligramsOfCoffin::push);

        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(energyDrinks::offer);

        int initialCoffin = 0;
        while (!milligramsOfCoffin.isEmpty() && !energyDrinks.isEmpty()) {
            int lastDrink = energyDrinks.pop();
            int coffin = milligramsOfCoffin.pop() * lastDrink;

            if (coffin + initialCoffin <= 300) {
                initialCoffin += coffin;
            } else {
                energyDrinks.offer(lastDrink);
                initialCoffin -= 30;
                if (initialCoffin < 0) {
                    initialCoffin = 0;
                }
            }

        }

        if (!energyDrinks.isEmpty()) {
            System.out.print("Drinks left: ");
            StringBuilder sb = new StringBuilder();
            for (int n : energyDrinks) {
                sb.append(n).append(", ");
            }
            sb.replace(sb.length() - 2, sb.length(), "");
            System.out.println(sb);
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", initialCoffin);
    }
}
