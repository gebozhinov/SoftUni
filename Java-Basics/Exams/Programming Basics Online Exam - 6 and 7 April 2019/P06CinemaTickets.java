import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int totalTickets = 0;
        int studentTickets = 0;
        int standardTickets = 0;
        int kidTickets = 0;
        String movieName = scanner.nextLine();
        while (!movieName.equals("Finish")) {
            int freeSeats = Integer.parseInt(scanner.nextLine());
            int tickets = 0;
            while (freeSeats > tickets) {
                String ticketType = scanner.nextLine();
                if (ticketType.equals("End")) {
                    break;
                }
                tickets++;
                switch (ticketType) {
                    case "student":
                        studentTickets++;
                        break;
                    case "standard":
                        standardTickets++;
                        break;
                    case "kid":
                        kidTickets++;
                        break;
                }
            }
            totalTickets += tickets;
            System.out.printf("%s - %.2f%% full.%n", movieName, tickets * 1.0 / freeSeats * 100);
            movieName = scanner.nextLine();
        }
        double studentTicketsPercent = studentTickets * 1.0 / totalTickets * 100;
        double standardTicketsPercent = standardTickets * 1.0 / totalTickets * 100;
        double kidTicketsPercent = kidTickets * 1.0 / totalTickets * 100;

        System.out.printf("Total tickets: %d%n", totalTickets);
        System.out.printf("%.2f%% student tickets.%n", studentTicketsPercent);
        System.out.printf("%.2f%% standard tickets.%n", standardTicketsPercent);
        System.out.printf("%.2f%% kids tickets.%n", kidTicketsPercent);
    }
}
