import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int line = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < line; i++) {
            char letter = scanner.nextLine().charAt(0);
            letter += key;
            System.out.print(letter);

        }
    }
}
