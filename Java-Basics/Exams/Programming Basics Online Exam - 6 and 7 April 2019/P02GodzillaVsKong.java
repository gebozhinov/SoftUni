import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int statist = Integer.parseInt(scanner.nextLine());
        double statistClothingPrice = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.1;
        double totalClothingPrice = statist * statistClothingPrice;

        if (statist > 150) {
            totalClothingPrice *= 0.9;
        }

        double totalExpenses = decor + totalClothingPrice;
        if (budget >= totalExpenses) {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budget - totalExpenses);
        } else {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", totalExpenses - budget);
        }
    }
}
