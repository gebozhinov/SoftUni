package exam.august2021;

import java.util.*;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquids = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        for (int n : liquids) {
            liquidsQueue.offer(n);
        }

        int[] ingredients = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        for (int n : ingredients) {
            ingredientsStack.push(n);
        }

        Map<String, Integer> cakes = new LinkedHashMap<>();
        cakes.put("Biscuit", 0);
        cakes.put("Cake", 0);
        cakes.put("Pie", 0);
        cakes.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int firstLiquid = liquidsQueue.poll();
            int lastIngredient = ingredientsStack.pop();
            int sum = firstLiquid + lastIngredient;
            switch (sum) {
                case 25:
                    cakes.put("Biscuit", cakes.get("Biscuit") + 1);
                    break;
                case 50:
                    cakes.put("Cake", cakes.get("Cake") + 1);
                    break;
                case 75:
                    cakes.put("Pastry", cakes.get("Pastry") + 1);
                    break;
                case 100:
                    cakes.put("Pie", cakes.get("Pie") + 1);
                    break;
                default:
                    lastIngredient += 3;
                    ingredientsStack.push(lastIngredient);
            }

        }

        int count = (int) cakes.entrySet().stream().filter(e -> e.getValue() > 0).count();
        if (count >= 4) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Liquids left: ");
            liquidsQueue.forEach(e -> sb.append(e).append(", "));
            sb.replace(sb.length() - 2, sb.length(), "");
            System.out.println(sb);
        }
        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Ingredients left: ");
            ingredientsStack.forEach(e -> sb.append(e).append(", "));
            sb.replace(sb.length() - 2, sb.length(), "");
            System.out.println(sb);
        }
        cakes.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
