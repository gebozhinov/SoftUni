package exam.august2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lilies = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        for (int n : lilies) {
            liliesStack.push(n);
        }

        int[] roses = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        for (int n : roses) {
            rosesQueue.offer(n);
        }

        int wreaths = 0;
        int flowersLeft = 0;
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int lastLilie = liliesStack.pop();
            int firstRose = rosesQueue.poll();
            int sum = lastLilie + firstRose;

            if (sum == 15) {
                wreaths++;
            } else {
                while (true) {
                    if (lastLilie + firstRose == 15) {
                        wreaths++;
                        break;
                    } else if (lastLilie + firstRose < 15) {
                        flowersLeft += lastLilie + firstRose;
                        break;
                    }
                    lastLilie -= 2;
                }
            }
        }
        wreaths += flowersLeft / 15;
        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreaths);
        }

    }
}
