package basicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class P01RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sum(arr, 0));
    }
    public static int sum(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }

        return arr[index] + sum(arr, index + 1);


    }
}
