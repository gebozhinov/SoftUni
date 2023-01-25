package generics.exercises.threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String firstName = input.split(" ")[0];
        String lastName = input.split(" ")[1];
        String address = input.split(" ")[2];
        String town = input.split(" ")[3];
        Threeuple<String, String, String> personInfo = new Threeuple<>(firstName + " " + lastName, address, town);
        System.out.println(personInfo.getItem1() + " -> "
                + personInfo.getItem2() + " -> " + personInfo.getItem3());

        input = scanner.nextLine();
        String name = input.split(" ")[0];
        int litersOfBeer = Integer.parseInt(input.split(" ")[1]);
        String drunkOrNot = input.split(" ")[2];
        Threeuple<String, Integer, String> drunk = new Threeuple<>(name, litersOfBeer, drunkOrNot);
        System.out.println(drunk.getItem1() + " -> "
        + drunk.getItem2() + " -> " + drunk.isDrunk(drunkOrNot));

        input = scanner.nextLine();
        String name1 = input.split(" ")[0];
        double accountBalance = Double.parseDouble(input.split(" ")[1]);
        String bankName = input.split(" ")[2];
        Threeuple<String, Double, String> bankInfo = new Threeuple<>(name1, accountBalance, bankName);
        System.out.println(bankInfo.getItem1() + " -> "
        + bankInfo.getItem2() + " -> " + bankInfo.getItem3());

    }
}
