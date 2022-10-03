import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String airLine = scanner.nextLine();
        int adultTickets = Integer.parseInt(scanner.nextLine());
        int kidsTickets = Integer.parseInt(scanner.nextLine());
        double adultNetPrice = Double.parseDouble(scanner.nextLine());
        double serviceFee = Double.parseDouble(scanner.nextLine());

        double adultTicketsPrice = adultTickets * adultNetPrice + serviceFee * adultTickets;
        double kidsNetPrice = adultNetPrice * 0.3;
        double kidsTicketsPrice = kidsTickets * kidsNetPrice + serviceFee * kidsTickets;
        double totalNetPrice = adultTicketsPrice + kidsTicketsPrice;
        double income = totalNetPrice * 0.2;
        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", airLine, income);
    }
}
