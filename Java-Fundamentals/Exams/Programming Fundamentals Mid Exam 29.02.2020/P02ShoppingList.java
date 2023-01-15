package exam.mid.february2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")) {
            String command = input.split(" ")[0];
            String item = input.split(" ")[1];
            switch (command) {
                case "Urgent":
                    if (!isTheItemExist(shoppingList, item)) {
                        shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    if (isTheItemExist(shoppingList, item)) {
                        shoppingList.remove(item);
                    }
                    break;
                case "Correct":
                    if (isTheItemExist(shoppingList, item)) {
                        String newItem = input.split(" ")[2];
                        int index = getIndexOfAItem(shoppingList, item);
                        shoppingList.set(index, newItem);
                    }
                    break;
                case "Rearrange":
                    if (isTheItemExist(shoppingList, item)) {
                        shoppingList.remove(item);
                        shoppingList.add(item);

                    }
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", shoppingList));

    }

    public static boolean isTheItemExist(List<String> shoppingList, String item) {
        for (String shopItem : shoppingList) {
            if (shopItem.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static int getIndexOfAItem(List<String> shoppingList, String item) {
        int index = -1;
        for (String shopItem : shoppingList) {
            index++;
            if (shopItem.equals(item)) {
                break;
            }
        }
        return index;
    }
}
