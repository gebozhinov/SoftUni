import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        charactersInRange(firstChar, secondChar);


    }

    public static void charactersInRange(char first, char second) {
        if (second > first) {
            for (int i = first + 1; i < second; i++) {
                System.out.printf("%c ", i);
            }
        } else {
            for (int i = second + 1; i < first; i++) {
                System.out.printf("%c ", i);
            }
        }
    }
}
