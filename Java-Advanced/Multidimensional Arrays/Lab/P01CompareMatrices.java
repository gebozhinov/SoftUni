package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] firstMatrixSize = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstRow = firstMatrixSize[0];
        int firstCol = firstMatrixSize[1];
        int[][] firstMatrix = new int[firstRow][firstCol];
        for (int row = 0; row < firstRow; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            firstMatrix[row] = numbers;
        }

        int[] secondMatrixSize = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int secondRow = secondMatrixSize[0];
        int secondCol = secondMatrixSize[1];
        int[][] secondMatrix = new int[secondRow][secondCol];
        for (int row = 0; row < firstRow; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            secondMatrix[row] = numbers;
        }
        String output = isEqual(firstMatrix, secondMatrix) ? "equal" : "not equal";
        System.out.println(output);
    }

    public static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                int num1 = firstMatrix[row][col];
                int num2 = secondMatrix[row][col];
                if (num1 != num2) {
                    return false;
                }
            }
        }
        return true;
    }
}
