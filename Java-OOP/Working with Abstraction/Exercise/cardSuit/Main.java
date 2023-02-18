package workingWithAbstraction.exercise.cardSuit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("workingWithAbstraction.exercise.cardsWithPower.Card Suits:");

        Arrays.stream(CardSuit.values())
                .forEach(e -> System.out.printf("Ordinal value: %d; Name value: %s%n", e.ordinal(), e.name()));
    }
}
