package multidimensionalArrays.lab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix;
        char[][] secondMatrix;

        firstMatrix = readMatrix(scanner, rows);
        secondMatrix = readMatrix(scanner, rows);

        char[][] outputMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstElement = firstMatrix[row][col];
                char secondElement = secondMatrix[row][col];
                if (firstElement == secondElement) {
                    outputMatrix[row][col] = firstElement;
                } else {
                    outputMatrix[row][col] = '*';
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(outputMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner scanner, int row) {
        char[][] matrix = new char[row][];
        for (int i = 0; i < row; i++) {
            String in = scanner.nextLine().replaceAll(" ", "");
            char[] input = in.toCharArray();
            matrix[i] = input;
        }
        return matrix;
    }
}
