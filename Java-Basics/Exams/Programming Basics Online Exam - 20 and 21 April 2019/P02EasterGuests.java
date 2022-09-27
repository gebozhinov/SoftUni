import java.util.Scanner;

public class EasterGuests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int guests = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double easterBread = Math.ceil(guests / 3.0);
        double easterBreadPrice = easterBread * 4;
        double eggs = guests * 2;
        double eggsPrice = eggs * 0.45;
        double totalPrice = easterBreadPrice + eggsPrice;

        if (budget >= totalPrice) {
            System.out.printf("Lyubo bought %.0f Easter bread and %.0f eggs.%n", easterBread, eggs);
            System.out.printf("He has %.2f lv. left.", budget - totalPrice);
        } else {
            System.out.println("Lyubo doesn't have enough money.");
            System.out.printf("He needs %.2f lv. more.", totalPrice - budget);
        }
    }
}
