import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> charSymbol = new LinkedHashMap<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            String symbol = String.valueOf(input.charAt(i));
            if (!symbol.equals(" ")) {
                charSymbol.putIfAbsent(symbol, 0);
                int countChars = charSymbol.get(symbol);
                charSymbol.put(symbol, countChars + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : charSymbol.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
