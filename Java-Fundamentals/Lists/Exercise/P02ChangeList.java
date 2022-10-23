import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            List<String> getCommand = List.of(command.split(" "));
            switch (getCommand.get(0)) {
                case "Delete":
                    // delete all elements in the array, which are equal to the given element
                    int deleteElement = Integer.parseInt(getCommand.get(1));
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) == deleteElement) {
                            numbersList.remove(numbersList.get(i));
                            i -= 1;
                        }
                    }
                    break;
                case "Insert":
                    // insert element at the given position
                    int insertElement = Integer.parseInt(getCommand.get(1));
                    int atPosition = Integer.parseInt(getCommand.get(2));
                    numbersList.add(atPosition, insertElement);
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.print(Arrays.toString(numbersList.toArray())
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));

    }
}
