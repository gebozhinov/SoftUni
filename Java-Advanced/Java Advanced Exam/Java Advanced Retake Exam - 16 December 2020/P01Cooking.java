package exam.december2020;

import java.util.*;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] liquids = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> liquidQueue = new ArrayDeque<>();
        for (int n : liquids) {
            liquidQueue.offer(n);
        }

        int[] ingredients = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> ingredientStack = new ArrayDeque<>();
        for (int n : ingredients) {
            ingredientStack.push(n);
        }

        Map<String, Integer> map = new TreeMap<>();
        map.putIfAbsent("Bread", 0);
        map.putIfAbsent("Cake", 0);
        map.putIfAbsent("Pastry", 0);
        map.putIfAbsent("Fruit Pie", 0);
        while (!liquidQueue.isEmpty() && !ingredientStack.isEmpty()) {
            int firstLiquid = liquidQueue.poll();
            int lastIngredient = ingredientStack.pop();
            switch (firstLiquid + lastIngredient) {
                case 25:
                    map.put("Bread", map.get("Bread") + 1);
                    break;
                case 50:
                    map.put("Cake", map.get("Cake") + 1);
                    break;
                case 75:
                    map.put("Pastry", map.get("Pastry") + 1);
                    break;
                case 100:
                    map.put("Fruit Pie", map.get("Fruit Pie") + 1);
                    break;
                default:
                    lastIngredient += 3;
                    ingredientStack.push(lastIngredient);
            }

        }
        int count = (int) map.entrySet().stream().filter(e -> e.getValue() > 0).count();
        if (count == 4) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Liquids left: ");
            liquidQueue.forEach(e -> sb.append(e).append(", "));
            sb.replace(sb.length() - 2, sb.length(), "");
            System.out.println(sb);
        }
        if (ingredientStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Ingredients left: ");
            ingredientStack.forEach(e -> sb.append(e).append(", "));
            sb.replace(sb.length() - 2, sb.length(), "");
            System.out.println(sb);
        }
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
