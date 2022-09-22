import java.util.Scanner;

public class Sunglasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == n) {
                System.out.print(repeatString("*", n * 2));
                System.out.print(repeatString(" ", n));
                System.out.println(repeatString("*", n * 2));
            } else if (i == Math.ceil(n / 2.0)) {
                System.out.print("*");
                System.out.print(repeatString("/", n * 2 - 2));
                System.out.print("*");
                System.out.print(repeatString("|", n));
                System.out.print("*");
                System.out.print(repeatString("/", n * 2 - 2));
                System.out.print("*");
                System.out.println();

            } else {
                System.out.print("*");
                System.out.print(repeatString("/", n * 2 - 2));
                System.out.print("*");
                System.out.print(repeatString(" ", n));
                System.out.print("*");
                System.out.print(repeatString("/", n * 2 - 2));
                System.out.print("*");
                System.out.println();
            }
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
