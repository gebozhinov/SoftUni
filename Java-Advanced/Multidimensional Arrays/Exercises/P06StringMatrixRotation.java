package multidimensionalArrays.exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotateInput = Integer.parseInt(scanner.nextLine().split("\\D+")[1]);

        List<String> linesOfMatrix = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            linesOfMatrix.add(input);
            input = scanner.nextLine();
        }
        int rows = linesOfMatrix.size();
        int cols = linesOfMatrix.stream().max(Comparator.comparingInt(String::length)).get().length();

        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                try {
                    matrix[row][col] = linesOfMatrix.get(row).charAt(col);
                } catch (Exception e) {
                    matrix[row][col] = ' ';
                }

            }
        }
        int rotate = rotateInput % 360;
        switch (rotate) {
            case 0:
                printMatrix0Degrees(matrix);
                break;
            case 90:
                printMatrix90Degrees(matrix, cols);
                break;
            case 180:
                printMatrix180Degrees(matrix);
                break;
            case 270:
                printMatrix270Degrees(matrix, cols);
                break;
        }
    }

    public static void printMatrix0Degrees(char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static void printMatrix180Degrees(char[][] matrix) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void printMatrix90Degrees(char[][] matrix, int cols) {
        for (int col = 0; col < cols; col++) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void printMatrix270Degrees(char[][] matrix, int cols) {
        for (int col = cols - 1; col >= 0; col--) {
            for (char[] row : matrix) {
                System.out.print(row[col]);
            }
            System.out.println();
        }
    }
}
