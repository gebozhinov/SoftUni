import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int windows = Integer.parseInt(scanner.nextLine());
        String windowsType = scanner.nextLine();
        String delivery = scanner.nextLine();

        double price = 0;
        switch (windowsType) {
            case "90X130":
                price = 110;
                if (windows > 60) {
                    price *= 0.92;
                } else if (windows > 30) {
                    price *= 0.95;
                }
                break;
            case "100X150":
                price = 140;
                if (windows > 80) {
                    price *= 0.9;
                } else if (windows > 40) {
                    price *= 0.94;
                }
                break;
            case "130X180":
                price = 190;
                if (windows > 50) {
                    price *= 0.88;
                } else if (windows > 20) {
                    price *= 0.93;
                }
                break;
            case "200X300":
                price = 250;
                if (windows > 50) {
                    price *= 0.86;
                } else if (windows > 25) {
                    price *= 0.91;
                }
                break;
        }
        double totalPrice = price * windows;
        if (delivery.equals("With delivery")) {
            totalPrice += 60;
        }
        if (windows > 99) {
            totalPrice *= 0.96;
        }
        if (windows < 10) {
            System.out.println("Invalid order");
        } else {
            System.out.printf("%.2f BGN", totalPrice);
        }
    }
}
