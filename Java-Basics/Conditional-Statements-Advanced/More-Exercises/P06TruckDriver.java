import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kilometers = Double.parseDouble(scanner.nextLine());

        double monthSalary = 0;
        switch (season) {
            case "Spring":
            case "Autumn":
                if (kilometers <= 5000) {
                    monthSalary = kilometers * 0.75;
                } else if (kilometers <= 10000) {
                    monthSalary = kilometers * 0.95;
                }
                break;
            case "Summer":
                if (kilometers <= 5000) {
                    monthSalary = kilometers * 0.9;
                } else if (kilometers <= 10000) {
                    monthSalary = kilometers * 1.1;
                }
                break;
            case "Winter":
                if (kilometers <= 5000) {
                    monthSalary = kilometers * 1.05;
                } else if (kilometers <= 10000) {
                    monthSalary = kilometers * 1.25;
                }
                break;
        }
        if (kilometers > 10000) {
            monthSalary = kilometers * 1.45;
        }
        double salary = monthSalary * 4;
        double income = salary * 0.9;
        System.out.printf("%.2f", income);
    }
}
