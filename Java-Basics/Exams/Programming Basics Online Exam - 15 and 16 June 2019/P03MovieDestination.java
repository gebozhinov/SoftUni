import java.util.Scanner;

public class MovieDestination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double budget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        int price = 0;

        switch (destination) {
            case "Dubai":
                switch (season) {
                    case "Winter":
                        price = 45000;
                        break;
                    case "Summer":
                        price = 40000;
                        break;
                }
                break;
            case "Sofia":
                switch (season) {
                    case "Winter":
                        price = 17000;
                        break;
                    case "Summer":
                        price = 12500;
                        break;
                }
                break;
            case "London":
                switch (season) {
                    case "Winter":
                        price = 24000;
                        break;
                    case "Summer":
                        price = 20250;
                        break;
                }
                break;
        }
        double totalPrice = price * days;
        if (destination.equals("Dubai")) {
            totalPrice *= 0.7;
        } else if (destination.equals("Sofia")) {
            totalPrice *= 1.25;
        }
        double diff = Math.abs(budget - totalPrice);
        if (budget >= totalPrice) {
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", diff);
        } else {
            System.out.printf("The director needs %.2f leva more!", diff);
        }
    }
}
