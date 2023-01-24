package functionalProgramming.exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String command = input.split(" ")[0];
            String criteria = input.split(" ")[1];
            String option = input.split(" ")[2];
            switch (command) {
                case "Double":
                    List<String> doubleThePeople = new ArrayList<>();
                    guests.stream().filter(getPredicate(criteria, option)).forEach(e -> doubleThePeople.add(e));
                    guests.addAll(doubleThePeople);
                    break;
                case "Remove":
                    guests.removeIf(getPredicate(criteria, option));
                    break;
            }
            input = scanner.nextLine();
        }
        Collections.sort(guests);
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String printResult = String.join(", ", guests) + " are going to the party!";
            System.out.println(printResult);
        }

    }

    public static Predicate<String> getPredicate(String criteria, String option) {
        Predicate<String> predicate = null;
        switch (criteria) {
            case "StartsWith":
                predicate = name -> name.startsWith(option);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(option);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(option);
                break;
        }
        return predicate;
    }
}
