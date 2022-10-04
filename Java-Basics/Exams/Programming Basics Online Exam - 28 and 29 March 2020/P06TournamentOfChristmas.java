import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournamentDays = Integer.parseInt(scanner.nextLine());
        double totalRaisedMoney = 0;
        int wonDays = 0;
        int lostDays = 0;
        for (int i = 0; i < tournamentDays; i++) {
            String sport = scanner.nextLine();
            double raisedMoney = 0;
            int wonGames = 0;
            int lostGames = 0;
            while (!sport.equals("Finish")) {
                String result = scanner.nextLine();
                if ("win".equals(result)) {
                    raisedMoney += 20;
                    wonGames++;
                } else {
                    lostGames++;
                }
                sport = scanner.nextLine();
            }
            if (wonGames > lostGames) {
                raisedMoney *= 1.1;
                wonDays++;
            } else {
                lostDays++;
            }
            totalRaisedMoney += raisedMoney;
        }
        if (wonDays > lostDays) {
            totalRaisedMoney *= 1.2;
            System.out.printf("You won the tournament! Total raised money: %.2f", totalRaisedMoney);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalRaisedMoney);
        }

    }
}
