package exam.mid.april2020;

import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int wonBattles = 0;
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (initialEnergy >= distance) {
                initialEnergy -= distance;
                wonBattles++;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", wonBattles, initialEnergy);
                break;
            }
            if (wonBattles % 3 == 0) {
                initialEnergy += wonBattles;
            }

            input = scanner.nextLine();
        }
        if (input.equals("End of battle")) {
            System.out.printf("Won battles: %d. Energy left: %d%n", wonBattles, initialEnergy);
        }
    }
}
