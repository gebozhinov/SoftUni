import java.util.Scanner;

public class FitnessCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int visitors = Integer.parseInt(scanner.nextLine());
        int trainingBack = 0;
        int trainingChest = 0;
        int trainingLegs = 0;
        int trainingAbs = 0;
        int buyingProteinShake = 0;
        int buyingProteinBar = 0;
        for (int i = 0; i < visitors; i++) {
            String action = scanner.nextLine();
            switch (action) {
                case "Back":
                    trainingBack++;
                    break;
                case "Chest":
                    trainingChest++;
                    break;
                case "Legs":
                    trainingLegs++;
                    break;
                case "Abs":
                    trainingAbs++;
                    break;
                case "Protein shake":
                    buyingProteinShake++;
                    break;
                case "Protein bar":
                    buyingProteinBar++;
                    break;
            }
        }
        int peopleWhoTrain = trainingBack + trainingChest + trainingLegs + trainingAbs;
        double trainingPercent = peopleWhoTrain * 1.0 / visitors * 100;
        int peopleWhoBuy = buyingProteinShake + buyingProteinBar;
        double buyingPercent = peopleWhoBuy * 1.0 / visitors * 100;


        System.out.printf("%d - back%n", trainingBack);
        System.out.printf("%d - chest%n", trainingChest);
        System.out.printf("%d - legs%n", trainingLegs);
        System.out.printf("%d - abs%n", trainingAbs);
        System.out.printf("%d - protein shake%n", buyingProteinShake);
        System.out.printf("%d - protein bar%n", buyingProteinBar);
        System.out.printf("%.2f%% - work out%n", trainingPercent);
        System.out.printf("%.2f%% - protein%n", buyingPercent);
    }
}
