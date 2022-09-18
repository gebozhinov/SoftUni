import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int squareMeters = Integer.parseInt(scanner.nextLine());
        double grape = Double.parseDouble(scanner.nextLine());
        int wine = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double harvest = squareMeters * 0.4;
        double totalGrape = harvest * grape;
        double totalWine = totalGrape / 2.5;

        if (totalWine < wine){
        double neededWine = Math.floor(wine - totalWine);
        System.out.printf("It will be a tough winter! More %.0f liters wine needed.", neededWine);
        } else {
            double leftWine = Math.ceil(totalWine - wine);
            double winePerPerson = Math.ceil(leftWine / workers);
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", totalWine);
            System.out.printf("%.0f liters left -> %.0f liters per person.", leftWine, winePerPerson);
        }
    }
}
