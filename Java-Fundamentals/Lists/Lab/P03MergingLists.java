import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbersList2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int smallerList = Math.min(numbersList1.size(), numbersList2.size());
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < smallerList; i++) {
            results.add(numbersList1.get(i));
            results.add(numbersList2.get(i));
        }

        if (numbersList1.size() > numbersList2.size()) {
            results.addAll(numbersList1.subList(smallerList, numbersList1.size()));
        } else {
            results.addAll(numbersList2.subList(smallerList, numbersList2.size()));
        }
        System.out.print(Arrays.toString(results.toArray())
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));

    }
}
