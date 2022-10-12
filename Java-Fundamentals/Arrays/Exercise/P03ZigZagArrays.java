import java.util.Arrays;
import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArr = new int[n];
        int[] secondArr = new int[n];
        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split(" ");
            if (i % 2 == 0) {
                firstArr[i] = Integer.parseInt(inputLine[0]);
                secondArr[i] = Integer.parseInt(inputLine[1]);
            } else {
                firstArr[i] = Integer.parseInt(inputLine[1]);
                secondArr[i] = Integer.parseInt(inputLine[0]);
            }
        }
        System.out.print(Arrays.toString(firstArr)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .trim());
        System.out.println();
        System.out.print(Arrays.toString(secondArr)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .trim());
    }
}
