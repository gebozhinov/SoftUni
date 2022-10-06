import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;
        switch (typeOfGroup) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.8;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.9;
                        break;
                    case "Saturday":
                        price = 15.6;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.5;
                        break;
                }
                break;
        }
        double totalPrice = price * groupOfPeople;
        if (groupOfPeople >= 30 && typeOfGroup.equals("Students")) {
            totalPrice *= 0.85;
        }
        if (groupOfPeople >= 100 && typeOfGroup.equals("Business")) {
            totalPrice -= price * 10;
        }
        if (10 <= groupOfPeople && groupOfPeople <= 20 && typeOfGroup.equals("Regular")) {
            totalPrice *= 0.95;
        }
        System.out.printf("Total price: %.2f", totalPrice);

    }
}
