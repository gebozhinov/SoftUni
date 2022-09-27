import java.util.Scanner;

public class EasterLunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int easterBreadAmount = Integer.parseInt(scanner.nextLine());
        int eggs = Integer.parseInt(scanner.nextLine());
        int cookiesKg = Integer.parseInt(scanner.nextLine());

        double easterBreadPrice = easterBreadAmount * 3.2;
        double eggsPrice = eggs * 4.35;
        double cookiesPrice = cookiesKg * 5.4;
        double eggsPaintPrice = eggs * 12 * 0.15;

        double totalPrice = easterBreadPrice + eggsPrice + cookiesPrice + eggsPaintPrice;

        System.out.printf("%.2f", totalPrice);
    }
}
