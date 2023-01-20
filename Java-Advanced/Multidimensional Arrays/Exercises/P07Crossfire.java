package multidimensionalArrays.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] demensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = demensions[0];
        int cols = demensions[1];
        int counter = 1;
        List<List<Integer>> matrixList = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            matrixList.add(row, new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrixList.get(row).add(counter);
                counter++;
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int row = Integer.parseInt(input.split(" ")[0]);
            int col = Integer.parseInt(input.split(" ")[1]);
            int radius = Integer.parseInt(input.split(" ")[2]);
            for (int i = row - radius; i <= row + radius; i++) {
                if (isInRange(matrixList, i, col) && i != row) {
                    matrixList.get(i).remove(col);
                }
            }
            for (int i = col + radius; i >= col - radius; i--) {
                if (isInRange(matrixList, row, i)) {
                    matrixList.get(row).remove(i);
                }

            }

            matrixList.removeIf(List::isEmpty);
            input = scanner.nextLine();
        }
        for (List<Integer> row : matrixList) {
            for (Integer col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

    }

    public static boolean isInRange(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

}
