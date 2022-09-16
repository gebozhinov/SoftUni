import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalTicketsSold = 0;
        double studentTickets = 0;
        double standardTickets = 0;
        double kidsTickets = 0;

        String movie = scanner.nextLine();
        while (!movie.equals("Finish")) {
            int freeSeats = Integer.parseInt(scanner.nextLine());
            String ticketType = scanner.nextLine();
            int takenSeats = 0;
            while (!ticketType.equals("End")) {
                takenSeats++;
                if (ticketType.equals("student")) {
                    studentTickets++;
                } else if (ticketType.equals("standard")) {
                    standardTickets++;
                } else {
                    kidsTickets++;
                }
                if (takenSeats >= freeSeats) {
                    break;
                }

                ticketType = scanner.nextLine();
            }
            double average = takenSeats * 1.00 / freeSeats * 100;
            System.out.printf("%s - %.2f%% full.%n", movie, average);
            totalTicketsSold += takenSeats;
            movie = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d%n", totalTicketsSold);
        System.out.printf("%.2f%% student tickets.%n", studentTickets / totalTicketsSold * 100);
        System.out.printf("%.2f%% standard tickets.%n", standardTickets / totalTicketsSold * 100);
        System.out.printf("%.2f%% kids tickets.%n", kidsTickets / totalTicketsSold * 100);
    }
}
