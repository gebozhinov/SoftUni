import java.util.Scanner;

public class SafePasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int maxPasswords = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        for (int i = 35; i <= 55; i++) {
            for (int j = 64; j <= 96; j++) {
                for (int k = 1; k <= a; k++) {
                    for (int l = 1; l <= b; l++) {
                        System.out.printf("%s%s%d%d%s%s|", Character.toString(i), Character.toString(j), k, l,
                                Character.toString(j), Character.toString(i));
                        i++;
                        j++;
                        if (i > 55) {
                            i = 35;
                        }
                        if (j > 96) {
                            j = 64;
                        }
                        counter++;
                        if (counter == maxPasswords) {
                            return;
                        }
                        if (k == a && l == b) {
                            return;
                        }
                    }
                }
            }
        }
    }
}
