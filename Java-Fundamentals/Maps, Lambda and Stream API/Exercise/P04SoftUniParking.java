import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, String> parking = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String username = command.split(" ")[1];
            if (command.split(" ")[0].equals("register")) {
                String plateNumber = command.split(" ")[2];
                if (parking.containsKey(username)) {
                    System.out.printf("ERROR: already registered with plate number %s%n", plateNumber);

                } else {
                    parking.put(username, plateNumber);
                    System.out.printf("%s registered %s successfully%n", username, plateNumber);
                }

            } else if (command.split(" ")[0].equals("unregister")) {
                if (!parking.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);
                } else {
                    parking.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                }

            }
        }

        parking.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
