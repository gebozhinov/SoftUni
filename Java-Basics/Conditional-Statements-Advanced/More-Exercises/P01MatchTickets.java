import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());

        double tickets = 0;
        if (people <= 4) {
            budget *= 0.25;
        } else if (people <= 9) {
            budget *= 0.4;
        } else if (people <= 24) {
            budget *= 0.5;
        } else if (people <= 49) {
            budget *= 0.6;
        } else {
            budget *= 0.75;
        }
        switch (category) {
            case "VIP":
                tickets = people * 499.99;
                break;
            case "Normal":
                tickets = people * 249.99;
        }
        if (budget >= tickets) {
            System.out.printf("Yes! You have %.2f leva left.", budget - tickets);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", tickets - budget);
        }
    }
}
