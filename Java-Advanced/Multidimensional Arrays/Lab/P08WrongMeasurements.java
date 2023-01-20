package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbers;
        }

        int[] indexesOfWrongValue = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int wrongValue = matrix[indexesOfWrongValue[0]][indexesOfWrongValue[1]];

        int[][] outputMatrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentValue = matrix[row][col];
                if (currentValue != wrongValue) {
                    outputMatrix[row][col] = matrix[row][col];
                    continue;
                }
                outputMatrix[row][col] = (sumNearestElements(matrix, row, col, wrongValue));
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < outputMatrix[row].length; col++) {
                System.out.print(outputMatrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    public static int sumNearestElements(int[][] matrix, int rows, int cols, int wrongValue) {
        return replaceDown(matrix, rows, cols, wrongValue)
                + replaceUp(matrix, rows, cols, wrongValue)
                + replaceRight(matrix, rows, cols, wrongValue)
                + replaceLeft(matrix, rows, cols, wrongValue);
    }

    public static int replaceDown(int[][] matrix, int rows, int cols, int wrongValue) {
        for (int row = rows + 1; row <= rows + 1 && row < matrix.length; row++) {
            int value = matrix[row][cols];
            if (value != wrongValue) {
                return value;
            }
        }
        return 0;
    }

    public static int replaceUp(int[][] matrix, int rows, int cols, int wrongValue) {
        for (int row = rows - 1; row >= rows - 1 && row >= 0; row--) {
            int value = matrix[row][cols];
            if (value != wrongValue) {
                return value;
            }
        }
        return 0;
    }

    public static int replaceRight(int[][] matrix, int rows, int cols, int wrongValue) {
        try {
            for (int col = cols + 1; col <= cols + 1; col++) {
                int value = matrix[rows][col];
                if (value != wrongValue) {
                    return value;
                }
            }
        } catch (Exception e) {
            return 0;
        }

        return 0;
    }

    public static int replaceLeft(int[][] matrix, int rows, int cols, int wrongValue) {
        for (int col = cols - 1; col >= cols - 1 && col >= 0; col--) {
            int value = matrix[rows][col];
            if (value != wrongValue) {
                return value;
            }
        }
        return 0;
    }
}
