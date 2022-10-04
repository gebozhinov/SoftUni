import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double truckVolume = Double.parseDouble(scanner.nextLine());

        String command = scanner.nextLine();
        int suitcaseCount = 0;
        double totalVolume = 0;
        while (!command.equals("End")) {
            double suitcaseVolume = Double.parseDouble(command);
            suitcaseCount++;
            if (suitcaseCount % 3 == 0) {
                totalVolume += suitcaseVolume * 1.1;
            } else {
                totalVolume += suitcaseVolume;
            }
            if (totalVolume > truckVolume) {
                suitcaseCount--;
                break;
            }
            command = scanner.nextLine();
        }
        if (command.equals("End")) {
            System.out.println("Congratulations! All suitcases are loaded!");
        } else {
            System.out.println("No more space!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", suitcaseCount);
    }
}
