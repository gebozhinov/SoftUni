import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double luggagePriceAbove20Kg = Double.parseDouble(scanner.nextLine());
        double luggageKg = Double.parseDouble(scanner.nextLine());
        int daysToTrip = Integer.parseInt(scanner.nextLine());
        int luggageAmount = Integer.parseInt(scanner.nextLine());

        double price = 0;
        if (luggageKg < 10) {
            price = luggagePriceAbove20Kg * 0.2;
        } else if (luggageKg <= 20) {
            price = luggagePriceAbove20Kg * 0.5;
        } else {
            price = luggagePriceAbove20Kg;
        }
        if (daysToTrip > 30) {
            price *= 1.1;
        } else if (daysToTrip >= 7) {
            price *= 1.15;
        } else {
            price *= 1.4;
        }
        double totalPrice = price * luggageAmount;
        System.out.printf("The total price of bags is: %.2f lv.", totalPrice);


    }
}
