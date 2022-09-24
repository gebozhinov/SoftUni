import java.util.Scanner;

public class FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double nightPrice = Double.parseDouble(scanner.nextLine());
        int otherExpensesPercent = Integer.parseInt(scanner.nextLine());

        double totalNightsPrice = nights * nightPrice;
        if (nights > 7) {
            totalNightsPrice *= 0.95;
        }
        budget -= budget * (otherExpensesPercent / 100.0);

        double diff = Math.abs(budget - totalNightsPrice);
        if (budget >= totalNightsPrice) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", diff);
        } else {
            System.out.printf("%.2f leva needed.", diff);
        }
    }
}
