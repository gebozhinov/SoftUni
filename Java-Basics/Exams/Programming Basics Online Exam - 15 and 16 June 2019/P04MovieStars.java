import java.util.Scanner;

public class MovieStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());

        double totalActorPayment = 0;
        String actorName = scanner.nextLine();
        while (!actorName.equals("ACTION")) {
            if (actorName.length() > 15) {
                totalActorPayment += (budget - totalActorPayment) * 0.2;
            } else {
                double payment = Double.parseDouble(scanner.nextLine());
                totalActorPayment += payment;
            }
            if (totalActorPayment >= budget) {
                break;
            }
            actorName = scanner.nextLine();
        }
        double diff = Math.abs(budget - totalActorPayment);
        if (budget >= totalActorPayment) {
            System.out.printf("We are left with %.2f leva.", diff);
        } else {
            System.out.printf("We need %.2f leva for our actors.", diff);
        }
    }
}
