import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] inputLine = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputLine.length; i++) {
            for (int j = i + 1; j < inputLine.length; j++) {
                if (inputLine[i] + inputLine[j] == n) {
                    System.out.println(inputLine[i] + " " + inputLine[j]);

                }
            }
        }
    }
}
