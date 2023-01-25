package basicAlgorithms;

import java.util.Scanner;

public class P02RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(calcFact(n));
    }
    public static long calcFact(int n) {
        if (n <= 2) {
            return n;
        }
        return n * calcFact(n - 1);
    }
}
