import java.util.*;
import java.util.stream.Collectors;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Map<Integer, Integer> numbersMap = new TreeMap<>();
        for (Integer integer : numberList) {
            numbersMap.putIfAbsent(integer, 0);
            int value = numbersMap.get(integer);
            numbersMap.put(integer, value + 1);

        }
        for (Map.Entry<Integer, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%d -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
