import java.util.Scanner;

public class EasterBake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int usedSugar = 0;
        int usedFlour = 0;
        int maxUsedSugar = Integer.MIN_VALUE;
        int maxUsedFlour = Integer.MIN_VALUE;
        int easterBread = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < easterBread; i++) {
            int sugar = Integer.parseInt(scanner.nextLine());
            int flour = Integer.parseInt(scanner.nextLine());
            usedSugar += sugar;
            usedFlour += flour;
            if (sugar > maxUsedSugar) {
                maxUsedSugar = sugar;
            }
            if (flour > maxUsedFlour) {
                maxUsedFlour = flour;
            }
        }
        double sugarPackets = Math.ceil(usedSugar / 950.0);
        double flourPackets = Math.ceil(usedFlour / 750.0);
        System.out.printf("Sugar: %.0f%n", sugarPackets);
        System.out.printf("Flour: %.0f%n", flourPackets);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.", maxUsedFlour, maxUsedSugar);

    }
}
