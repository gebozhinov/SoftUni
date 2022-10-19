import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        middleCharacter(input);


    }
    public static void middleCharacter (String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            char letter = inputString.charAt(i);
            if (i == inputString.length() / 2) {
                System.out.printf("%c", letter);
            }
            if (inputString.length() % 2 == 0) {
                if (i == inputString.length() / 2 - 1) {
                    System.out.printf("%c", letter);
                }
            }
        }
    }
}
