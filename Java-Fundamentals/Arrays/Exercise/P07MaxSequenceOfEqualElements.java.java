import java.util.Scanner;

public class P07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] inputLine = scanner.nextLine().split(" ");
        int[] numbers = new int[inputLine.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputLine[i]);
        }


        String outputLine = "";
        int maxCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            String currentLine = "";
            int currentCount = 0;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    currentCount++;
                    currentLine += numbers[i] + " ";
                } else {
                    break;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                outputLine = currentLine;
            }
        }
        System.out.println(outputLine);

    }
}
