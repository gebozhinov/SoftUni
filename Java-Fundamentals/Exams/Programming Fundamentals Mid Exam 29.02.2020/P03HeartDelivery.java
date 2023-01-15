package exam.mid.february2020;

import java.util.Arrays;
import java.util.Scanner;

public class P03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] houses = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int currentPlace = 0;
        while (!input.equals("Love!")) {
            int jump = Integer.parseInt(input.split(" ")[1]);
            int currentJump = jump + currentPlace;
            currentPlace = currentJump;
            if (currentJump >= houses.length) {
                currentJump = 0;
                currentPlace = 0;
            }
            if (houses[currentJump] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", currentJump);
                input = scanner.nextLine();
                continue;
            }
            houses[currentJump] -= 2;
            if (houses[currentJump] <= 0) {
                System.out.printf("Place %d has Valentine's day.%n", currentJump);
            }


            input = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", currentPlace);
        int countOfHouses = getHousesThatDoNotCelebrate(houses);
        if (countOfHouses > 0) {
            System.out.printf("Cupid has failed %d places.%n", countOfHouses);
        } else {
            System.out.println("Mission was successful.");
        }

    }

    public static int getHousesThatDoNotCelebrate(int[] houses) {
        int count = 0;
        for (int house : houses) {
            if (house > 0) {
                count++;
            }
        }
        return count;
    }
}
