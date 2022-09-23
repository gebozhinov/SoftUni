import java.util.Scanner;

public class PrimePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startFirstPair = Integer.parseInt(scanner.nextLine());
        int startSecondPair = Integer.parseInt(scanner.nextLine());
        int diffFirstPair = Integer.parseInt(scanner.nextLine());
        int diffSecondPair = Integer.parseInt(scanner.nextLine());

        for (int i = startFirstPair; i <= startFirstPair + diffFirstPair; i++) {
            for (int j = startSecondPair; j <= startSecondPair + diffSecondPair; j++) {
                int n1 = 2;
                boolean isN1Prime = true;
                boolean isN2Prime = true;
                while (n1 < i / 2) {
                    int n2 = 2;
                    if (i % n1 == 0) {
                        isN1Prime = false;
                        break;
                    }
                    while (n2 < j / 2) {
                        if (j % n2 == 0) {
                            isN2Prime = false;
                            break;
                        }
                        n2++;
                    }
                    n1++;
                }
                if (isN1Prime && isN2Prime) {
                    System.out.printf("%d%d%n", i, j);
                }
            }
        }
    }
}
