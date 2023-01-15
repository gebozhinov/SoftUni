package exam.mid;

import java.util.Scanner;

public class P02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\|");
        int bestDungeon = 1;
        int health = 100;
        int bitcoin = 0;
        boolean isDead = false;
        for (String dungeon : inputArr) {
            String currentDungeon = dungeon.split(" ")[0];
            int number = Integer.parseInt(dungeon.split(" ")[1]);
            switch (currentDungeon) {
                case "potion":
                    int healAmount = number;
                    if (healAmount + health > 100) {
                        healAmount = 100 - health;
                    }
                    health += healAmount;
                    System.out.printf("You healed for %d hp.%n", healAmount);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    System.out.printf("You found %d bitcoins.%n", number);
                    bitcoin += number;
                    break;
                default:
                    health -= number;
                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", currentDungeon);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", currentDungeon);
                        System.out.printf("Best room: %d%n", bestDungeon);
                        isDead = true;
                        break;
                    }
                    break;
            }
            if (isDead) {
                break;
            }
            bestDungeon++;
        }

        if (!isDead) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoin);
            System.out.printf("Health: %d%n", health);
        }
    }
}
