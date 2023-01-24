package setsAndMapsAdvanced.exercises;

import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        TreeMap<Character, Integer> countSymbols = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            countSymbols.putIfAbsent(symbol, 0);
            countSymbols.put(symbol, countSymbols.get(symbol) + 1);
        }
        countSymbols.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));

    }
}
