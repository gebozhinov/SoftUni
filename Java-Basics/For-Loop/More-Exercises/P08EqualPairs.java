import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumFirst = 0;
        int sumSecond = 0;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                sumFirst = sumSecond;
            }
            int n1 = Integer.parseInt(scanner.nextLine());
            int n2 = Integer.parseInt(scanner.nextLine());
            sumSecond = n1 + n2;
            int diff = sumFirst - sumSecond;
            if (Math.abs(diff) > maxDiff) {
                maxDiff = diff;
            }
        }
        if (sumFirst == sumSecond || n == 1) {
            System.out.printf("Yes, value=%d", sumSecond);
        } else {
            System.out.printf("No, maxdiff=%d", Math.abs(maxDiff));
        }
    }
}
