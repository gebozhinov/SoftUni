import java.util.Scanner;

public class SeriesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String seriesName = scanner.nextLine();
        int seasons = Integer.parseInt(scanner.nextLine());
        int episodes = Integer.parseInt(scanner.nextLine());
        double duration = Double.parseDouble(scanner.nextLine());

        double durationWithoutAdvertise = duration + (duration * 0.2);
        double totalMinutes = Math.floor(seasons * episodes * durationWithoutAdvertise) + seasons * 10;

        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", seriesName, totalMinutes);
    }
}
