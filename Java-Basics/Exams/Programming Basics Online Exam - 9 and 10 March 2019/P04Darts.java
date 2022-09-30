import java.util.Scanner;

public class Darts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String playerName = scanner.nextLine();

        int totalPoints = 0;
        String field = scanner.nextLine();
        boolean isGameWon = false;
        int successfulShots = 0;
        int unSuccessfulShots = 0;
        while (!field.equals("Retire")) {
            int points = Integer.parseInt(scanner.nextLine());
            switch (field) {
                case "Double":
                    points *= 2;
                    break;
                case "Triple":
                    points *= 3;
                    break;
            }
            if (totalPoints + points > 301) {
                unSuccessfulShots++;
                field = scanner.nextLine();
                continue;
            }
            successfulShots++;
            totalPoints += points;
            if (totalPoints == 301) {
                isGameWon = true;
                break;
            }
            field = scanner.nextLine();
        }
        if (isGameWon) {
            System.out.printf("%s won the leg with %d shots.", playerName, successfulShots);
        } else {
            System.out.printf("%s retired after %d unsuccessful shots.", playerName, unSuccessfulShots);
        }
    }
}
