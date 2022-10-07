import java.util.Arrays;
import java.util.Scanner;

public class P01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        int num;

        if (n1 < n2) {
            num = n1;
            n1 = n2;
            n2 = num;
        }
        if (n1 < n3) {
            num = n1;
            n1 = n3;
            n3 = num;
        }
        if (n2 < n3) {
            num = n2;
            n2 = n3;
            n3 = num;
        }
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

    }
}
