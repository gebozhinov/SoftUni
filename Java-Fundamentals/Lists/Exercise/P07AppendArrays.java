import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> inputList = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();
        for (String list : inputList) {
            if (list.trim().equals("")) {
                continue;
            }
            List<Integer> splitList = Arrays.stream(list.trim().split("\\s+"))
                    .map(Integer::parseInt).collect(Collectors.toList());
            addNumbersToFinalList(splitList, resultList);
        }

        System.out.print(Arrays.toString(resultList.toArray())
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));

    }
    public static void addNumbersToFinalList(List<Integer> list, List<Integer> resulList) {
        for (int i = list.size() - 1; i >= 0; i--) {
            resulList.add(0, list.get(i));
        }
    }
}
