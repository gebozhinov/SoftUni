import java.util.Scanner;

public class Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wantedIncome = Integer.parseInt(scanner.nextLine());
        String cocktail = scanner.nextLine();
        double totalPrice = 0;
        while (!cocktail.equals("Party!")) {
            int cocktailsOrder = Integer.parseInt(scanner.nextLine());
            int cocktailPrice = cocktail.length();
            double orderPrice = cocktailPrice * cocktailsOrder;
            if (orderPrice % 2 != 0) {
                orderPrice *= 0.75;
            }
            totalPrice += orderPrice;
            if (totalPrice >= wantedIncome) {
                break;
            }

            cocktail = scanner.nextLine();
        }
        if (cocktail.equals("Party!")) {
            System.out.printf("We need %.2f leva more.%n", wantedIncome - totalPrice);
        } else {
            System.out.println("Target acquired.");
        }
        System.out.printf("Club income - %.2f leva.", totalPrice);
    }
}
