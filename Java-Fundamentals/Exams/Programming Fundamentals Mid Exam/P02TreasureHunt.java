package exam.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> treasureChest = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {
            String command = input.split(" ")[0];
            switch (command) {
                case "Loot":
                    List<String> itemList = Arrays.stream(input.split(" "))
                            .collect(Collectors.toList());
                    for (int i = 1; i < itemList.size(); i++) {
                        String currentItem = itemList.get(i);
                        if (!isItemContained(treasureChest, currentItem)) {
                            treasureChest.add(0, currentItem);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    if (index >= 0 && index < treasureChest.size()) {
                        String currentItem = treasureChest.get(index);
                        treasureChest.remove(currentItem);
                        treasureChest.add(currentItem);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(input.split(" ")[1]);
                    if (count > treasureChest.size()) {
                        count = treasureChest.size();
                    }
                    List<String> stealItems = new ArrayList<>();
                    for (int i = treasureChest.size() - count; i < treasureChest.size(); i++) {
                        stealItems.add(treasureChest.get(i));
                        treasureChest.remove(i);
                        i--;
                    }
                    System.out.println(String.join(", ", stealItems));
                    break;
            }

            input = scanner.nextLine();
        }
        double sum = 0;
        for (String item : treasureChest) {
            sum += item.length();
        }
        sum /= treasureChest.size();
        if (treasureChest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", sum);
        }
    }

    public static boolean isItemContained(List<String> itemList, String item) {
        for (String currentItem : itemList) {
            if (currentItem.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
