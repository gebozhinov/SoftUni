import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int spaces = n - 1;

        for (int i = 1; i <= n; i++) {
            System.out.print(repeatString(" ", spaces) + repeatString("* ", i));
            System.out.println();
            spaces--;
        }
        spaces++;
        for (int i = n - 1; i > 0; i--) {
            spaces++;
            System.out.print(repeatString(" ", spaces) + repeatString("* ", i));
            System.out.println();
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
