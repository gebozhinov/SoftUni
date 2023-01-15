package exam.mid;

import java.util.Arrays;
import java.util.Scanner;

public class P03ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt).toArray();
        int[] warship = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt).toArray();
        int health = Integer.parseInt(scanner.nextLine());

        boolean isStalemate = true;
        String input = scanner.nextLine();
        while (!input.equals("Retire")) {
            String command = input.split(" ")[0];
            switch (command) {
                case "Fire":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    int damageFire = Integer.parseInt(input.split(" ")[2]);
                    if (index >= 0 && index < warship.length) {
                        warship[index] -= damageFire;
                        if (warship[index] <= 0) {
                            isStalemate = false;
                            System.out.println("You won! The enemy ship has sunken.");
                            break;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(input.split(" ")[1]);
                    int endIndex = Integer.parseInt(input.split(" ")[2]);
                    int damageDefend = Integer.parseInt(input.split(" ")[3]);
                    if ((startIndex >= 0 && endIndex >= 0) && (startIndex < pirateShip.length && endIndex < pirateShip.length)) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip[i] -= damageDefend;
                            if (pirateShip[i] <= 0) {
                                isStalemate = false;
                                System.out.println("You lost! The pirate ship has sunken.");
                                break;
                            }

                        }
                    }
                    break;
                case "Repair":
                    int repairIndex = Integer.parseInt(input.split(" ")[1]);
                    int repairHealth = Integer.parseInt(input.split(" ")[2]);
                    if (repairIndex >= 0 && repairIndex < pirateShip.length) {
                        if (pirateShip[repairIndex] + repairHealth > health) {
                            pirateShip[repairIndex] = health;
                        } else {
                            pirateShip[repairIndex] += repairHealth;
                        }
                    }
                    break;
                case "Status":
                    int count = 0;
                    for (int section : pirateShip) {
                        if (section < health * 0.2) {
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
            }

            if (!isStalemate) {
                break;
            }
            input = scanner.nextLine();
        }

        if (isStalemate) {
            int pirateShipSum = getShipSum(pirateShip);
            int warshipSum = getShipSum(warship);
            System.out.printf("Pirate ship status: %d%n", pirateShipSum);
            System.out.printf("Warship status: %d%n", warshipSum);
        }
    }

    public static int getShipSum(int[] ship) {
        int sum = 0;
        for (int section : ship) {
            sum += section;
        }
        return sum;
    }
}
