package exam.april2022;

import java.util.*;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] steel = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        for (int n : steel) {
            steelQueue.offer(n);
        }

        int[] carbon = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        for (int n : carbon) {
            carbonStack.push(n);
        }

        Map<String, Integer> swords = new TreeMap<>();
        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int firstSteel = steelQueue.poll();
            int lastCarbon = carbonStack.pop();
            int sum = firstSteel + lastCarbon;

            switch (sum) {
                case 70:
                    swords.putIfAbsent("Gladius", 0);
                    swords.put("Gladius", swords.get("Gladius") + 1);
                    break;
                case 80:
                    swords.putIfAbsent("Shamshir", 0);
                    swords.put("Shamshir", swords.get("Shamshir") + 1);
                    break;
                case 90:
                    swords.putIfAbsent("Katana", 0);
                    swords.put("Katana", swords.get("Katana") + 1);
                    break;
                case 110:
                    swords.putIfAbsent("Sabre", 0);
                    swords.put("Sabre", swords.get("Sabre") + 1);
                    break;
                default:
                    lastCarbon += 5;
                    carbonStack.push(lastCarbon);
                    break;
            }

        }


        if (!swords.isEmpty()) {
            int totalSwords = swords.values().stream().mapToInt(e -> e).sum();
            System.out.printf("You have forged %d swords.%n", totalSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            System.out.print("Steel left: ");
            steelQueue.forEach(e -> sb.append(e).append(", "));
            sb.replace(sb.length() - 2, sb.length(), "");
            System.out.println(sb);
        }
        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            System.out.print("Carbon left: ");
            carbonStack.forEach(e -> sb.append(e).append(", "));
            sb.replace(sb.length() - 2, sb.length(), "");
            System.out.println(sb);
        }

        swords.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
    }
}
