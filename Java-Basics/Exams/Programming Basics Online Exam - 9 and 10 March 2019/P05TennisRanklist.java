import java.util.Scanner;

public class TennisRankList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournaments = Integer.parseInt(scanner.nextLine());
        int startingPoints = Integer.parseInt(scanner.nextLine());

        int points = 0;
        int wonTournaments = 0;
        for (int i = 0; i < tournaments; i++) {
            String stage = scanner.nextLine();
            switch (stage) {
                case "W":
                    points += 2000;
                    wonTournaments++;
                    break;
                case "F":
                    points += 1200;
                    break;
                case "SF":
                    points += 720;
                    break;
            }
        }
        int finalPoints = points + startingPoints;
        double averagePoints = Math.floor(points * 1.0 / tournaments);
        double wonTournamentsPercent = wonTournaments * 1.0 / tournaments * 100;

        System.out.printf("Final points: %d%n", finalPoints);
        System.out.printf("Average points: %.0f%n", averagePoints);
        System.out.printf("%.2f%%", wonTournamentsPercent);

    }
}
