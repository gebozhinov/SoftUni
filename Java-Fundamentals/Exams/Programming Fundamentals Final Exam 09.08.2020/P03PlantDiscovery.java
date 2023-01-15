package exam.finale.august2020;

import java.util.*;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> plantMap = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String plant = input.split("<->")[0];
            int rarity =  Integer.parseInt(input.split("<->")[1]);
            plantMap.put(plant, rarity);
        }

        Map<String, List<Double>> plantsRating = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] firstPart = input.split(": ");
            String command = firstPart[0];
            String[] secondPart = firstPart[1].split(" - ");
            String plant = secondPart[0];
            if (!plantMap.containsKey(plant)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }
            switch (command) {
                case "Rate":
                    Double rating = Double.parseDouble(secondPart[1]);
                    plantsRating.putIfAbsent(plant, new ArrayList<>());
                    plantsRating.get(plant).add(rating);
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(secondPart[1]);
                    plantMap.put(plant, newRarity);
                    break;
                case "Reset":
                    plantsRating.get(plant).clear();
                    break;
                default:
                    System.out.println("error");
            }


            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
//        for (Map.Entry<String, Integer> plant : plantMap.entrySet()) {
//            for (Map.Entry<String, List<Double>> rating : plantsRating.entrySet()) {
//                double sum = 0;
//                for (int i = 0; i < rating.getValue().size(); i++) {
//                    sum += rating.getValue().get(i);
//                }
//                double average = sum / rating.getValue().size();
//                if (rating.getValue().isEmpty()) {
//                    average = 0;
//                }
//                if (plant.getKey().equals(rating.getKey())) {
//                    System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plant.getKey(), plant.getValue(), average);
//                    break;
//                }
//            }
//        }
        plantMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()
                        .thenComparingDouble(x -> plantsRating.get(x.getKey()).stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.0))
                        .reversed())
                .forEach(entry -> System.out.println(String.format("- %s; Rarity: %d; Rating: %.2f",
                        entry.getKey(), entry.getValue(),
                        plantsRating.get(entry.getKey()).stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.0))));
    }
}
