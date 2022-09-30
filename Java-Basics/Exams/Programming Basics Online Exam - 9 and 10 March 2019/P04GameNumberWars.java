import java.util.Scanner;

public class GameNumberWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String playerOne = scanner.nextLine();
        String playerTwo = scanner.nextLine();


        int playerOnePoints = 0;
        int playerTwoPoints = 0;
        boolean isGameEnd = false;
        while (true) {
            try {
                int playerOneCard = Integer.parseInt(scanner.nextLine());
                int playerTwoCard = Integer.parseInt(scanner.nextLine());
                if (playerOneCard == playerTwoCard) {
                    System.out.println("Number wars!");
                    playerOneCard = Integer.parseInt(scanner.nextLine());
                    playerTwoCard = Integer.parseInt(scanner.nextLine());
                    if (playerOneCard > playerTwoCard) {
                        System.out.printf("%s is winner with %d points", playerOne, playerOnePoints);
                    } else {
                        System.out.printf("%s is winner with %d points", playerTwo, playerTwoPoints);
                    }
                    break;
                }
                if (playerOneCard > playerTwoCard) {
                    playerOnePoints += playerOneCard - playerTwoCard;
                } else {
                    playerTwoPoints += playerTwoCard - playerOneCard;
                }

            } catch (Exception exception) {
                isGameEnd = true;
                break;
            }
        }
        if (isGameEnd) {
            System.out.printf("%s has %d points%n", playerOne, playerOnePoints);
            System.out.printf("%s has %d points", playerTwo, playerTwoPoints);
        }
    }
}
