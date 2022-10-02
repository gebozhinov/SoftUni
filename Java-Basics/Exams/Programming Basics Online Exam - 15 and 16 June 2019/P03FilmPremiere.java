import java.util.Scanner;

public class FilmPremiere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String movieName = scanner.nextLine();
        String packet = scanner.nextLine();
        int tickets = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (movieName) {
            case "John Wick":
                switch (packet) {
                    case "Drink":
                        price = 12;
                        break;
                    case "Popcorn":
                        price = 15;
                        break;
                    case "Menu":
                        price = 19;
                        break;
                }
                break;
            case "Star Wars":
                switch (packet) {
                    case "Drink":
                        price = 18;
                        break;
                    case "Popcorn":
                        price = 25;
                        break;
                    case "Menu":
                        price = 30;
                        break;
                }
                break;
            case "Jumanji":
                switch (packet) {
                    case "Drink":
                        price = 9;
                        break;
                    case "Popcorn":
                        price = 11;
                        break;
                    case "Menu":
                        price = 14;
                        break;
                }
                break;
        }
        double totalPrice = tickets * price;
        if (movieName.equals("Star Wars") && tickets >= 4) {
            totalPrice *= 0.7;
        } else if (movieName.equals("Jumanji") && tickets == 2) {
            totalPrice *= 0.85;
        }
        System.out.printf("Your bill is %.2f leva.", totalPrice);
    }
}
