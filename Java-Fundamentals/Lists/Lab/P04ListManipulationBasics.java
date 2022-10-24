import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String inputCommand = scanner.nextLine();
        while (!inputCommand.equals("end")) {
            List<String> getCommand = List.of(inputCommand.split(" "));
            int number = Integer.parseInt(getCommand.get(1));
            switch (getCommand.get(0)) {
                case "Add":
                    numbersList.add(number);
                    break;
                case "Remove":
                    numbersList.remove(Integer.valueOf(number));
                    break;
                case "RemoveAt":
                    numbersList.remove(number);
                    break;
                case "Insert":
                    int index = Integer.parseInt(getCommand.get(2));
                    numbersList.add(index, number);
                    break;
            }
            inputCommand = scanner.nextLine();

        }
        System.out.print(Arrays.toString(numbersList.toArray())
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }
}
