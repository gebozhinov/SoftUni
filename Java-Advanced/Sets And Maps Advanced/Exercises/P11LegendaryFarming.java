package setsAndMapsAdvanced.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P11LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int shardsQuantity = 0;
        int fragmentsQuantity = 0;
        int motesQuantity = 0;
        boolean flag = false;
        TreeMap<String, Integer> junkItems = new TreeMap<>();
        while (true) {
            String materials[] = scanner.nextLine().split(" ");
            for (int i = 0; i < materials.length; i += 2) {
                int quantity = Integer.parseInt(materials[i]);
                String currentMaterial = materials[i + 1].toLowerCase();
                switch (currentMaterial) {
                    case "shards":
                        shardsQuantity += quantity;
                        break;
                    case "fragments":
                        fragmentsQuantity += quantity;
                        break;
                    case "motes":
                        motesQuantity += quantity;
                        break;
                    default:
                        junkItems.putIfAbsent(currentMaterial, 0);
                        int currentQuantity = junkItems.get(currentMaterial);
                        junkItems.put(currentMaterial, currentQuantity + quantity);
                        break;
                }
                if (shardsQuantity >= 250) {
                    shardsQuantity -= 250;
                    System.out.println("Shadowmourne obtained!");
                    flag = true;
                    break;
                } else if (fragmentsQuantity >= 250) {
                    fragmentsQuantity -= 250;
                    System.out.println("Valanyr obtained!");
                    flag = true;
                    break;
                } else if (motesQuantity >= 250) {
                    motesQuantity -= 250;
                    System.out.println("Dragonwrath obtained!");
                    flag = true;
                    break;
                }

            }
            if (flag) {
                break;
            }

        }

        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", shardsQuantity);
        keyMaterials.put("fragments", fragmentsQuantity);
        keyMaterials.put("motes", motesQuantity);

        Map<String, Integer> sortKeyMaterials = keyMaterials.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        sortKeyMaterials.forEach((key, value) -> System.out.println(key + ": " + value));
        junkItems.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
