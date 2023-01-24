package functionalProgramming.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int num = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> predicate = e -> e % num != 0;
        numbers = numbers.stream().filter(predicate).collect(Collectors.toList());
        Collections.reverse(numbers);
        numbers.forEach(e -> System.out.print(e + " "));


    }
}
