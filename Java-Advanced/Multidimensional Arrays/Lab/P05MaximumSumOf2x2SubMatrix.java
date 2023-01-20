package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = matrixSize[0];
        int cols = matrixSize[1];
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = numbers;
        }
        int[][] result = new int[2][];
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int n1 = matrix[row][col];
                int n2 = matrix[row][col + 1];
                int n3 = matrix[row + 1][col];
                int n4 = matrix[row + 1][col + 1];
                if (n1 + n2 + n3 + n4 > max) {
                    max = n1 + n2 + n3 + n4;
                    result[0] = new int[]{n1, n2};
                    result[1] = new int[]{n3, n4};
                }
            }
        }
        for (int col = 0; col < 2; col++) {
            for (int row = 0; row < 2; row++) {
                System.out.print(result[col][row] + " ");
            }
            System.out.println();
        }
        System.out.println(max);
    }
}
