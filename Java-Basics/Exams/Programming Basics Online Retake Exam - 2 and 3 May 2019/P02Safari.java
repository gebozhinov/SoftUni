import java.util.Scanner;

public class Safari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double gasoline = Double.parseDouble(scanner.nextLine());
        String dayOfWeek = scanner.nextLine();

        double gasolinePrice = gasoline * 2.1;
        double totalPrice = gasolinePrice + 100;
        if (dayOfWeek.equals("Saturday")) {
            totalPrice *= 0.9;
        } else {
            totalPrice *= 0.8;
        }
        double diff = Math.abs(budget - totalPrice);
        if (budget >= totalPrice) {
            System.out.printf("Safari time! Money left: %.2f lv.", diff);
        } else {
            System.out.printf("Not enough money! Money needed: %.2f lv.", diff);
        }


    }
}
