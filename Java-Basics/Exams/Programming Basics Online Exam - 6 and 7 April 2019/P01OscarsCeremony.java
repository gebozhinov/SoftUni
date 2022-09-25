import java.util.Scanner;

public class OscarsCeremony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rent = Integer.parseInt(scanner.nextLine());

        double oskars = rent * 0.7;
        double catering = oskars * 0.85;
        double music = catering * 0.5;

        double totalExpenses = rent + oskars + catering + music;
        System.out.printf("%.2f", totalExpenses);
    }
}
