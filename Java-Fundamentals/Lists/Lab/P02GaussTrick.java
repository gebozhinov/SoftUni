import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int listSize = numbersList.size() / 2;
        for (int i = 0; i < listSize; i++) {
            int firstIndex = numbersList.get(i);
            int secondIndex = numbersList.get(numbersList.size() - 1);
            numbersList.set(i, firstIndex + secondIndex);
            numbersList.remove(numbersList.get(numbersList.size() - 1));
        }


        System.out.print(Arrays.toString(numbersList.toArray())
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));


    }
}
