import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split("\\|");

        String firstPartRegex = "([#$%*&]+)[A-Z]+\\1";
        Pattern firstPartPattern = Pattern.compile(firstPartRegex);
        Matcher firstPartMatcher = firstPartPattern.matcher(input[0]);
        String capitalLetters = "";
        while (firstPartMatcher.find()) {
            capitalLetters = firstPartMatcher.group();
            capitalLetters = capitalLetters.substring(1, capitalLetters.length() - 1);
        }

        String secondPartRegex = "[\\d]{2}:[\\d]{2}";
        Pattern secondPartPatter = Pattern.compile(secondPartRegex);
        Matcher secondPartMatcher = secondPartPatter.matcher(input[1]);
        List<String> matcher = new ArrayList<>();
        while (secondPartMatcher.find()) {
            matcher.add(secondPartMatcher.group());
        }

        List<String> letterAndLength = new ArrayList<>();
        for (int i = 0; i < capitalLetters.length(); i++) {
            char letter = capitalLetters.charAt(i);
            for (int j = 0; j < matcher.size(); j++) {
                String code = matcher.get(j).substring(0, 2);
                int currentCode = Integer.parseInt(code);
                if (letter == currentCode) {
                    letterAndLength.add(matcher.get(j));
                    break;
                }
            }

        }

        String[] words = input[2].split(" ");
        List<String> extractedWords = new ArrayList<>();
        for (int i = 0; i < letterAndLength.size(); i++) {
            int letterCode = Integer.parseInt(letterAndLength.get(i).substring(0,2));
            int length = Integer.parseInt(letterAndLength.get(i).substring(3));
            for (int j = 0; j < words.length; j++) {
                int asciiCode = words[j].charAt(0);
                if (letterCode == asciiCode && length + 1 == words[j].length()) {
                    extractedWords.add(words[j]);
                    break;
                }
            }
        }
        extractedWords.forEach(System.out::println);

    }
}
