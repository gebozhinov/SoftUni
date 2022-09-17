import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double w = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double hallLength = w * 100;
        double hallWidth = h * 100;

        double deskInRow = Math.floor((hallWidth - 100) / 70);
        double rowsInHall = Math.floor(hallLength / 120);

        double spaces = deskInRow * rowsInHall - 3;

        System.out.printf("%.0f %n", spaces);

    }
}
