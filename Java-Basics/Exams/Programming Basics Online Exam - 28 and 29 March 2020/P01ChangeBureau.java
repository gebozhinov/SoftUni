import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoins = Integer.parseInt(scanner.nextLine());
        double yuan = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        double lev = bitcoins * 1168;
        double usd = yuan * 0.15;
        lev += usd * 1.76;
        double eur = lev / 1.95;
        eur -= eur * (commission / 100);
        System.out.printf("%.2f", eur);


    }
}
