package setsAndMapsAdvanced.exercises.stacksAndQueues.exercises;

import java.util.*;

public class P09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] pesticides = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> plants = new ArrayDeque<>();
        Arrays.stream(pesticides).forEach(plants::offer);


        int days = 0;
        while (true) {
            List<Integer> plantList = new ArrayList<>();
            int current = plants.poll();
            plantList.add(current);
            for (int i = 0; i < plants.size(); i++) {
                if (current >= plants.getFirst()) {
                    plantList.add(plants.getFirst());
                }
                current = plants.poll();
                i--;
            }
            days++;
            if (isAscending(plantList)) {
                break;
            }
            plantList.forEach(plants::offer);
        }
        System.out.println(days);

    }

    public static boolean isAscending(List<Integer> plantsList) {
        for (int i = 0; i < plantsList.size() - 1; i++) {
            int first = plantsList.get(i);
            int second = plantsList.get(i + 1);
            if (first < second) {
                return false;
            }
        }
        return true;
    }

}
