package workingWithAbstraction.exercise.greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long input = Long.parseLong(scanner.nextLine());
        String[] vault = scanner.nextLine().split("\\s+");

        Bag bag = new Bag();

        for (int i = 0; i < vault.length; i += 2) {
            String name = vault[i];
            long amount = Long.parseLong(vault[i + 1]);

            Item item = new Item(name);
            bag.setItem(item);

            if (item.getItem().equals("") || bag.isFull(input, amount)) {
                continue;
            }

            switch (item.getItem()) {
                case "Gem":
                    if (bag.isRuleKept("Gold", amount)) continue;
                    break;
                case "Cash":
                    if (bag.isRuleKept("Gem", amount)) continue;
                    break;
            }

            bag.putItem(name, amount);

        }

        bag.printResult();
    }
}