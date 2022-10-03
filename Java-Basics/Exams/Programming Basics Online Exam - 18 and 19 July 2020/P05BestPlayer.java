import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String player = scanner.nextLine();
        int mostGoalScored = Integer.MIN_VALUE;
        String bestPlayer = "";
        boolean flag = false;
        while (!player.equals("END")) {
            int goals = Integer.parseInt(scanner.nextLine());
            if (goals > mostGoalScored) {
                mostGoalScored = goals;
                bestPlayer = player;
            }
            if (goals >= 3) {
                flag = true;
            }
            if (goals >= 10) {
                break;
            }
            player = scanner.nextLine();
        }
        System.out.printf("%s is the best player!%n", bestPlayer);
        if (flag) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!", mostGoalScored);
        } else {
            System.out.printf("He has scored %d goals.", mostGoalScored);
        }

    }
}
