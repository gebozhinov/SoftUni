package exam.october2021;

import java.util.*;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ingredients = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        for (int n : ingredients) {
            ingredientsQueue.offer(n);
        }

        int[] freshness = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        for (int n : freshness) {
            freshnessStack.push(n);
        }


        Map<String, Integer> cocktails = new TreeMap<>();
        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int firstIngredient = ingredientsQueue.poll();
            if (firstIngredient == 0) {
                continue;
            }
            int lastFreshness = freshnessStack.pop();
            int total = firstIngredient * lastFreshness;

            switch (total) {
                case 150:
                    cocktails.putIfAbsent("Pear Sour", 0);
                    cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                    break;
                case 250:
                    cocktails.putIfAbsent("The Harvest", 0);
                    cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                    break;
                case 300:
                    cocktails.putIfAbsent("Apple Hinny", 0);
                    cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                    break;
                case 400:
                    cocktails.putIfAbsent("High Fashion", 0);
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                    break;
                default:
                    firstIngredient += 5;
                    ingredientsQueue.offer(firstIngredient);
            }

        }

        if (cocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredientsQueue.isEmpty()) {
            int sum = ingredientsQueue.stream().reduce(0, Integer::sum);
            System.out.printf("Ingredients left: %d%n", sum);
        }

        cocktails.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));


    }
}
