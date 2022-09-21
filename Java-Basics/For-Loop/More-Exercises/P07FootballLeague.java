import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stadiumCapacity = Integer.parseInt(scanner.nextLine());
        int fans = Integer.parseInt(scanner.nextLine());
        double sectorA = 0;
        double sectorB = 0;
        double sectorV = 0;
        double sectorG = 0;
        for (int i = 0; i < fans; i++) {
            String sector = scanner.nextLine();
            switch (sector) {
                case "A":
                    sectorA++;
                    break;
                case "B":
                    sectorB++;
                    break;
                case "V":
                    sectorV++;
                    break;
                case "G":
                    sectorG++;
                    break;
            }
        }
        System.out.printf("%.2f%%%n", sectorA / fans * 100);
        System.out.printf("%.2f%%%n", sectorB / fans * 100);
        System.out.printf("%.2f%%%n", sectorV / fans * 100);
        System.out.printf("%.2f%%%n", sectorG / fans * 100);
        System.out.printf("%.2f%%%n", fans * 1.0 / stadiumCapacity * 100);
    }
}
