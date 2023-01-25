package basicAlgorithms;

import java.util.*;
import java.util.stream.Collectors;

public class P03SumOfCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        int result = usedCoins.entrySet().stream()
                .mapToInt(e -> e.getKey() * e.getValue())
                .sum();
        if (result != targetSum) {
            System.out.println("Error");
        } else {
            for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
                System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
            }
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        // TODO
        Arrays.sort(coins);
        List<Integer> sortedCoins = Arrays.stream(coins).boxed()
                .collect(Collectors.toList());
        Collections.reverse(sortedCoins);

        Map<Integer, Integer> chosenCoins = new LinkedHashMap<>();
        int currentSum = 0;
        int coinIndex = 0;
        while (currentSum != targetSum && coinIndex < sortedCoins.size()) {
            int currentCoinValue = sortedCoins.get(coinIndex);
            int remainingSum = targetSum - currentSum;
            int numberOfCoinsToTake = remainingSum / currentCoinValue;
            if (numberOfCoinsToTake > 0) {
                chosenCoins.putIfAbsent(currentCoinValue, numberOfCoinsToTake);
            }
            coinIndex++;
            currentSum += currentCoinValue * numberOfCoinsToTake;
        }
        return chosenCoins;
    }
}
