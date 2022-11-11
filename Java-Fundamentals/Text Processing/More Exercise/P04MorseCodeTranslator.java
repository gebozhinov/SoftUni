import java.util.Scanner;

public class P04MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] english = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."};

        StringBuilder message = new StringBuilder();

        String[] input = scanner.nextLine().split(" ");
        for (String inputString : input) {
            for (int i = 0; i < morse.length; i++) {
                if (inputString.equals(morse[i])) {
                    String decode = english[i];
                    message.append(decode);
                    break;
                } else if (inputString.equals("|")) {
                    message.append(" ");
                    break;
                }
            }
        }
        System.out.println(message);
    }
}
