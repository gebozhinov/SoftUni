import java.util.Scanner;

public class Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int controlMinutes = Integer.parseInt(scanner.nextLine());
        int controlSeconds = Integer.parseInt(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());
        int secondsToPass100Meters = Integer.parseInt(scanner.nextLine());

        double controlTime = controlMinutes * 60 + controlSeconds;
        double timeReduction = length / 120;
        double timeReductionTotal = timeReduction * 2.5;
        double competitorTime = (length / 100) * secondsToPass100Meters - timeReductionTotal;

        if (competitorTime <= controlTime) {
            System.out.println("Marin Bangiev won an Olympic quota!");
            System.out.printf("His time is %.3f.", competitorTime);
        } else {
            System.out.printf("No, Marin failed! He was %.3f second slower.", competitorTime - controlTime);
        }


    }
}
