import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String playerName = scanner.nextLine();


        int winnerPoints = 0;
        String winner = "";
        while (!playerName.equals("Stop")) {
            int playerPoints = 0;
            for (int i = 0; i < playerName.length(); i++) {
                int number = Integer.parseInt(scanner.nextLine());
                int letter = playerName.charAt(i);
                if (number == letter) {
                    playerPoints += 10;
                } else {
                    playerPoints += 2;
                }
                if (playerPoints >= winnerPoints) {
                    winnerPoints = playerPoints;
                    winner = playerName;
                }
            }
            playerName = scanner.nextLine();
        }
        System.out.printf("The winner is %s with %d points!", winner, winnerPoints);
    }
}
