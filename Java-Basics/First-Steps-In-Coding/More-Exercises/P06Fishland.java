import java.util.Scanner;

public class FishLand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double mackerelPrice = Double.parseDouble(scanner.nextLine());
        double spatPrice = Double.parseDouble(scanner.nextLine());
        double bonitoKg = Double.parseDouble(scanner.nextLine());
        double horseMackerelKg = Double.parseDouble(scanner.nextLine());
        int musselsKg = Integer.parseInt(scanner.nextLine());

        double bonitoPrice = mackerelPrice * 1.6;
        double bonitoCost = bonitoKg * bonitoPrice;
        double horseMackerelPrice = spatPrice * 1.8;
        double horseMackerelCost = horseMackerelKg * horseMackerelPrice;
        double musselsCost = musselsKg * 7.5;

        double totalCost = bonitoCost + horseMackerelCost + musselsCost;
        System.out.printf("%.2f %n", totalCost);
    }
}
