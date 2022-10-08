import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        char s1 = scanner.nextLine().charAt(0);
        char s2 = scanner.nextLine().charAt(0);
        char s3 = scanner.nextLine().charAt(0);

        System.out.printf("%c%c%c", s1, s2, s3);


    }
}
