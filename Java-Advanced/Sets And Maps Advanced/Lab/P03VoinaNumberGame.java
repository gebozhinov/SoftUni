package setsAndMapsAdvanced.lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 0;
        while (rounds <= 50) {
            rounds++;
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
            int firstPlayerNumber = firstDeck.iterator().next();
            firstDeck.remove(firstPlayerNumber);
            int secondPlayerNumber = secondDeck.iterator().next();
            secondDeck.remove(secondPlayerNumber);

            if (firstPlayerNumber > secondPlayerNumber) {
                firstDeck.add(firstPlayerNumber);
                firstDeck.add(secondPlayerNumber);
            } else if (secondPlayerNumber > firstPlayerNumber) {
                secondDeck.add(secondPlayerNumber);
                secondDeck.add(firstPlayerNumber);
            }
        }
        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
