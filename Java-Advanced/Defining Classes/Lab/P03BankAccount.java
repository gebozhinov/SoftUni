package definingClasses.lab;

import java.util.HashMap;
import java.util.Scanner;

public class P03BankAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String command = input.split(" ")[0];
            String output = null;
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.getId(), bankAccount);
                    output = String.format("Account ID%d created", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(input.split(" ")[1]);
                    int amount = Integer.parseInt(input.split(" ")[2]);
                    if (bankAccounts.containsKey(id)) {
                        bankAccounts.get(id).deposit(amount);
                        output = String.format("Deposited %d to ID%s", amount, bankAccounts.get(id).getId());
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(input.split(" ")[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int interestId = Integer.parseInt(input.split(" ")[1]);
                    int years = Integer.parseInt(input.split(" ")[2]);
                    if (bankAccounts.containsKey(interestId)) {
                        output = String.format("%.2f", bankAccounts.get(interestId).getInterest(years));
                    } else {
                        output = "Account does not exist";
                    }
                    break;
            }
            if (output != null) {
                System.out.println(output);
            }
            input = scanner.nextLine();
        }


    }
}
