import java.util.Scanner;

public class House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        int stars;
        if (n % 2 == 0) {
            stars = 2;
        } else {
            stars = 1;
        }
        int slash = (n - stars) / 2;
        for (int i = 0; i < Math.ceil(n / 2.0); i++) {
            System.out.print(repeatString("-", slash));
            System.out.print(repeatString("*", stars));
            System.out.println(repeatString("-", slash));
            slash--;
            stars += 2;
        }

        stars -= 4;
        for (int i = 0; i < Math.floor(n / 2.0); i++) {
            System.out.print("|");
            System.out.print(repeatString("*", stars));
            System.out.println("|");
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
