package exceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int start = 1;
        int end = 100;

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 10) {

            try {
                start = readNumber(start, end, scanner);
                numbers.add(start);
            } catch (IllegalArgumentException ignored) {
                System.out.println("Invalid Number!");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println(numbers.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));

    }

    private static int readNumber(int start, int end, Scanner scanner) {
        int num = Integer.parseInt(scanner.nextLine());

        if (!(start < num && num < end)) {
            throw new IllegalStateException(String.format("Your number is not in range %s - 100!", start));
        }
        return num;
    }
}
