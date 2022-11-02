import java.util.*;

public class P03Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> finalQuantity = new LinkedHashMap<>();
        Map<String, Double> finalPrice = new LinkedHashMap<>();
        String products = scanner.nextLine();
        while (!products.equals("buy")) {
            String name = products.split(" ")[0];
            double currentPrice = Double.parseDouble(products.split(" ")[1]);
            int currentQuantity = Integer.parseInt(products.split(" ")[2]);

            finalQuantity.putIfAbsent(name, 0);
            int quantity = finalQuantity.get(name);
            finalQuantity.put(name, quantity + currentQuantity);
            finalPrice.put(name, currentPrice);

            products = scanner.nextLine();

        }

        Map<String, Double> totalPrice = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : finalQuantity.entrySet()) {
            for (Map.Entry<String, Double> price : finalPrice.entrySet()) {
                if (entry.getKey().equals(price.getKey())) {
                    totalPrice.put(entry.getKey(), entry.getValue() * price.getValue());
                }
            }

        }

        totalPrice.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value));

    }
}
