package setsAndMapsAdvanced.exercises;

import java.util.HashMap;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        HashMap<String, String> phonebook = new HashMap<>();
        while (!firstInput.equals("search")) {
            String name = firstInput.split("-")[0];
            String number = firstInput.split("-")[1];
            phonebook.put(name, number);
            firstInput = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();
        while (!secondInput.equals("stop")) {
            if (phonebook.containsKey(secondInput)) {
                System.out.print(secondInput + " -> " + phonebook.get(secondInput));
                System.out.println();
            } else {
                System.out.printf("Contact %s does not exist.%n", secondInput);
            }
            secondInput = scanner.nextLine();
        }
    }
}
