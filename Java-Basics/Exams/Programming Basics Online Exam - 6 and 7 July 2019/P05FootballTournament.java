import java.util.Scanner;

public class FootballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String team = scanner.nextLine();
        int gamesPlayed = Integer.parseInt(scanner.nextLine());

        int totalPoints = 0;
        int wins = 0;
        int draws = 0;
        int loses = 0;
        for (int i = 0; i < gamesPlayed; i++) {
            String result = scanner.nextLine();

            switch (result) {
                case "W":
                    totalPoints += 3;
                    wins++;
                    break;
                case "D":
                    totalPoints++;
                    draws++;
                    break;
                case "L":
                    loses++;
                    break;
            }
        }
        double winRate = wins * 1.0 / gamesPlayed * 100;
        if (gamesPlayed == 0) {
            System.out.printf("%s hasn't played any games during this season.", team);
        } else {
            System.out.printf("%s has won %d points during this season.%n", team, totalPoints);
            System.out.println("Total stats:");
            System.out.printf("## W: %d%n", wins);
            System.out.printf("## D: %d%n", draws);
            System.out.printf("## L: %d%n", loses);
            System.out.printf("Win rate: %.2f%%", winRate);
        }
    }
}
