package functionalProgramming.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> invitations = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        List<String> addFilter = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Print")) {
            String command = input.split(";")[0];
            String filter = input.split(";")[1];
            String parameter = input.split(";")[2];

            switch (command) {
                case "Add filter":
                    invitations.stream().filter(getFilter(filter, parameter)).forEach(addFilter::add);
                    break;
                case "Remove filter":
                    addFilter.removeIf(getFilter(filter, parameter));
                    break;
            }

            input = scanner.nextLine();
        }
        Predicate<String> predicate = e -> {
            for (String name : addFilter) {
                if (name.equals(e)) {
                    return false;
                }
            }
            return true;
        };

        invitations.stream().filter(predicate).forEach(e -> System.out.printf("%s ", e));
    }

    private static Predicate<String> getFilter(String filter, String parameter) {
        Predicate<String> predicate = null;
        switch (filter) {
            case "Starts with":
                predicate = e -> e.startsWith(parameter);
                break;
            case "Ends with":
                predicate = e -> e.endsWith(parameter);
                break;
            case "Length":
                predicate = e -> e.length() == Integer.parseInt(parameter);
                break;
            case "Contains":
                predicate = e -> e.contains(parameter);
                break;
        }
        return predicate;
    }

}
