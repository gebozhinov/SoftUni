import java.util.*;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        List<String> guests = new ArrayList<>();
        while (true) {
            List<String> commandList = List.of(command.split(" "));
            String person = commandList.get(0);
            switch (commandList.get(2)) {
                case "going!":
                    // add the person if he/she is not on the list
                    guests.add(addPersonToList(guests, person));
                    guests.removeAll(Arrays.asList("", null));
                    break;
                case "not":
                    // remove the person if he/she is on the list
                    guests.remove(removePersonFromList(guests, person));
                    guests.removeAll(Arrays.asList("", null));

                    break;
            }
            numberOfCommands--;
            if (numberOfCommands == 0) {
                break;
            }
            command = scanner.nextLine();

        }
        for (String printGuest : guests) {
            System.out.println(printGuest);
        }

    }

    public static String addPersonToList(List<String> guests, String person) {
        boolean isPersonInTheList = false;
        for (String guest : guests) {
            if (person.equals(guest)) {
                System.out.printf("%s is already in the list!%n", person);
                isPersonInTheList = true;
                break;
            }
        }
        if (!isPersonInTheList) {
            return person;
        }
        return null;
    }

    public static String removePersonFromList(List<String> guests, String person) {
        for (String guest : guests) {
            if (person.equals(guest)) {
                return person;
            }
        }
        System.out.printf("%s is not in the list!%n", person);
        return null;
    }
}
