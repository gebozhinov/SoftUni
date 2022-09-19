import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chrysanthemums = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int tulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();

        double chrysanthemumsPrice = 0;
        double rosesPrice = 0;
        double tulipsPrice = 0;

        switch (season) {
            case "Spring":
            case "Summer":
                chrysanthemumsPrice = chrysanthemums * 2.00;
                rosesPrice = roses * 4.10;
                tulipsPrice = tulips * 2.5;
                break;
            case "Autumn":
            case "Winter":
                chrysanthemumsPrice = chrysanthemums * 3.75;
                rosesPrice = roses * 4.50;
                tulipsPrice = tulips * 4.15;
                break;
        }
        double totalPrice = chrysanthemumsPrice + rosesPrice + tulipsPrice;
        if (holiday.equals("Y")) {
            totalPrice *= 1.15;
        }
        if (tulips > 7 && season.equals("Spring")) {
            totalPrice *= 0.95;
        }
        if (roses >= 10 && season.equals("Winter")) {
            totalPrice *= 0.9;
        }
        if (chrysanthemums + roses + tulips > 20) {
            totalPrice *= 0.8;
        }
        System.out.printf("%.2f", totalPrice + 2);
    }
}
