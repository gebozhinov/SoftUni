package workingWithAbstraction.exercise.cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rankOfTheCard = scanner.nextLine();
        String suitOfTheCard = scanner.nextLine();

        Card card = new Card(CardSuit.valueOf(suitOfTheCard), CardRank.valueOf(rankOfTheCard));

        System.out.printf("Card name: %s of %s; Card power: %d%n", rankOfTheCard, suitOfTheCard,
                card.getPower());


    }
}
