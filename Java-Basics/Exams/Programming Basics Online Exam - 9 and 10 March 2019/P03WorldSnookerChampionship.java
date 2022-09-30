import java.util.Scanner;

public class WorldSnookerChampionship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String stage = scanner.nextLine();
        String ticketType = scanner.nextLine();
        int ticketAmount = Integer.parseInt(scanner.nextLine());
        String picture = scanner.nextLine();

        double price = 0;

        switch (stage) {
            case "Quarter final":
                switch (ticketType) {
                    case "Standard":
                        price = 55.5;
                        break;
                    case "Premium":
                        price = 105.2;
                        break;
                    case "VIP":
                        price = 118.9;
                        break;
                }
                break;
            case "Semi final":
                switch (ticketType) {
                    case "Standard":
                        price = 75.88;
                        break;
                    case "Premium":
                        price = 125.22;
                        break;
                    case "VIP":
                        price = 300.4;
                        break;
                }
                break;
            case "Final":
                switch (ticketType) {
                    case "Standard":
                        price = 110.1;
                        break;
                    case "Premium":
                        price = 160.66;
                        break;
                    case "VIP":
                        price = 400;
                        break;
                }
                break;
        }
        double totalPrice = price * ticketAmount;
        if (totalPrice > 4000) {
            totalPrice *= 0.75;
            picture = "N";
        } else if (totalPrice > 2500) {
            totalPrice *= 0.9;
        }
        if (picture.equals("Y")) {
            totalPrice += ticketAmount * 40;
        }
        System.out.printf("%.2f", totalPrice);
    }
}
