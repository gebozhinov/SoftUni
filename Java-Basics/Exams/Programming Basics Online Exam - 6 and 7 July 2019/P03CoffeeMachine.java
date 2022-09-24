import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drinks = scanner.nextLine();
        String sugar = scanner.nextLine();
        int drinksCount = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (drinks) {
            case "Espresso":
                switch (sugar) {
                    case "Without":
                        price = 0.90;
                        break;
                    case "Normal":
                        price = 1;
                        break;
                    case "Extra":
                        price = 1.2;
                        break;
                }
                break;
            case "Cappuccino":
                switch (sugar) {
                    case "Without":
                        price = 1;
                        break;
                    case "Normal":
                        price = 1.2;
                        break;
                    case "Extra":
                        price = 1.6;
                        break;
                }
                break;
            case "Tea":
                switch (sugar) {
                    case "Without":
                        price = 0.5;
                        break;
                    case "Normal":
                        price = 0.6;
                        break;
                    case "Extra":
                        price = 0.7;
                        break;
                }
                break;
        }
        double totalPrice = drinksCount * price;
        if (sugar.equals("Without")) {
            totalPrice *= 0.65;
        }
        if (drinks.equals("Espresso") && drinksCount >= 5) {
            totalPrice *= 0.75;
        }
        if (totalPrice > 15) {
            totalPrice *= 0.8;
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.", drinksCount, drinks, totalPrice);
    }
}
