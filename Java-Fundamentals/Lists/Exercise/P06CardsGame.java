import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> playerOne = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> playerTwo = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        while (playerOne.size() > 0 && playerTwo.size() > 0) {
            if (playerOne.get(0) > playerTwo.get(0)) {
                playerOne.add(playerTwo.get(0));
                playerOne.add(playerOne.size() - 1 ,playerOne.get(0));
                playerOne.remove(0);
                playerTwo.remove(0);
            } else if (playerTwo.get(0) > playerOne.get(0)) {
                playerTwo.add(playerOne.get(0));
                playerTwo.add(playerTwo.size() - 1, playerTwo.get(0));
                playerTwo.remove(0);
                playerOne.remove(0);
            } else {
                playerOne.remove(0);
                playerTwo.remove(0);
            }

        }
        if (playerOne.size() > playerTwo.size()) {
            System.out.printf("First player wins! Sum: %d", cardPointsSum(playerOne));
        } else {
            System.out.printf("Second player wins! Sum: %d", cardPointsSum(playerTwo));
        }

    }
    public static int cardPointsSum(List<Integer> playerCards) {
        int sum = 0;
        for (int card : playerCards) {
            sum += card;
        }
        return sum;
    }
}
