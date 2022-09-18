import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kilometers = Integer.parseInt(scanner.nextLine());
        String dayTime = scanner.nextLine();

        double price = 0;

        if (kilometers < 20) {
            if (dayTime.equals("day")) {
                price = kilometers * 0.79;
            } else {
                price = kilometers * 0.9;
            }
            price += 0.7;
        } else if (kilometers < 100) {
            price = kilometers * 0.09;
        } else {
            price = kilometers * 0.06;
        }
        System.out.printf("%.2f", price);
    }
}
