import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junkMaterials = new LinkedHashMap<>();
        boolean isMaterialsEnough = false;
        String input = scanner.nextLine();
        while (true) {
            String[] loot = input.split(" ");
            for (int i = 0; i < loot.length; i += 2) {
                int quantity = Integer.parseInt(loot[i]);
                String material = loot[i + 1].toLowerCase();
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    int currentQuantity = keyMaterials.get(material);
                    keyMaterials.put(material, quantity + currentQuantity);
                    if (keyMaterials.get("shards") >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        keyMaterials.put(material, quantity + currentQuantity - 250);
                        isMaterialsEnough = true;
                        break;
                    } else if (keyMaterials.get("fragments") >= 250) {
                        System.out.println("Valanyr obtained!");
                        keyMaterials.put(material, quantity + currentQuantity - 250);
                        isMaterialsEnough = true;
                        break;
                    } else if (keyMaterials.get("motes") >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        keyMaterials.put(material, quantity + currentQuantity - 250);
                        isMaterialsEnough = true;
                        break;
                    }


                } else {
                    junkMaterials.putIfAbsent(material, 0);
                    int currentQuantity = junkMaterials.get(material);
                    junkMaterials.put(material, quantity + currentQuantity);
                }

            }

            if (isMaterialsEnough) {
                break;
            }
            input = scanner.nextLine();
        }

        keyMaterials.forEach((key, value) -> System.out.println(key + ": " + value));
        junkMaterials.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
