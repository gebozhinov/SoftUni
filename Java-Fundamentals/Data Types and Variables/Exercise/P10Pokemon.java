import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int target = 0;
        double halfN = n * 0.5;

        while (n >= m) {
            n -= m;
            target++;
            if (halfN == n && y != 0) {
                n /= y;
            }
        }
        System.out.println(n);
        System.out.println(target);

    }
}
