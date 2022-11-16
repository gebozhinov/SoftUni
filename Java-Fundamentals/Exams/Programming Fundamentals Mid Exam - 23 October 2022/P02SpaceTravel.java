import java.util.Scanner;

public class SpaceTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|\\|");
        int startingFuel = Integer.parseInt(scanner.nextLine());
        int startingAmmo = Integer.parseInt(scanner.nextLine());
        boolean isMissionFailed = false;
        for (int i = 0; i < input.length; i++) {
            String command = input[i].split(" ")[0];
            if (command.equals("Titan")) {
                System.out.println("You have reached Titan, all passengers are safe.");
                break;
            }
            int num = Integer.parseInt(input[i].split(" ")[1]);

            switch (command) {
                case "Travel":
                    if (startingFuel - num >= 0) {
                        System.out.printf("The spaceship travelled %d light-years.%n", num);
                        startingFuel -= num;
                    } else {
                        System.out.println("Mission failed.");
                        isMissionFailed = true;
                        break;
                    }
                    break;
                case "Enemy":
                    if (startingAmmo >= num) {
                        System.out.printf("An enemy with %d armour is defeated.%n", num);
                        startingAmmo -= num;
                    } else {
                        if (startingFuel > num * 2) {
                            System.out.printf("An enemy with %d armour is outmaneuvered.%n", num);
                            startingFuel -= num * 2;
                        } else {
                            System.out.println("Mission failed.");
                            isMissionFailed = true;
                            break;
                        }
                    }
                    break;
                case "Repair":
                    startingFuel += num;
                    startingAmmo += num * 2;
                    System.out.printf("Ammunitions added: %d.%n", num * 2);
                    System.out.printf("Fuel added: %d.%n", num);
                    break;
            }

            if (isMissionFailed) {
                break;
            }
        }


    }
}
