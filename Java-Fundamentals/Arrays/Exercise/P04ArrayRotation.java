import java.util.Arrays;
import java.util.Scanner;

public class P04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] inputLine = scanner.nextLine().split(" ");
        int rotateCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotateCount; i++) {
            String currentElement = inputLine[0];
            for (int j = 0; j < inputLine.length - 1; j++) {
                inputLine[j] = inputLine[j + 1];
            }
            inputLine[inputLine.length - 1] = currentElement;
        }
        System.out.println(String.join(" ", inputLine));

    }
}
