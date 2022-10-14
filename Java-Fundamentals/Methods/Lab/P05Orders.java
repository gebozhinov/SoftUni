import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        orderPrice(product, quantity);


    }

    public static void orderPrice(String product, int quantity) {
        double result = 0;
        switch (product) {
            case "coffee":
                result = quantity * 1.5;
                break;
            case "water":
                result = quantity;
                break;
            case "coke":
                result = quantity * 1.4;
                break;
            case "snacks":
                result = quantity * 2;
                break;
        }
        System.out.printf("%.2f", result);
    }
}
