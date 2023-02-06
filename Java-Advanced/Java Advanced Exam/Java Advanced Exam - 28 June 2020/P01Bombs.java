package exam.june2020;

import java.util.*;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bombEffects = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        for (int n : bombEffects) {
            bombEffectsQueue.offer(n);
        }

        int[] bombCasing = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();
        for (int n : bombCasing) {
            bombCasingStack.push(n);
        }

        int bombPouch = 0;

        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);
        while (!bombEffectsQueue.isEmpty() && !bombCasingStack.isEmpty()) {
            int firstBombEffect = bombEffectsQueue.peek();
            int lastBombCasing = bombCasingStack.peek();
            int sum = firstBombEffect + lastBombCasing;
            switch (sum) {
                case 40:
                    bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                    bombEffectsQueue.poll();
                    bombCasingStack.pop();
                    break;
                case 60:
                    bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                    bombEffectsQueue.poll();
                    bombCasingStack.pop();
                    break;
                case 120:
                    bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                    bombEffectsQueue.poll();
                    bombCasingStack.pop();
                    break;
                default:
                    lastBombCasing -= 5;
                    bombCasingStack.pop();
                    bombCasingStack.push(lastBombCasing);
            }

            bombPouch = (int) bombs.entrySet().stream().filter(e -> e.getValue() >= 3)
                    .count();
            if (bombPouch >= 3) {
                break;
            }
        }

        if (bombPouch >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Bomb Effects: ");
            bombEffectsQueue.forEach(e -> sb.append(e).append(", "));
            sb.replace(sb.length() - 2, sb.length(), "");
            System.out.println(sb);
        }

        if (bombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Bomb Casings: ");
            bombCasingStack.forEach(e -> sb.append(e).append(", "));
            sb.replace(sb.length() - 2, sb.length(), "");
            System.out.println(sb);
        }

        bombs.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }
}
