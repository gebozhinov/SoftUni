package exam.finale.april2020;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<Integer, Integer>> targetMap = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Sail")) {
            String city = input.split("\\|\\|")[0];
            int population = Integer.parseInt(input.split("\\|\\|")[1]);
            int gold = Integer.parseInt(input.split("\\|\\|")[2]);

            if (targetMap.containsKey(city)) {
                int currentPopulation = getKey(targetMap, city);
                int currentGold = getValue(targetMap, city);
                targetMap.get(city).clear();
                targetMap.get(city).put(population + currentPopulation, gold + currentGold);
            } else {
                targetMap.putIfAbsent(city, new LinkedHashMap<>());
                targetMap.get(city).putIfAbsent(population, gold);
            }

            input = scanner.nextLine();
        }
        String event = scanner.nextLine();
        while (!event.equals("End")) {
            String command = event.split("=>")[0];
            String town = event.split("=>")[1];
            int currentPeople = getKey(targetMap, town);
            int currentGold = getValue(targetMap, town);
            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(event.split("=>")[2]);
                    int gold = Integer.parseInt(event.split("=>")[3]);
                    targetMap.get(town).clear();
                    targetMap.get(town).put(currentPeople - people, currentGold - gold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n"
                            , town, gold, people);
                    if (currentPeople - people <= 0 || currentGold - gold <= 0) {
                        System.out.printf("%s has been wiped off the map!%n", town);
                        targetMap.remove(town);
                    }
                    break;
                case "Prosper":
                    int increaseGold = Integer.parseInt(event.split("=>")[2]);
                    if (increaseGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        targetMap.get(town).clear();
                        targetMap.get(town).put(currentPeople, currentGold + increaseGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n"
                                , increaseGold, town, currentGold + increaseGold);
                    }
                    break;
            }


            event = scanner.nextLine();
        }
        if (targetMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", targetMap.size());
            for (Map.Entry<String, Map<Integer, Integer>> town : targetMap.entrySet()) {
                for (Map.Entry<Integer, Integer> entry : town.getValue().entrySet()) {
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n"
                            , town.getKey(), entry.getKey(), entry.getValue());
                }

            }

        }
    }

    public static int getKey(Map<String, Map<Integer, Integer>> targetMap, String city) {
        int key = 0;
        for (Map.Entry<Integer, Integer> entry : targetMap.get(city).entrySet()) {
            key = entry.getKey();
        }
        return key;
    }

    public static int getValue(Map<String, Map<Integer, Integer>> targetMap, String city) {
        int value = 0;
        for (Map.Entry<Integer, Integer> entry : targetMap.get(city).entrySet()) {
            value = entry.getValue();
        }
        return value;
    }
}
