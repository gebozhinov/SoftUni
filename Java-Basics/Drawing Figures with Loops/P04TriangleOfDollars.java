import java.util.Scanner;

public class TriangleOfDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.print(repeatString("$ ", i));
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
