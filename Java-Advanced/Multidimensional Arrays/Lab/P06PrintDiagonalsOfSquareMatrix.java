package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = numbers;
        }
        int[][] resultMatrix = new int[2][n];
        for (int row = 0; row < n; row++) {
            for (int col = row; col <= row ; col++) {
                resultMatrix[0][row] = matrix[row][col];
            }
        }
        for (int row = n - 1; row >= 0 ; row--) {
            for (int col = n - row - 1; col <= n - row - 1 ; col++) {
                resultMatrix[1][row] = matrix[col][row];
            }
        }
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < n ; col++) {
                System.out.print(resultMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
