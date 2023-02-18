package exceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Scanner;

public class P01NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.printf("Range: [%d...%d]%n", range[0], range[1]);

        while (true) {
            String input = scanner.nextLine();
            String output = String.format("Invalid number: %s", input);
            boolean isInputValid = false;
            try {
                int num = isNumberValid(range, input);
                output = String.format("Valid number: %d", num);
                isInputValid = true;
            } catch (NumberFormatException ignored) {
            }

            System.out.println(output);

            if (isInputValid) {
                break;
            }


        }

    }

    private static int isNumberValid(int[] range, String input) {
        int num = Integer.parseInt(input);

        if (!(num >= range[0] && num <= range[1])) {
            throw new NumberFormatException( String.format("Invalid number: %s", input));
        }
        return num;
    }
}
