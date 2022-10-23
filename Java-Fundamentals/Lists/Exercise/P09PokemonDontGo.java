import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDoNotGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sumNumbers = 0;
        while (!numberList.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int removedNumber;
            if (index < 0) {
                removedNumber = numberList.get(0);
                numberList.set(0, numberList.get(numberList.size() - 1));
            } else if (index > numberList.size() - 1) {
                removedNumber = numberList.get(numberList.size() - 1);
                numberList.set(numberList.size() - 1, numberList.get(0));
            } else {
                removedNumber = numberList.get(index);
                numberList.remove(index);
            }
            for (int i = 0; i < numberList.size(); i++) {
                if (numberList.get(i) <= removedNumber) {
                    numberList.set(i, numberList.get(i) + removedNumber);
                } else {
                    numberList.set(i, numberList.get(i) - removedNumber);
                }
            }
            sumNumbers += removedNumber;
        }
        System.out.println(sumNumbers);
    }
}
