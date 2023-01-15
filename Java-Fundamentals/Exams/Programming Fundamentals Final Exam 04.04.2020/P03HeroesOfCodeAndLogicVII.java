package exam.finale.april2020;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Map<Integer, Integer>> heroesMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String hero = input.split(" ")[0];
            int hp = Integer.parseInt(input.split(" ")[1]);
            int mp = Integer.parseInt(input.split(" ")[2]);
            heroesMap.put(hero, new LinkedHashMap<>());
            heroesMap.get(hero).put(hp, mp);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String command = input.split(" - ")[0];
            String heroName = input.split(" - ")[1];
            int currentHp = getKey(heroesMap, heroName);
            int currentMp = getValue(heroesMap, heroName);
            switch (command) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(input.split(" - ")[2]);
                    String spellName = input.split(" - ")[3];
                    if (currentMp >= mpNeeded) {
                        heroesMap.get(heroName).clear();
                        heroesMap.get(heroName).put(currentHp, currentMp - mpNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n"
                                , heroName, spellName, currentMp - mpNeeded);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(input.split(" - ")[2]);
                    String attacker = input.split(" - ")[3];
                    if (currentHp - damage <= 0) {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroesMap.remove(heroName);
                    } else {
                        heroesMap.get(heroName).clear();
                        heroesMap.get(heroName).put(currentHp - damage, currentMp);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n"
                                , heroName, damage, attacker, currentHp - damage);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(input.split(" - ")[2]);
                    heroesMap.get(heroName).clear();
                    heroesMap.get(heroName).put(currentHp, Math.min(amount + currentMp, 200));
                    int rechargeAmount = getValue(heroesMap, heroName);
                    System.out.printf("%s recharged for %d MP!%n", heroName, rechargeAmount - currentMp);
                    break;
                case "Heal":
                    int inputAmount = Integer.parseInt(input.split(" - ")[2]);
                    heroesMap.get(heroName).clear();
                    heroesMap.get(heroName).put(Math.min(inputAmount + currentHp, 100), currentMp);
                    int healAmount = getKey(heroesMap, heroName);
                    System.out.printf("%s healed for %d HP!%n", heroName, healAmount - currentHp);
                    break;
            }


            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<Integer, Integer>> hero : heroesMap.entrySet()) {
            System.out.println(hero.getKey());
            for (Map.Entry<Integer, Integer> entry : hero.getValue().entrySet()) {
                System.out.printf("HP: %d%n", entry.getKey());
                System.out.printf("MP: %d%n", entry.getValue());
            }

        }


    }

    public static int getKey(Map<String, Map<Integer, Integer>> heroesMap, String hero) {
        int hp = 0;
        for (Map.Entry<Integer, Integer> entry : heroesMap.get(hero).entrySet()) {
            hp = entry.getKey();
        }
        return hp;
    }

    public static int getValue(Map<String, Map<Integer, Integer>> heroesMap, String hero) {
        int mp = 0;
        for (Map.Entry<Integer, Integer> entry : heroesMap.get(hero).entrySet()) {
            mp = entry.getValue();
        }
        return mp;
    }
}
