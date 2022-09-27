import java.util.Scanner;

public class EasterBakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double flourPrice = Double.parseDouble(scanner.nextLine());
        double flourKg = Double.parseDouble(scanner.nextLine());
        double sugarKg = Double.parseDouble(scanner.nextLine());
        int eggs = Integer.parseInt(scanner.nextLine());
        int yeast = Integer.parseInt(scanner.nextLine());

        double flourTotalPrice = flourPrice * flourKg;
        double sugarPrice = flourPrice * 0.75;
        double sugarTotalPrice = sugarPrice * sugarKg;
        double eggsPrice = flourPrice * 1.1;
        double eggsTotalPrice = eggsPrice * eggs;
        double yeastPrice = sugarPrice * 0.2;
        double yeastTotalPrice = yeastPrice * yeast;

        double totalPrice = flourTotalPrice + sugarTotalPrice + eggsTotalPrice + yeastTotalPrice;
        System.out.printf("%.2f", totalPrice);
    }
}
