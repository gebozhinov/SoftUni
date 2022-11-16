import java.util.Scanner;

public class ExperienceGaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double neededExp = Double.parseDouble(scanner.nextLine());
        int countOfBattles = Integer.parseInt(scanner.nextLine());

        double totalEarnedExp = 0;
        int battlesCount = 0;
        boolean isExpEnough = false;
        for (int i = 1; i <= countOfBattles; i++) {
            double earnedExp = Double.parseDouble(scanner.nextLine());
            battlesCount++;
            if (i % 3 == 0) {
                earnedExp *= 1.15;
            }
            if (i % 5 == 0) {
                earnedExp *= 0.9;
            }
            if (i % 15 == 0) {
                earnedExp *= 1.05;
            }
            totalEarnedExp += earnedExp;
            if (totalEarnedExp >= neededExp) {
                isExpEnough = true;
                break;
            }
        }
        if (isExpEnough) {
            System.out.printf("Player successfully collected his needed experience for %d battles.", battlesCount);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", neededExp - totalEarnedExp);
        }


    }
}
