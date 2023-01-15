package exam.finale.april2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        String regex = "([@#])(?<word1>[A-Za-z]{3,})\\1\\1(?<word2>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        List<String> resultList = new ArrayList<>();
        while (matcher.find()) {
            String firstWord = matcher.group("word1");
            String secondWord = matcher.group("word2");
            count++;
            resultList.add(firstWord + " <=> " + secondWord);
        }
        List<String> viceVersaWords = new ArrayList<>();
        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", count);
            for (String word : resultList) {
                String firstWord = word.split(" <=> ")[0];
                String secondWord = word.split(" <=> ")[1];
                if (isWordsViceVersa(firstWord, secondWord)) {
                    viceVersaWords.add(firstWord + " <=> " + secondWord);
                }
            }
        }
        if (viceVersaWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", viceVersaWords));
        }


    }

    public static boolean isWordsViceVersa(String firstWord, String secondWord) {
        String backWords = "";
        for (int i = secondWord.length() - 1; i >= 0; i--) {
            char symbol = secondWord.charAt(i);
            backWords += symbol;
        }
        return firstWord.equals(backWords);
    }
}
