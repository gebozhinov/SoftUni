import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int evaluators = Integer.parseInt(scanner.nextLine());

        double totalPoints = 0;
        for (int i = 0; i < evaluators; i++) {
            String evaluatorName = scanner.nextLine();
            double evaluatorPoints = Double.parseDouble(scanner.nextLine());
            totalPoints += evaluatorName.length() * evaluatorPoints / 2;
            if (totalPoints + academyPoints > 1250.5) {
                break;
            }
        }
        totalPoints += academyPoints;
        if (totalPoints > 1250.5) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, totalPoints);
        } else {
            System.out.printf("Sorry, %s you need %.1f more!", actorName, 1250.5 - totalPoints);
        }
    }
}
