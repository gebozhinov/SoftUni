import java.util.Scanner;

public class CinemaVoucher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int voucherAmount = Integer.parseInt(scanner.nextLine());


        int totalExpenses = 0;
        int tickets = 0;
        int otherPurchase = 0;
        String purchase = scanner.nextLine();
        while (!purchase.equals("End")) {
            if (purchase.length() > 8) {
                totalExpenses += purchase.charAt(0) + purchase.charAt(1);
                if (totalExpenses > voucherAmount) {
                    break;
                }
                tickets++;
            } else {
                totalExpenses += purchase.charAt(0);
                if (totalExpenses > voucherAmount) {
                    break;
                }
                otherPurchase++;
            }
            purchase = scanner.nextLine();
        }
        System.out.println(tickets);
        System.out.println(otherPurchase);
    }
}
