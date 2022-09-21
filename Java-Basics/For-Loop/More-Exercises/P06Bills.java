import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());
        double electricityBillTotal = 0;
        double waterBill = 0;
        double internetBill = 0;
        double othersBill = 0;
        for (int i = 0; i < months; i++) {
            double electricityBill = Double.parseDouble(scanner.nextLine());
            electricityBillTotal += electricityBill;
            waterBill += 20;
            internetBill += 15;
            othersBill += (20 + 15 + electricityBill) * 1.2;
        }
        double averageBill = (electricityBillTotal + waterBill + internetBill + othersBill) / months;
        System.out.printf("Electricity: %.2f lv%n", electricityBillTotal);
        System.out.printf("Water: %.2f lv%n", waterBill);
        System.out.printf("Internet: %.2f lv%n", internetBill);
        System.out.printf("Other: %.2f lv%n", othersBill);
        System.out.printf("Average: %.2f lv%n", averageBill);
    }
}
