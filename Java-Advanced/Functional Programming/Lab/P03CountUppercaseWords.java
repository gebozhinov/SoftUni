package functionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));

        int size = wordsList.stream()
                .filter(isUpperCase)
                .collect(Collectors.toList())
                .size();
        System.out.println(size);
        wordsList.stream().filter(isUpperCase)
                .forEach(System.out::println);


    }
}
