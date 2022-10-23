import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            List<String> getCommand = List.of(input.split(" "));
            switch (getCommand.get(0)) {
                case "Add":
                    int addNumber = Integer.parseInt(getCommand.get(1));
                    numberList.add(addNumber);
                    break;
                case "Insert":
                    int insertNumber = Integer.parseInt(getCommand.get(1));
                    int atIndex = Integer.parseInt(getCommand.get(2));
                    if (atIndex > numberList.size() || atIndex < 0) {
                        System.out.println("Invalid index");
                        break;
                    }
                    numberList.add(atIndex, insertNumber);
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(getCommand.get(1));
                    if (removeIndex >= numberList.size() || removeIndex < 0) {
                        System.out.println("Invalid index");
                        break;
                    }
                    numberList.remove(removeIndex);
                    break;
                case "Shift":
                    int count = Integer.parseInt(getCommand.get(2));
                    switch (getCommand.get(1)) {
                        case "left":
                            // first number becomes last 'count' times
                            Collections.rotate(numberList, -count);
                            break;
                        case "right":
                            // last number becomes first 'count' times
                            Collections.rotate(numberList, count);
                            break;
                    }
                    break;

            }

            input = scanner.nextLine();
        }
        System.out.print(Arrays.toString(numberList.toArray())
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));

    }
}
