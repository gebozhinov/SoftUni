import java.util.*;
import java.util.stream.Collectors;

public class P10TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> initialTreasureChest = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Yohoho!")) {
            List<String> getCommand = Arrays.stream(command.split(" "))
                    .collect(Collectors.toList());
            switch (getCommand.get(0)) {
                case "Loot":
                    for (int i = 1; i < getCommand.size(); i++) {
                        if (!checkIfTheItemIsInTheChest(initialTreasureChest, getCommand.get(i))) {
                            initialTreasureChest.add(0, getCommand.get(i));
                        }
                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(getCommand.get(1));
                    if (dropIndex >= 0 && dropIndex < initialTreasureChest.size()) {
                        String oldItem = initialTreasureChest.get(dropIndex);
                        initialTreasureChest.remove(dropIndex);
                        initialTreasureChest.add(oldItem);
                    }
                    break;
                case "Steal":
                    int stealIndex = Integer.parseInt(getCommand.get(1));
                    if (stealIndex >= 0 && stealIndex < initialTreasureChest.size()) {
                        printStolenItems(initialTreasureChest, stealIndex);
                    } else if (stealIndex >= initialTreasureChest.size()) {
                        System.out.print(Arrays.toString(initialTreasureChest.toArray())
                                .replace("[", "")
                                .replace("]", ""));
                        System.out.println();
                        initialTreasureChest.removeAll(initialTreasureChest);
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        if (initialTreasureChest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            printAverageTreasurePoints(initialTreasureChest);
        }
    }

    public static boolean checkIfTheItemIsInTheChest(List<String> treasureChest, String item) {
        for (String itemInChest : treasureChest) {
            if (itemInChest.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static void printStolenItems(List<String> treasureChest, int numberOfItemsStolen) {
        List<String> removeLoot = treasureChest.subList(treasureChest.size() - numberOfItemsStolen, treasureChest.size());
        for (int i = treasureChest.size() - numberOfItemsStolen; i < treasureChest.size(); i++) {
            if (i == treasureChest.size() - 1) {
                System.out.print(treasureChest.get(i));
            } else {
                System.out.print(treasureChest.get(i) + ", ");
            }
        }
        System.out.println();
        treasureChest.removeAll(removeLoot);
    }

    public static void printAverageTreasurePoints(List<String> treasureChest) {
        int sumLength = 0;
        for (String item : treasureChest) {
            sumLength += item.length();
        }
        double result = sumLength * 1.0 / treasureChest.size();
        System.out.printf("Average treasure gain: %.2f pirate credits.", result);
    }
}
