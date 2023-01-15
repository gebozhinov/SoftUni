package exam.finale.april2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        String regexThreshold = "\\d";
        Pattern patternThreshold = Pattern.compile(regexThreshold);
        Matcher matcherThreshold = patternThreshold.matcher(input);
        int threshold = 1;
        while (matcherThreshold.find()) {
            int currentNumber = Integer.parseInt(matcherThreshold.group());
            threshold = threshold * currentNumber;
        }

        String regex = "([\\::]{2}|[**]{2})[A-Z][a-z]{2,}\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> emojiList = new ArrayList<>();
        while (matcher.find()) {
            String emoji = matcher.group();
            emojiList.add(emoji);
        }

        System.out.printf("Cool threshold: %d%n", threshold);
        if (!emojiList.isEmpty()) {
            System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiList.size());
            for (int i = 0; i < emojiList.size(); i++) {
                int cool = 0;
                String currentEmoji = emojiList.get(i);
                for (int j = 0; j < currentEmoji.length(); j++) {
                    char letter = currentEmoji.charAt(j);
                    if (Character.isLetter(letter)) {
                        cool += letter;
                    }
                }
                if (cool > threshold) {
                    System.out.println(currentEmoji);
                }
            }
        }
    }
}
