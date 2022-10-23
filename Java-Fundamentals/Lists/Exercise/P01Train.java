import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> wagonList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> command = List.of(input.split(" "));
            // if first element of the command list is "Add", then second element is Integer
            // add second element at the end of the wagonList
            if (command.get(0).equals("Add")) {
                int addWagon = Integer.parseInt(command.get(1));
                wagonList.add(addWagon);
            } else { // find an existing wagon to fit all the passengers
                int numberOfPassengers = Integer.parseInt(command.get(0));
                for (int i = 0; i < wagonList.size(); i++) {
                    if (numberOfPassengers + wagonList.get(i) <= capacity) {
                        wagonList.set(i, wagonList.get(i) + numberOfPassengers);
                        break;
                    }
                }

            }
            input = scanner.nextLine();

        }
        System.out.print(Arrays.toString(wagonList.toArray())
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }
}
