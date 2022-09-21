import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cargoCnt = Integer.parseInt(scanner.nextLine());
        int totalTonnage = 0;
        int busTonnage = 0;
        int tirTonnage = 0;
        int trainTonnage = 0;
        double totalPrice = 0;
        for (int i = 0; i < cargoCnt; i++) {
            int cargoTonnage = Integer.parseInt(scanner.nextLine());
            totalTonnage += cargoTonnage;
            if (cargoTonnage <= 3) {
                busTonnage += cargoTonnage;
                totalPrice += cargoTonnage * 200;
            } else if (cargoTonnage <= 11) {
                tirTonnage += cargoTonnage;
                totalPrice += cargoTonnage * 175;
            } else {
                trainTonnage += cargoTonnage;
                totalPrice += cargoTonnage * 120;
            }
        }
        double averagePrice = totalPrice / totalTonnage;
        System.out.printf("%.2f%n", averagePrice);
        System.out.printf("%.2f%%%n", busTonnage * 1.0 / totalTonnage * 100);
        System.out.printf("%.2f%%%n", tirTonnage * 1.0 / totalTonnage * 100);
        System.out.printf("%.2f%%%n", trainTonnage * 1.0 / totalTonnage * 100);
    }
}
