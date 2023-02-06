package exam.april2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] tulips = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        for (int n : tulips) {
            tulipsStack.push(n);
        }

        int[] daffodils = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        for (int n : daffodils) {
            daffodilsQueue.offer(n);
        }

        int bouquets = 0;
        int flowersLeft = 0;
        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int lastTulip = tulipsStack.pop();
            int fistDaffodil = daffodilsQueue.poll();
            int sum = lastTulip + fistDaffodil;

            if (sum == 15) {
                bouquets++;
            } else {
                while (true) {
                    if (lastTulip + fistDaffodil == 15) {
                        bouquets++;
                        break;
                    } else if (lastTulip + fistDaffodil < 15) {
                        flowersLeft += lastTulip + fistDaffodil;
                        break;
                    }
                    lastTulip -= 2;
                }
            }
        }

        int totalBouquets = bouquets + (flowersLeft / 15);
        if (totalBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", totalBouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - totalBouquets);
        }

    }
}
