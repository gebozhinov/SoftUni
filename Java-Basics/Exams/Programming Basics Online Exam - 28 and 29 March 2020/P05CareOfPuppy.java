import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int foodKg = Integer.parseInt(scanner.nextLine());
        int footGr = foodKg * 1000;
        String command = scanner.nextLine();
        int totalFoodEaten = 0;
        while (!command.equals("Adopted")) {
            int foodEaten = Integer.parseInt(command);
            totalFoodEaten += foodEaten;

            command = scanner.nextLine();
        }
        if (footGr >= totalFoodEaten) {
            System.out.printf("Food is enough! Leftovers: %d grams.", footGr - totalFoodEaten);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", totalFoodEaten - footGr);
        }
    }
}
