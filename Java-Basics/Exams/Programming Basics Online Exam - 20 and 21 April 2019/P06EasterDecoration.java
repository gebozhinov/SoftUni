import java.util.Scanner;

public class EasterDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int clients = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;
        for (int i = 0; i < clients; i++) {
            String purchase = scanner.nextLine();
            int purchaseCount = 0;
            double price = 0;
            while (!purchase.equals("Finish")) {
                purchaseCount++;
                switch (purchase) {
                    case "basket":
                        price += 1.5;
                        break;
                    case "wreath":
                        price += 3.8;
                        break;
                    case "chocolate bunny":
                        price += 7;
                        break;
                }
                purchase = scanner.nextLine();
            }
            if (purchaseCount % 2 == 0) {
                price *= 0.8;
            }
            System.out.printf("You purchased %d items for %.2f leva.%n", purchaseCount, price);
            totalPrice += price;
        }
        double averageBill = totalPrice / clients;
        System.out.printf("Average bill per client is: %.2f leva.", averageBill);
    }
}
