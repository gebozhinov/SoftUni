import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int easterBreads = Integer.parseInt(scanner.nextLine());
        int maxPoints = Integer.MIN_VALUE;
        String winner = "";
        for (int i = 0; i < easterBreads; i++) {
            String name = scanner.nextLine();
            String input = scanner.nextLine();
            int currentPoints = 0;
            while (!input.equals("Stop")) {
                int points = Integer.parseInt(input);
                currentPoints += points;
                input = scanner.nextLine();
            }
            System.out.printf("%s has %d points.%n", name, currentPoints);
            if (currentPoints > maxPoints) {
                maxPoints = currentPoints;
                winner = name;
                System.out.printf("%s is the new number 1!%n", name);
            }
        }
        System.out.printf("%s won competition with %d points!", winner, maxPoints);
    }
}
