package setsAndMapsAdvanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        Set<String> numbers = new LinkedHashSet<>();
        while (!input.equals("END")) {
            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];
            switch (direction) {
                case "IN":
                    numbers.add(carNumber);
                    break;
                case "OUT":
                    numbers.remove(carNumber);
                    break;
            }
            input = scanner.nextLine();
        }
        if (numbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            numbers.forEach(System.out::println);
        }

    }
}
