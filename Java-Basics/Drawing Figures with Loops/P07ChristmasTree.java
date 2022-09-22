import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int spaces = n + 1;
        System.out.println(repeatString(" ", spaces) + "|");
        spaces--;
        for (int i = 1; i <= n; i++) {
            spaces--;
            System.out.print(repeatString(" ", spaces));
            System.out.print(repeatString("*", i));
            System.out.print(" | ");
            System.out.println(repeatString("*", i));
        }

    }

    static String repeatString(String stringToRepeat, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += stringToRepeat;
        }
        return text;
    }
}
