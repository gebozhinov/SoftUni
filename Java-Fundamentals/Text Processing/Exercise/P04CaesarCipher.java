import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char symbol = (char) (input.charAt(i) + 3);
            encrypted.append(symbol);
        }

        System.out.println(encrypted);
    }
}
