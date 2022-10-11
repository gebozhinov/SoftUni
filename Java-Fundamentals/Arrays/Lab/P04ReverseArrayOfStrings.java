import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String inputLine = scanner.nextLine();
        String[] inputLineArr = inputLine.split(" ");

        for (int i = 0; i < inputLineArr.length / 2; i++) {
            String lastElement = inputLineArr[i];
            inputLineArr[i] = inputLineArr[inputLineArr.length - 1 - i];
            inputLineArr[inputLineArr.length - 1 - i] = lastElement;

        }
        System.out.print(String.join(" ", inputLineArr));

    }
}
