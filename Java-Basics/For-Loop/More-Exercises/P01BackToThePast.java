import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heritage = Double.parseDouble(scanner.nextLine());
        int year = Integer.parseInt(scanner.nextLine());
        int age = 18;
        int moneySpend = 0;
        for (int i = 1800; i <= year; i++) {
            if (i % 2 == 0) {
                moneySpend += 12000;
            } else {
                moneySpend += age * 50 + 12000;
            }
            age += 1;
        }
        if (heritage >= moneySpend) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", heritage - moneySpend);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", moneySpend - heritage);
        }
    }
}
