import java.util.Scanner;

public class CatToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String carType = "";
        if (budget <= 100) {
            System.out.println("Economy class");
            switch (season) {
                case "Summer":
                    carType = "Cabrio";
                    budget *= 0.35;
                    break;
                case "Winter":
                    carType = "Jeep";
                    budget *= 0.65;
                    break;
            }
        } else if (budget <= 500) {
            System.out.println("Compact class");
            switch (season) {
                case "Summer":
                    carType = "Cabrio";
                    budget *= 0.45;
                    break;
                case "Winter":
                    carType = "Jeep";
                    budget *= 0.8;
                    break;
            }
        } else {
            System.out.println("Luxury class");
            carType = "Jeep";
            budget *= 0.9;
        }
        System.out.printf("%s - %.2f", carType, budget);
    }
}
