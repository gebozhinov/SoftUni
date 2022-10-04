import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double food = Double.parseDouble(scanner.nextLine());

        double biscuits = 0;
        double foodEaten = 0;
        double foodEatenByDog = 0;
        double foodEatenByCat = 0;
        for (int i = 1; i <= days; i++) {
            int dogFood = Integer.parseInt(scanner.nextLine());
            int catFood = Integer.parseInt(scanner.nextLine());
            foodEaten += dogFood + catFood;
            foodEatenByDog += dogFood;
            foodEatenByCat += catFood;
            if (i % 3 == 0) {
                biscuits += (dogFood + catFood) * 0.1;
            }
        }
        double foodEatenPercent = foodEaten / food * 100;
        double foodEatenByDogPercent = foodEatenByDog / foodEaten * 100;
        double foodEatenByCatPercent = foodEatenByCat / foodEaten * 100;

        System.out.printf("Total eaten biscuits: %.0fgr.%n", biscuits);
        System.out.printf("%.2f%% of the food has been eaten.%n", foodEatenPercent);
        System.out.printf("%.2f%% eaten from the dog.%n", foodEatenByDogPercent);
        System.out.printf("%.2f%% eaten from the cat.%n", foodEatenByCatPercent);
    }
}
