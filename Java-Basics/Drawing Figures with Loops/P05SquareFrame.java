import java.util.Scanner;

public class SquareFrame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.print("+");
        System.out.print(repeatString(" -", n - 2));
        System.out.println(" +");
        for (int i = 0; i < n - 2; i++) {
            System.out.print("|");
            System.out.print(repeatString(" -", n - 2));
            System.out.println(" |");
        }
        System.out.print("+");
        System.out.print(repeatString(" -", n - 2));
        System.out.println(" +");


    }
    static String repeatString(String stringToRepeat, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += stringToRepeat;
        }
        return text;
    }
}
