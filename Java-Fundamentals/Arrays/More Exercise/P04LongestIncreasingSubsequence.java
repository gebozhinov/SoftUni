import java.util.Arrays;
import java.util.Scanner;

public class P04LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] inputLine = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] len = new int[inputLine.length];
        int[] prev = new int[inputLine.length];
        int maxLen = 0;
        int lastIndex = -1;
        for (int i = 0; i < inputLine.length; i++) {
            len[i] = 1;
            prev[i] = -1;
            for (int j = 0; j <= i - 1; j++) {
                if (inputLine[j] < inputLine[i] && len[j] + 1 > len[i]) {
                    len[i] = 1 + len[i];
                    prev[i] = j;
                }
                if (len[i] > maxLen) {
                    maxLen = len[i];
                    lastIndex = i;
                }
            }

        }
        int[] lis = new int[maxLen];
        int currentIndex = maxLen - 1;
        while (lastIndex != -1) {
            lis[currentIndex] = inputLine[lastIndex];
            currentIndex--;
            lastIndex = prev[lastIndex];
        }
        for (int li : lis) {
            System.out.print(li + " ");

        }
    }
}
