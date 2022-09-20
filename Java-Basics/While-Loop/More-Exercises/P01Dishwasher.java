import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int detergentBottles = Integer.parseInt(scanner.nextLine());
        int detergentMl = detergentBottles * 750;
        int dishwasher = 0;
        int plates = 0;
        int pots = 0;
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int dishes = Integer.parseInt(input);
            dishwasher++;
            if (dishwasher % 3 != 0) {
                plates += dishes;
                detergentMl -= dishes * 5;
            } else {
                pots += dishes;
                detergentMl -= dishes * 15;
            }
            if (detergentMl < 0) {
                break;
            }
            input = scanner.nextLine();
        }
        if (input.equals("End")) {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", plates, pots);
            System.out.printf("Leftover detergent %d ml.", detergentMl);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(detergentMl));
        }
    }
}
