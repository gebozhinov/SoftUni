import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double strawberriesPrice = Double.parseDouble(scanner.nextLine());
        double bananasKg = Double.parseDouble(scanner.nextLine());
        double orangesKg = Double.parseDouble(scanner.nextLine());
        double raspberriesKg = Double.parseDouble(scanner.nextLine());
        double strawberriesKg = Double.parseDouble(scanner.nextLine());

        double strawberriesTotalPrice = strawberriesPrice * strawberriesKg;
        double raspberriesPrice = strawberriesPrice * 0.5;
        double raspberriesTotalPrice = raspberriesPrice * raspberriesKg;
        double orangesPrice = raspberriesPrice * 0.6;
        double orangesTotalPrice = orangesPrice * orangesKg;
        double bananasPrice = raspberriesPrice * 0.2;
        double bananasTotalPrice = bananasPrice * bananasKg;

        double totalPrice = strawberriesTotalPrice + raspberriesTotalPrice + orangesTotalPrice + bananasTotalPrice;

        System.out.printf("%.2f", totalPrice);

    }
}
