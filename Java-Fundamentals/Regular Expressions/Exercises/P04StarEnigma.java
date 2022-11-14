import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:\\d+[^@\\-!:>]*!(?<attackType>[AD])![^@\\-!:>]*->\\d+";
        Pattern pattern = Pattern.compile(regex);

        Map<String, Integer> attackedPlanets = new TreeMap<>();
        Map<String, Integer> destroyedPlanets = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String encryptedMassage = scanner.nextLine();
            String decryptedMassage = getDecryptedMassage(encryptedMassage);
            Matcher matcher = pattern.matcher(decryptedMassage);
            while (matcher.find()) {
                String planet = matcher.group("planetName");
                String attackType = matcher.group("attackType");
                if (attackType.equals("A")) {
                    attackedPlanets.putIfAbsent(planet, 0);
                } else {
                    destroyedPlanets.putIfAbsent(planet, 0);
                }
            }

        }

        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        attackedPlanets.forEach((key, value) -> System.out.println("-> " + key));
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        destroyedPlanets.forEach((key, value) -> System.out.println("-> " + key));
    }

    private static String getDecryptedMassage(String encryptedMassage) {
        int count = getCountOfLetters(encryptedMassage);
        StringBuilder decryptedMassage = new StringBuilder();
        for (int i = 0; i < encryptedMassage.length(); i++) {
            char symbol = (char) (encryptedMassage.charAt(i) - count);
            decryptedMassage.append(symbol);

        }
        return decryptedMassage.toString();
    }

    private static int getCountOfLetters(String encryptedMassage) {
        int count = 0;
        for (int i = 0; i < encryptedMassage.length(); i++) {
            switch (encryptedMassage.charAt(i)) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                    count++;
                    break;

            }
        }
        return count;
    }
}
