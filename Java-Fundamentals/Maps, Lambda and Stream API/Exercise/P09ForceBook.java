import java.util.*;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> forceBook = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Lumpawaroo")) {

            if (input.contains("|")) {
                String forceSide = input.split(" \\| ")[0];
                String forceUser = input.split(" \\| ")[1];

                boolean isFound = forceBook.values().stream().anyMatch(list -> list.contains(forceUser));


                if (!forceBook.containsKey(forceSide) && !isFound) {
                    forceBook.put(forceSide, new ArrayList<>());
                    forceBook.get(forceSide).add(forceUser);
                } else if (!isFound) {
                    forceBook.get(forceSide).add(forceUser);
                }


            } else if (input.contains("->")) {
                String forceUser = input.split(" -> ")[0];
                String forceSide = input.split(" -> ")[1];
                boolean isFound = forceBook.values().stream().anyMatch(list -> list.contains(forceUser));
                if (isFound) {
                    forceBook.forEach((key, value) -> value.remove(forceUser));

                }
                if (forceBook.containsKey(forceSide)) {
                    forceBook.get(forceSide).add(forceUser);
                } else {
                    forceBook.put(forceSide, new ArrayList<>());
                    forceBook.get(forceSide).add(forceUser);
                }
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }


            input = scanner.nextLine();
        }
        forceBook.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> {
                    System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().forEach(player -> System.out.println("! " + player));
                });
          }
}
