package interfacesAndAbstraction.exercises.birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Birthable> thingsWithBirthrates = new ArrayList<>();
        while (!"End".equals(input)) {
            String[] commandParts = input.split(" ");

            switch (commandParts[0]) {
                case "Citizen":
                    String citizenName = commandParts[1];
                    int citizenAge = Integer.parseInt(commandParts[2]);
                    String citizenId = commandParts[3];
                    String citizenBirthdate = commandParts[4];

                    Citizen citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthdate);
                    thingsWithBirthrates.add(citizen);
                    break;
                case "Pet":
                    String petName = commandParts[1];
                    String petBirthdate = commandParts[2];

                    Pet pet = new Pet(petName, petBirthdate);
                    thingsWithBirthrates.add(pet);
                    break;
                case "Robot":
                    // ToDo:
                    break;
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        thingsWithBirthrates.stream().map(Birthable::getBirthDate).filter(e -> e.endsWith(year))
                .forEach(System.out::println);


    }
}
