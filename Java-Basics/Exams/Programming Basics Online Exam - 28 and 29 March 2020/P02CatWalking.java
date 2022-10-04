import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutes = Integer.parseInt(scanner.nextLine());
        int amount = Integer.parseInt(scanner.nextLine());
        int calories = Integer.parseInt(scanner.nextLine());

        int caloriesBurn = minutes * amount * 5;
        if (caloriesBurn >= calories * 0.5) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", caloriesBurn);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", caloriesBurn);
        }
    }
}
