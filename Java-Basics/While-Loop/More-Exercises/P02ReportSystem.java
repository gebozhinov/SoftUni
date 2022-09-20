import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int expectedAmount = Integer.parseInt(scanner.nextLine());

        int transaction = 0;
        int cashIncome = 0;
        int cashIncomeCnt = 0;
        int cardIncome = 0;
        int cardIncomeCnt = 0;
        boolean isEnough = false;
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int income = Integer.parseInt(input);
            transaction++;
            if (transaction % 2 != 0) {
                if (income > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    cashIncome += income;
                    cashIncomeCnt++;
                    System.out.println("Product sold!");
                }
            } else {
                if (income < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    cardIncome += income;
                    cardIncomeCnt++;
                    System.out.println("Product sold!");
                }
            }
            if (cardIncome + cashIncome >= expectedAmount) {
                isEnough = true;
                break;
            }
            input = scanner.nextLine();
        }
        double averageCashIncome = cashIncome * 1.00 / cashIncomeCnt;
        double averageCardIncome = cardIncome * 1.00 / cardIncomeCnt;

        if (isEnough) {
            System.out.printf("Average CS: %.2f%n", averageCashIncome);
            System.out.printf("Average CC: %.2f", averageCardIncome);
        } else {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
