import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int amount = Integer.parseInt(scanner.nextLine());

        double price = 0;
        switch (fruit) {
            case "Watermelon":
                switch (size) {
                    case "small":
                        price = 56 * 2;
                        break;
                    case "big":
                        price = 28.7 * 5;
                        break;
                }
                break;
            case "Mango":
                switch (size) {
                    case "small":
                        price = 36.66 * 2;
                        break;
                    case "big":
                        price = 19.6 * 5;
                        break;
                }
                break;
            case "Pineapple":
                switch (size) {
                    case "small":
                        price = 42.1 * 2;
                        break;
                    case "big":
                        price = 24.8 * 5;
                        break;
                }
                break;
            case "Raspberry":
                switch (size) {
                    case "small":
                        price = 20 * 2;
                        break;
                    case "big":
                        price = 15.2 * 5;
                        break;
                }
                break;
        }
        double totalPrice = price * amount;
        if (totalPrice > 1000) {
            totalPrice *= 0.5;
        } else if (totalPrice >= 400) {
            totalPrice *= 0.85;
        }
        System.out.printf("%.2f lv.", totalPrice);
    }
}
