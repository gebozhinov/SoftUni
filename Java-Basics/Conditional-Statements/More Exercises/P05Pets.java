import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int foodLeft = Integer.parseInt(scanner.nextLine());
        double dogFoodKg = Double.parseDouble(scanner.nextLine());
        double catFoodKg = Double.parseDouble(scanner.nextLine());
        double turtleFoodGr = Double.parseDouble(scanner.nextLine());

        double totalFoodEaten = (dogFoodKg + catFoodKg + (turtleFoodGr / 1000)) * days;
        if (foodLeft >= totalFoodEaten) {
            System.out.printf("%.0f kilos of food left.", Math.floor(foodLeft - totalFoodEaten));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(totalFoodEaten - foodLeft));
        }
    }
}
