import java.util.Scanner;

public class TravelAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String town = scanner.nextLine();
        String packetType = scanner.nextLine();
        String vipCard = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        boolean invalidTown = town.equals("Bansko") || town.equals("Borovets") || town.equals("Varna") || town.equals("Burgas");
        boolean invalidPacketType = packetType.equals("noEquipment") || packetType.equals("withEquipment")
                 || packetType.equals("noBreakfast") || packetType.equals("withBreakfast");

        double price = 0;
        double totalPrice;
        switch (town) {
            case "Bansko":
            case "Borovets":
                switch (packetType) {
                    case "noEquipment":
                        price = 80;
                        if (vipCard.equals("yes")) {
                            price *= 0.95;
                        }
                        break;
                    case "withEquipment":
                        price = 100;
                        if (vipCard.equals("yes")) {
                            price *= 0.9;
                        }
                        break;
                }
                break;
            case "Varna":
            case "Burgas":
                switch (packetType) {
                    case "noBreakfast":
                        price = 100;
                        if (vipCard.equals("yes")) {
                            price *= 0.93;
                        }
                        break;
                    case "withBreakfast":
                        price = 130;
                        if (vipCard.equals("yes")) {
                            price *= 0.88;
                        }
                        break;
                }
                break;
        }
        totalPrice = days * price;
        if (days > 7) {
            totalPrice -= price;
        }
        if (days < 1) {
            System.out.println("Days must be positive number!");
        } else if (!invalidPacketType || !invalidTown) {
            System.out.println("Invalid input!");
        } else {
            System.out.printf("The price is %.2flv! Have a nice time!", totalPrice);
        }
    }
}
