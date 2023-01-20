package multidimensionalArrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");
            matrix[row] = input;
        }
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split(" ");
            if (isCommandValid(command, rows, cols)) {
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);
                String currentWord = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = currentWord;

                printMatrix(matrix);

            } else {
                System.out.println("Invalid input!");
            }


            input = scanner.nextLine();
        }
    }
    public static boolean isCommandValid(String[] command, int rows, int cols) {
        if (!command[0].equals("swap")) {
            return false;
        }
        if (command.length != 5) {
            return false;
        }
        int row1 = Integer.parseInt(command[1]);
        int col1 = Integer.parseInt(command[2]);
        int row2 = Integer.parseInt(command[3]);
        int col2 = Integer.parseInt(command[4]);
        return row1 >= 0 && col1 >= 0 && row2 <= rows && col2 <= cols;
    }
    public static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
