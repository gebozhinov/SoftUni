import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int students = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());

        double price = 0;
        String sport = "";
        switch (season) {
            case "Winter":
                if ("boys".equals(groupType)) {
                    price = 9.6;
                    sport = "Judo";
                } else if ("girls".equals(groupType)) {
                    price = 9.6;
                    sport = "Gymnastics";
                } else if ("mixed".equals(groupType)) {
                    price = 10.0;
                    sport = "Ski";
                }
                break;
            case "Spring":
                if ("boys".equals(groupType)) {
                    price = 7.2;
                    sport = "Tennis";
                } else if ("girls".equals(groupType)) {
                    price = 7.2;
                    sport = "Athletics";
                } else if ("mixed".equals(groupType)) {
                    price = 9.5;
                    sport = "Cycling";
                }
                break;
            case "Summer":
                if ("boys".equals(groupType)) {
                    price = 15;
                    sport = "Football";
                } else if ("girls".equals(groupType)) {
                    price = 15;
                    sport = "Volleyball";
                } else if ("mixed".equals(groupType)) {
                    price = 20;
                    sport = "Swimming";
                }
                break;
        }
        double totalPrice = price * nights * students;
        if (students >= 50) {
            totalPrice *= 0.5;
        } else if (students >= 20) {
            totalPrice *= 0.85;
        } else if (students >= 10) {
            totalPrice *= 0.95;
        }
        System.out.printf("%s %.2f lv.", sport, totalPrice);
    }
}
