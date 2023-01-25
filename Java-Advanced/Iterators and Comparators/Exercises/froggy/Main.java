package iteratorsAndComparators.exercises.froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> data = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        Lake lake = new Lake(data);

        List<String> result = new ArrayList<>();
        for (Integer integer : lake) {
            result.add(String.valueOf(integer));
        }

        System.out.println(String.join(", ", result));

    }
}
