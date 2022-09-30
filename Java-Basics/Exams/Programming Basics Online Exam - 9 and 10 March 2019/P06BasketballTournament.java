import java.util.Scanner;

public class BasketballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tournament = scanner.nextLine();
        int gamesCount = 0;
        int wonGames = 0;
        int lostGames = 0;
        while (!tournament.equals("End of tournaments")) {
            int games = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= games; i++) {
                gamesCount++;
                int homePoints = Integer.parseInt(scanner.nextLine());
                int awayPoints = Integer.parseInt(scanner.nextLine());
                if (homePoints > awayPoints) {
                    wonGames++;
                    System.out.printf("Game %d of tournament %s: win with %d points.%n", i, tournament, homePoints - awayPoints);
                } else {
                    lostGames++;
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n", i, tournament, awayPoints - homePoints);
                }
            }
            tournament = scanner.nextLine();
        }
        double wonPercent = wonGames * 1.0 / gamesCount * 100;
        double lostPercent = lostGames * 1.0 / gamesCount * 100;
        System.out.printf("%.2f%% matches win%n", wonPercent);
        System.out.printf("%.2f%% matches lost%n", lostPercent);
    }
}
