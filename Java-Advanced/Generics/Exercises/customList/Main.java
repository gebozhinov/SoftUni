package generics.exercises.customList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String command = input.split(" ")[0];
            switch (command) {
                case "Add":
                    String element = input.split(" ")[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String elementToContains = input.split(" ")[1];
                    System.out.println(customList.contains(elementToContains));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(input.split(" ")[1]);
                    int secondIndex = Integer.parseInt(input.split(" ")[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String greaterElement = input.split(" ")[1];
                    System.out.println(customList.countGreaterThan(greaterElement));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.print(customList);
                    break;
            }


            input = scanner.nextLine();
        }

    }
}
