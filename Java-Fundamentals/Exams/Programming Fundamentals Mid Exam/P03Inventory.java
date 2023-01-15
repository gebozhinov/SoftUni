package exam.mid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> itemsList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Craft!")) {
            String command = input.split(" - ")[0];
            String item = input.split(" - ")[1];
            switch (command) {
                case "Collect":
                    if (!isTheItemExist(itemsList, item)) {
                        itemsList.add(item);
                    }
                    break;
                case "Drop":
                    if (isTheItemExist(itemsList, item)) {
                        itemsList.remove(item);
                    }
                    break;
                case "Combine Items":
                    String oldItem = item.split(":")[0];
                    String newItem = item.split(":")[1];
                    if (isTheItemExist(itemsList, oldItem)) {
                        int index = -1;
                        for (String currentItem : itemsList) {
                            index++;
                            if (currentItem.equals(oldItem)) {
                                break;
                            }
                        }
                        itemsList.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (isTheItemExist(itemsList, item)) {
                        itemsList.remove(item);
                        itemsList.add(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", itemsList));
    }

    public static boolean isTheItemExist(List<String> itemList, String item) {
        for (String currentItem : itemList) {
            if (currentItem.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
