import java.util.Scanner;

public class MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String contractTime = scanner.nextLine();
        String contractType = scanner.nextLine();
        String mobileInternet = scanner.nextLine();
        int mount = Integer.parseInt(scanner.nextLine());

        double price = 0;
        switch (contractTime) {
            case "one":
                switch (contractType) {
                    case "Small":
                        price = 9.98;
                        break;
                    case "Middle":
                        price = 18.99;
                        break;
                    case "Large":
                        price = 25.98;
                        break;
                    case "ExtraLarge":
                        price = 35.99;
                        break;
                }
                break;
            case "two":
                switch (contractType) {
                    case "Small":
                        price = 8.58;
                        break;
                    case "Middle":
                        price = 17.09;
                        break;
                    case "Large":
                        price = 23.59;
                        break;
                    case "ExtraLarge":
                        price = 31.79;
                        break;
                }
                break;
        }
        if (mobileInternet.equals("yes")) {
            if (price <= 10) {
                price += 5.5;
            } else if (price <= 30) {
                price += 4.35;
            } else {
                price += 3.85;
            }
        }
        double totalPrice = price * mount;
        if (contractTime.equals("two")) {
            totalPrice *= 1 - 0.0375;
        }
        System.out.printf("%.2f lv.", totalPrice);
    }
}
