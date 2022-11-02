import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Byte> results = new LinkedHashMap<>();
        Map<String, Byte> submissions = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String name = input.split("-")[0];
            if (!input.contains("banned")) {
                String language = input.split("-")[1];
                byte points = Byte.parseByte(input.split("-")[2]);

                results.putIfAbsent(name, (byte) 0);
                byte currentPoints = results.get(name);
                if (points > currentPoints) {
                    results.put(name, points);
                }

                submissions.putIfAbsent(language, (byte) 0);
                byte totalSubmissions = submissions.get(language);
                submissions.put(language, (byte) (totalSubmissions + 1));

            } else {
                results.remove(name);
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");
        results.forEach((key, value) -> System.out.println(key + " | " + value));
        System.out.println("Submissions:");
        submissions.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
