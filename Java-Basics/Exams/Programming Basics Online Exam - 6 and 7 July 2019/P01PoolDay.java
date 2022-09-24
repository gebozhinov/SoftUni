import java.util.Scanner;

public class PoolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int people = Integer.parseInt(scanner.nextLine());
        double tax  = Double.parseDouble(scanner.nextLine());
        double sunLoungerPrice = Double.parseDouble(scanner.nextLine());
        double umbrellaPrice = Double.parseDouble(scanner.nextLine());

        double totalTax = people * tax;
        double sunLoungerCount = Math.ceil(people * 0.75);
        double umbrellaCount = Math.ceil(people / 2.0);
        double totalSunLoungerPrice = sunLoungerPrice * sunLoungerCount;
        double totalUmbrellaPrice = umbrellaPrice * umbrellaCount;

        double totalPrice = totalTax + totalUmbrellaPrice + totalSunLoungerPrice;
        System.out.printf("%.2f lv.", totalPrice);
        
    }
}
