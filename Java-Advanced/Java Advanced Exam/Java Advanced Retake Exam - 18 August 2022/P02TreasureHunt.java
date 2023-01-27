package exam.august2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02TreasureHunt {
    public static int row;
    public static int col;
    public static List<String> correctDirections = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        char[][] matrix = new char[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            String[] field = scanner.nextLine().split(" ");
            for (int j = 0; j < field.length; j++) {
                char current = field[j].charAt(0);
                matrix[i][j] = current;
            }
        }

        startingPosition(matrix);

        String direction = scanner.nextLine();
        while (!direction.equals("Finish")) {
            switch (direction) {
                case "up":
                    movePlayer(matrix, -1, 0, "up");
                    break;
                case "down":
                    movePlayer(matrix, 1, 0, "down");
                    break;
                case "right":
                    movePlayer(matrix, 0, 1, "right");
                    break;
                case "left":
                    movePlayer(matrix, 0, -1, "left");
                    break;
            }

            direction = scanner.nextLine();
        }

        if (matrix[row][col] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s%n", String.join(", ", correctDirections));
        } else {
            System.out.println("The map is fake!");
        }

    }

    public static void startingPosition(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char current = matrix[i][j];
                if (current == 'Y') {
                    row = i;
                    col = j;
                    return;
                }
            }
        }
    }

    public static void movePlayer(char[][] matrix, int firstDirection, int secondDirection, String direction) {
        if (!checkTheSizeOfField(matrix, firstDirection, secondDirection)) {
            return;
        }
        int currentRow = row + firstDirection;
        int currentCol = col + secondDirection;

        if (matrix[currentRow][currentCol] != 'T') {
            row = currentRow;
            col = currentCol;
            correctDirections.add(direction);
        }
    }

    public static boolean checkTheSizeOfField(char[][] matrix, int firstDirection, int secondDirection) {
        return row + firstDirection < matrix.length && row + firstDirection >= 0
                && col + secondDirection < matrix[0].length && col + secondDirection >= 0;
    }
}
