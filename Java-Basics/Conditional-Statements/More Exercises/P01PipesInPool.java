import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poolArea = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double bothPipes = (p1 + p2) * h;

        if (bothPipes <= poolArea) {
            double poolPercent = bothPipes / poolArea * 100;
            double p1Percent = (p1 * h) / bothPipes * 100;
            double p2Percent = (p2 * h) / bothPipes * 100;
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", poolPercent, p1Percent, p2Percent);
        }else {
            double poolOverflow = bothPipes - poolArea;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, poolOverflow);
        }
    }
}
