package interfacesAndAbstraction.lab.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] commandParts = input.split(" ");
            if (commandParts.length == 2) {
                String model = commandParts[0];
                String id = commandParts[1];
                Robot robot = new Robot(model, id);
                identifiables.add(robot);
            } else {
                String name = commandParts[0];
                int age = Integer.parseInt(commandParts[1]);
                String id = commandParts[2];
                Citizen citizen = new Citizen(name, age, id);
                identifiables.add(citizen);
            }

            input = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();

        identifiables.stream().map(Identifiable::getId).filter(e -> e.endsWith(fakeId))
                .forEach(System.out::println);

    }
}
