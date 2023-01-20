package multidimensionalArrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        for (int row = 0; row < matrix.length; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbers;
        }
        int difference = Math.abs(upDownDiagonal(matrix) - downUpDiagonal(matrix));
        System.out.println(difference);

    }

    public static int upDownDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0, col = 0; row < matrix.length && col < matrix.length; row++, col++) {
            sum += matrix[row][col];
        }
        return sum;
    }

    public static int downUpDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = matrix.length - 1, col = 0; row >= 0 && col <= matrix.length; row--, col++) {
            sum += matrix[row][col];

        }
        return sum;
    }
}
