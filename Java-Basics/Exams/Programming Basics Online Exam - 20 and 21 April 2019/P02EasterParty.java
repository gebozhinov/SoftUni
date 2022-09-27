import java.util.Scanner;

public class EasterParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int guests = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        double cake = budget * 0.1;
        if (guests >= 10 && guests <= 15) {
            price *= 0.85;
        } else if (guests > 15 && guests <= 20) {
            price *= 0.8;
        } else if (guests > 20) {
            price *= 0.75;
        }
        double totalPrice = price * guests + cake;
        if (budget >= totalPrice) {
            System.out.printf("It is party time! %.2f leva left.", budget - totalPrice);
        } else {
            System.out.printf("No party! %.2f leva needed.", totalPrice - budget);
        }
    }
}
