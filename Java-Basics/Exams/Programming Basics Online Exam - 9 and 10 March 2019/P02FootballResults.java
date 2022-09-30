import java.util.Scanner;

public class FootballResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstGame = scanner.nextLine();
        String secondGame = scanner.nextLine();
        String thirdGame = scanner.nextLine();

        String[] splitGameOne = firstGame.split(":");
        int splitGameOnePartOne = Integer.parseInt(splitGameOne[0]);
        int splitGameOnePartTwo = Integer.parseInt(splitGameOne[1]);
        String[] splitGameTwo = secondGame.split(":");
        int splitGameTwoPartOne = Integer.parseInt(splitGameTwo[0]);
        int splitGameTwoPartTwo = Integer.parseInt(splitGameTwo[1]);
        String[] splitGameThree = thirdGame.split(":");
        int splitGameThreePartOne = Integer.parseInt(splitGameThree[0]);
        int splitGameThreePartTwo = Integer.parseInt(splitGameThree[1]);

        int won = 0;
        int drawn = 0;
        int lost = 0;
        if (splitGameOnePartOne > splitGameOnePartTwo ) {
            won += 1;
        } else if (splitGameOnePartOne == splitGameOnePartTwo) {
            drawn += 1;
        } else {
            lost += 1;
        }
        if (splitGameTwoPartOne > splitGameTwoPartTwo ) {
            won += 1;
        } else if (splitGameTwoPartOne == splitGameTwoPartTwo) {
            drawn += 1;
        } else {
            lost += 1;
        }
        if (splitGameThreePartOne > splitGameThreePartTwo ) {
            won += 1;
        } else if (splitGameThreePartOne == splitGameThreePartTwo) {
            drawn += 1;
        } else {
            lost += 1;
        }
        System.out.printf("Team won %d games.%n", won);
        System.out.printf("Team lost %d games.%n", lost);
        System.out.printf("Drawn games: %d", drawn);
    }
}
