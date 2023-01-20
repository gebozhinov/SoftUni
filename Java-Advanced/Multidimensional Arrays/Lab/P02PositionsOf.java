package multidimensionalArrays.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = numbers;
        }
        ArrayList<String> outputIndexes = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int getNumber = matrix[row][col];
                if (n == getNumber) {
                    outputIndexes.add(row + " " + col);

                }
            }
        }
        if (outputIndexes.isEmpty()) {
            System.out.println("not found");
        } else {
            outputIndexes.forEach(System.out::println);
        }

    }
}
