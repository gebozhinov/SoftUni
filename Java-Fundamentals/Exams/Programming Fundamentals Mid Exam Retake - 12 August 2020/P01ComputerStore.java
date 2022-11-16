package exam.mid.august2020;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        double priceWithoutTaxes = 0;
        while ((!input.equals("special") && !input.equals("regular"))) {
            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }
            priceWithoutTaxes += price;

            input = scanner.nextLine();
        }

        if (priceWithoutTaxes == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", priceWithoutTaxes);
            double taxes = priceWithoutTaxes * 0.2;
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            double totalPrice = priceWithoutTaxes + taxes;
            if (input.equals("special")) {
                totalPrice *= 0.9;
            }
            System.out.printf("Total price: %.2f$%n", totalPrice);
        }

    }
}
