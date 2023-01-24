package setsAndMapsAdvanced.lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String continent = input.split(" ")[0];
            String country = input.split(" ")[1];
            String city = input.split(" ")[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);

        }
        for (var continent : map.entrySet()) {
            System.out.println(continent.getKey() + ":");
            for (var country : continent.getValue().entrySet()) {
                System.out.println("  " + country.getKey() + " -> "
                        + String.join(", ", country.getValue()));
            }
        }
    }
}
