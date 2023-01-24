package setsAndMapsAdvanced.exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        LinkedHashMap<String, String> emailsMap = new LinkedHashMap<>();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                emailsMap.put(name, email);
            }
            name = scanner.nextLine();
        }
        emailsMap.forEach((key, value) -> System.out.println(key + " -> " + value));

    }
}
