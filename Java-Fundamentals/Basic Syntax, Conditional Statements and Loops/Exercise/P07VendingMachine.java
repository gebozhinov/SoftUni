import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstCommand = scanner.nextLine();
        double totalMoney = 0;
        while (!firstCommand.equals("Start")) {
            double money = Double.parseDouble(firstCommand);
            if (money == 2 || money == 1 || money == 0.5 || money == 0.2 || money == 0.1) {
                totalMoney += money;
            } else {
                System.out.printf("Cannot accept %.2f%n", money);
            }
            firstCommand = scanner.nextLine();
        }

        String secondCommand = scanner.nextLine();
        while (!secondCommand.equals("End")) {
            switch (secondCommand) {
                case "Nuts":
                    if (totalMoney - 2 < 0) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased Nuts");
                        totalMoney -= 2;
                    }
                    break;
                case "Water":
                    if (totalMoney - 0.7 < 0) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased Water");
                        totalMoney -= 0.7;
                    }
                    break;
                case "Crisps":
                    if (totalMoney - 1.5 < 0) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased Crisps");
                        totalMoney -= 1.5;
                    }
                    break;
                case "Soda":
                    if (totalMoney - 0.8 < 0) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased Soda");
                        totalMoney -= 0.8;
                    }
                    break;
                case "Coke":
                    if (totalMoney - 1 < 0) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased Coke");
                        totalMoney -= 1;
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }


            secondCommand = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", totalMoney);


    }
}
