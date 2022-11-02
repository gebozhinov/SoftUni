import java.util.*;
import java.util.stream.Collectors;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().toLowerCase().split(" "))
                .collect(Collectors.toList());
        Map<String, Integer> oddOccurrences = new LinkedHashMap<>();
        for (String inputWord : input) {
            oddOccurrences.putIfAbsent(inputWord, 0);
            int count = oddOccurrences.get(inputWord);
            oddOccurrences.put(inputWord, count + 1);

        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : oddOccurrences.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                result.add(entry.getKey());
            }
        }
        System.out.printf("%s", String.join(", ", result));

    }
}
