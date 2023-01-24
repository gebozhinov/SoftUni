package setsAndMapsAdvanced.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Double>> shopMap = new TreeMap<>();
        while (!input.equals("Revision")) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);
            if (!shopMap.containsKey(shop)) {
                shopMap.put(shop, new LinkedHashMap<>());
                shopMap.get(shop).put(product, price);
            } else {
                shopMap.get(shop).put(product, price);
            }

            input = scanner.nextLine();
        }

        shopMap.forEach((key, value) -> {
            System.out.println(key + "->");
            value.forEach((k, v) -> System.out.printf("Product: %s, Price: %.1f%n", k, v));
        });

    }
}
