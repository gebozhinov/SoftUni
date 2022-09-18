import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magnolias = Integer.parseInt(scanner.nextLine());
        int hyacinths = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int cactus = Integer.parseInt(scanner.nextLine());
        double presentPrice = Double.parseDouble(scanner.nextLine());

        double totalPrice = (magnolias * 3.25) + (hyacinths * 4) + (roses * 3.5) + (cactus * 8);
        totalPrice *= 0.95;

        double money = Math.abs(presentPrice - totalPrice);

        if (presentPrice <= totalPrice) {
            System.out.printf("She is left with %.0f leva.", Math.floor(money));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(money));
        }
    }
}
