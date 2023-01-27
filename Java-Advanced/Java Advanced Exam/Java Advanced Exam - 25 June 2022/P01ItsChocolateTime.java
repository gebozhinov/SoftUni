package exam.june2022;

import java.util.*;

public class P01ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] milkValues = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        for (double n : milkValues) {
            milkQueue.offer(n);
        }

        double[] cacaoPowder = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        for (double n : cacaoPowder) {
            cacaoStack.push(n);
        }

        Map<String, Integer> chocolates = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double firstMilkValue = milkQueue.poll();
            double lastCacaoPowderValue = cacaoStack.pop();

            double cacaoPercentage = lastCacaoPowderValue / (firstMilkValue + lastCacaoPowderValue) * 100;
            if (cacaoPercentage == 30.0) {
                chocolates.putIfAbsent("Milk Chocolate", 0);
                int amount = chocolates.get("Milk Chocolate");
                chocolates.put("Milk Chocolate", amount + 1);
            } else if (cacaoPercentage == 50.0) {
                chocolates.putIfAbsent("Dark Chocolate", 0);
                int amount = chocolates.get("Dark Chocolate");
                chocolates.put("Dark Chocolate", amount + 1);
            } else if (cacaoPercentage == 100.0) {
                chocolates.putIfAbsent("Baking Chocolate", 0);
                int amount = chocolates.get("Baking Chocolate");
                chocolates.put("Baking Chocolate", amount + 1);
            } else {
                firstMilkValue += 10;
                milkQueue.offer(firstMilkValue);
            }

        }


        if (chocolates.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolates.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));

    }
}
