import java.util.Scanner;

public class OscarsWeekInCinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String movieName = scanner.nextLine();
        String hallType = scanner.nextLine();
        int ticketsBought = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (movieName) {
            case "A Star Is Born":
                switch (hallType) {
                    case "normal":
                        price = 7.5;
                        break;
                    case "luxury":
                        price = 10.5;
                        break;
                    case "ultra luxury":
                        price = 13.5;
                        break;
                }
                break;
            case "Bohemian Rhapsody":
                switch (hallType) {
                    case "normal":
                        price = 7.35;
                        break;
                    case "luxury":
                        price = 9.45;
                        break;
                    case "ultra luxury":
                        price = 12.75;
                        break;
                }
                break;
            case "Green Book":
                switch (hallType) {
                    case "normal":
                        price = 8.15;
                        break;
                    case "luxury":
                        price = 10.25;
                        break;
                    case "ultra luxury":
                        price = 13.25;
                        break;
                }
                break;
            case "The Favourite":
                switch (hallType) {
                    case "normal":
                        price = 8.75;
                        break;
                    case "luxury":
                        price = 11.55;
                        break;
                    case "ultra luxury":
                        price = 13.95;
                        break;
                }
                break;
        }
        double totalPrice = ticketsBought * price;
        System.out.printf("%s -> %.2f lv.", movieName, totalPrice);
    }
}
