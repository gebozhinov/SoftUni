import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] inputLine = scanner.nextLine().split(" ");
        int[] numbers = new int[inputLine.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputLine[i]);
        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] splitCommand = command.split(" ");
            if (command.contains("swap")) {
                int[] swapCommand = new int[splitCommand.length - 1];
                for (int i = 0; i < splitCommand.length - 1; i++) {
                    swapCommand[i] = Integer.parseInt(splitCommand[i + 1]);
                }
                int oldIndex = numbers[swapCommand[0]];
                numbers[swapCommand[0]] = numbers[swapCommand[1]];
                numbers[swapCommand[1]] = oldIndex;

            } else if (command.contains("multiply")) {
                int[] multiplyCommand = new int[splitCommand.length - 1];
                for (int i = 0; i < splitCommand.length - 1; i++) {
                    multiplyCommand[i] = Integer.parseInt(splitCommand[i + 1]);
                }
                numbers[multiplyCommand[0]] = numbers[multiplyCommand[0]] * numbers[multiplyCommand[1]];
            } else {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] -= 1;
                }
            }
            command = scanner.nextLine();
        }

        String[] result = new String[numbers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }
        System.out.print(String.join(", ", result));
    }
}
