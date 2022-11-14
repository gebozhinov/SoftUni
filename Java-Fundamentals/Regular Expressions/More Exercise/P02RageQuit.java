import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P02RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toUpperCase();
        String textRegex = "\\d+";
        List<String> textList = Arrays.stream(input.split(textRegex))
                .collect(Collectors.toList());

        String numRegex = "\\D+";
        List<String> numList = Arrays.stream(input.split(numRegex))
                .collect(Collectors.toList());
        numList.remove("");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < textList.size(); i++) {
            int num = Integer.parseInt(numList.get(i));
            sb.append(String.valueOf(textList.get(i)).repeat(Math.max(0, num)));
        }
        List<Character> uniqueChars = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) {
            char symbol = sb.charAt(i);
            if (!Character.isDigit(symbol) && !uniqueChars.contains(symbol)) {
                uniqueChars.add(symbol);
            }

        }
        System.out.printf("Unique symbols used: %d%n", uniqueChars.size());
        System.out.println(sb);
    }

}
