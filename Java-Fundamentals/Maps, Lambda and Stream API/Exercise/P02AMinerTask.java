import java.util.*;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> miner = new LinkedHashMap<>();
        String resource = scanner.nextLine();
        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            miner.putIfAbsent(resource, 0);
            int currentQuantity = miner.get(resource);
            miner.put(resource, quantity + currentQuantity);
            resource = scanner.nextLine();
        }
        miner.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
