import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earlyFee = Integer.parseInt(scanner.nextLine());

        double sneakers = earlyFee * 0.6;
        double kit = sneakers * 0.8;
        double ball = kit * 0.25;
        double accessories = ball * 0.2;

        double totalExpenses = earlyFee + sneakers + kit + ball + accessories;

        System.out.printf("%.2f", totalExpenses);


    }
}
