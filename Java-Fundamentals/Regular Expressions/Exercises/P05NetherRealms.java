import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String healthRegex = "[^\\d+\\-*/.]";
        Pattern healthPattern = Pattern.compile(healthRegex);
        String damageRegex = "[+-]?\\d+\\.?\\d*";
        Pattern damagePattern = Pattern.compile(damageRegex);
        String alterDamageRegex = "[*/]";
        Pattern alterDamagePattern = Pattern.compile(alterDamageRegex);

        String[] demons = scanner.nextLine().split(",+\\s*[,+\\s]*");
        for (int i = 0; i < demons.length; i++) {
            demons[i] = demons[i].replaceAll(" ", "");

        }
        for (int i = 0; i < demons.length; i++) {
            String demonName = demons[i];
            Matcher healthMatcher = healthPattern.matcher(demonName);
            int health = 0;
            while (healthMatcher.find()) {
                String demonHealth = healthMatcher.group();
                health += getDemonHealth(demonHealth);
            }

            Matcher damageMatcher = damagePattern.matcher(demonName);
            double baseDamage = 0;
            while (damageMatcher.find()) {
                String demonDamage = damageMatcher.group();
                baseDamage += Double.parseDouble(demonDamage);
            }

            Matcher alterDamageMatcher = alterDamagePattern.matcher(demonName);
            while (alterDamageMatcher.find()) {
                String alterDamage = alterDamageMatcher.group();
                switch (alterDamage) {
                    case "*":
                        baseDamage *= 2;
                        break;
                    case "/":
                        baseDamage /= 2;
                        break;
                }

            }

            System.out.printf("%s - %d health, %.2f damage%n", demonName, health, baseDamage);

        }

    }

    private static int getDemonHealth(String demonName) {
        int demonHealth = 0;
        for (int i = 0; i < demonName.length(); i++) {
            demonHealth += demonName.charAt(i);

        }
        return demonHealth;
    }
}
