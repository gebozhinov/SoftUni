package setsAndMapsAdvanced.exercises;

import java.util.*;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, HashSet<String>> playersMap = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String[] value = input.split(": ")[1].split(", ");
            playersMap.putIfAbsent(name, new HashSet<>());
            Collections.addAll(playersMap.get(name), value);
            input = scanner.nextLine();
        }

        for (var player : playersMap.entrySet()) {
            int totalValue = getValue(player.getValue());
            System.out.println(player.getKey() + ": " + totalValue);
        }


    }

    private static int getValue(HashSet<String> value) {
        int totalValue = 0;
        for (String currentCard : value) {
            String power = currentCard.substring(0, currentCard.length() - 1);
            char type = currentCard.charAt(currentCard.length() - 1);
            int currentCardValue;
            switch (power) {
                case "J":
                    currentCardValue = 11;
                    break;
                case "Q":
                    currentCardValue = 12;
                    break;
                case "K":
                    currentCardValue = 13;
                    break;
                case "A":
                    currentCardValue = 14;
                    break;
                default:
                    currentCardValue = Integer.parseInt(power);
                    break;
            }
            switch (type) {
                case 'S':
                    currentCardValue *= 4;
                    break;
                case 'H':
                    currentCardValue *= 3;
                    break;
                case 'D':
                    currentCardValue *= 2;
                    break;
            }
            totalValue += currentCardValue;
        }
        return totalValue;
    }


}
