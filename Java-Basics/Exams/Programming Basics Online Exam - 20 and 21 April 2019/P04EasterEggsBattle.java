import java.util.Scanner;

public class EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int playerOneEggs = Integer.parseInt(scanner.nextLine());
        int playerTwoEggs = Integer.parseInt(scanner.nextLine());

        String winner = scanner.nextLine();
        while (!winner.equals("End")) {
            if (winner.equals("one")) {
                playerTwoEggs--;
            } else {
                playerOneEggs--;
            }
            if (playerOneEggs == 0) {
                System.out.printf("Player one is out of eggs. Player two has %d eggs left.", playerTwoEggs);
                break;
            } else if (playerTwoEggs == 0) {
                System.out.printf("Player two is out of eggs. Player one has %d eggs left.", playerOneEggs);
                break;
            }
            winner = scanner.nextLine();
        }
        if (winner.equals("End")) {
            System.out.printf("Player one has %d eggs left.%n", playerOneEggs);
            System.out.printf("Player two has %d eggs left.", playerTwoEggs);
        }
    }
}
