import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniorCyclist = Integer.parseInt(scanner.nextLine());
        int seniorCyclist = Integer.parseInt(scanner.nextLine());
        String routeType = scanner.nextLine();

        double juniorTax = 0;
        double seniorTax = 0;
        switch (routeType) {
            case "trail":
                juniorTax = juniorCyclist * 5.5;
                seniorTax = seniorCyclist * 7;
                break;
            case "cross-country":
                juniorTax = juniorCyclist * 8;
                seniorTax = seniorCyclist * 9.5;
                if (juniorCyclist + seniorCyclist >= 50) {
                    juniorTax *= 0.75;
                    seniorTax *= 0.75;
                }
                break;
            case "downhill":
                juniorTax = juniorCyclist * 12.25;
                seniorTax = seniorCyclist * 13.75;
                break;
            case "road":
                juniorTax = juniorCyclist * 20;
                seniorTax = seniorCyclist * 21.5;
                break;
        }
        double total = (juniorTax + seniorTax) * 0.95;
        System.out.printf("%.2f", total);
    }
}
