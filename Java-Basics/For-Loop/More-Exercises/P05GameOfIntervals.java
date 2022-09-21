import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moves = Integer.parseInt(scanner.nextLine());
        double points = 0;
        double bellowTen = 0;
        double bellowTwenty = 0;
        double bellowThirty = 0;
        double bellowForty = 0;
        double bellowFifty = 0;
        double invalidNumber = 0;
        for (int i = 0; i < moves; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 0 || number > 50) {
                points /= 2;
                invalidNumber++;
            } else if (number < 10) {
                points += number * 0.2;
                bellowTen++;
            } else if (number < 20) {
                points += number * 0.3;
                bellowTwenty++;
            } else if (number < 30) {
                points += number * 0.4;
                bellowThirty++;
            } else if (number < 40) {
                points += 50;
                bellowForty++;
            } else {
                points += 100;
                bellowFifty++;
            }
        }
        System.out.printf("%.2f%n", points);
        System.out.printf("From 0 to 9: %.2f%%%n", bellowTen / moves * 100);
        System.out.printf("From 10 to 19: %.2f%%%n", bellowTwenty / moves * 100);
        System.out.printf("From 20 to 29: %.2f%%%n", bellowThirty / moves * 100);
        System.out.printf("From 30 to 39: %.2f%%%n", bellowForty / moves * 100);
        System.out.printf("From 40 to 50: %.2f%%%n", bellowFifty / moves * 100);
        System.out.printf("Invalid numbers: %.2f%%%n", invalidNumber / moves * 100);
    }
}
