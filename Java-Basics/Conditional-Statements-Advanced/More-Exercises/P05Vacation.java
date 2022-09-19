import java.text.StringCharacterIterator;
import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String location = "";
        String type = "";
        double price = 0;
        if (budget <= 1000) {
            type = "Camp";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    price = budget * 0.65;
                    break;
                case "Winter":
                    location = "Morocco";
                    price = budget * 0.45;
                    break;
            }
        } else if (budget <= 3000) {
            type = "Hut";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    price = budget * 0.8;
                    break;
                case "Winter":
                    location = "Morocco";
                    price = budget * 0.6;
                    break;
            }
        } else {
            type = "Hotel";
            price = budget * 0.9;
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    break;
                case "Winter":
                    location = "Morocco";
                    break;
            }
        }
        System.out.printf("%s - %s - %.2f", location, type, price);
    }
}
