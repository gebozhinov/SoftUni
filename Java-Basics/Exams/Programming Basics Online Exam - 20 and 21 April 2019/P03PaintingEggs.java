import java.util.Scanner;

public class PaintingEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String eggSize = scanner.nextLine();
        String eggColor = scanner.nextLine();
        int batches = Integer.parseInt(scanner.nextLine());

        int price = 0;
        switch (eggSize) {
            case "Large":
                switch (eggColor) {
                    case "Red":
                        price = 16;
                        break;
                    case "Green":
                        price = 12;
                        break;
                    case "Yellow":
                        price = 9;
                        break;
                }
                break;
            case "Medium":
                switch (eggColor) {
                    case "Red":
                        price = 13;
                        break;
                    case "Green":
                        price = 9;
                        break;
                    case "Yellow":
                        price = 7;
                        break;
                }
                break;
            case "Small":
                switch (eggColor) {
                    case "Red":
                        price = 9;
                        break;
                    case "Green":
                        price = 8;
                        break;
                    case "Yellow":
                        price = 5;
                        break;
                }
                break;
        }
        double totalPrice = price * batches;
        totalPrice *= 0.65;
        System.out.printf("%.2f leva.", totalPrice);
    }
}
