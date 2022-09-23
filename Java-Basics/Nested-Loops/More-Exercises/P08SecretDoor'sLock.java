import java.util.Scanner;

public class SecretDoorsLock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= n1; i++) {
            for (int j = 2; j <= n2; j++) {
                for (int k = 2; k <= n3; k++) {
                    if (i % 2 == 0 && k % 2 == 0) {
                        if (j == 2 || j == 3 | j == 5 || j == 7) {
                            System.out.printf("%d %d %d%n", i, j, k);
                        }
                    }
                }
            }
        }
    }
}
