import java.util.Scanner;

public class TouristShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());

        double totalPrice = 0;
        int productCount = 0;
        String product = scanner.nextLine();
        while (!product.equals("Stop")) {
            double productPrice = Double.parseDouble(scanner.nextLine());
            productCount++;
            if (productCount % 3 == 0) {
                totalPrice += productPrice * 0.5;
            } else {
                totalPrice += productPrice;
            }
            if (totalPrice > budget) {
                break;
            }
            product = scanner.nextLine();
        }
        if (product.equals("Stop")) {
            System.out.printf("You bought %d products for %.2f leva.", productCount, totalPrice);
        } else {
            System.out.println("You don't have enough money!");
            System.out.printf("You need %.2f leva!", totalPrice - budget);
        }
    }
}
