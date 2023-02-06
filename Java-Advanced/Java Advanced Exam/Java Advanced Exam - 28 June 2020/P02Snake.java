package exam.june2020;

import java.util.Scanner;

public class P02Snake {
    public static int row;
    public static int col;
    public static int eatenFood = 0;
    public static boolean isSnakeOutOfField = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < matrix.length; i++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[i] = input;
        }

        getPosition(matrix);

        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    moveSnake(matrix, -1, 0);
                    break;
                case "down":
                    moveSnake(matrix, 1, 0);
                    break;
                case "left":
                    moveSnake(matrix, 0, -1);
                    break;
                case "right":
                    moveSnake(matrix, 0, 1);
                    break;
            }
            if (isSnakeOutOfField) {
                break;
            }
            if (eatenFood == 10) {
                break;
            }
        }
        if (isSnakeOutOfField) {
            System.out.println("Game over!");
        } else {
            matrix[row][col] = 'S';
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", eatenFood);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void getPosition(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'S') {
                    matrix[i][j] = '.';
                    row = i;
                    col = j;
                    return;
                }
            }
        }
    }

    public static void moveSnake(char[][] matrix, int moveRow, int moveCol) {
        if (!checkTheSizeOfField(matrix, moveRow, moveCol)) {
            isSnakeOutOfField = true;
            return;
        }

        row += moveRow;
        col += moveCol;

        if (matrix[row][col] == '*') {
            eatenFood++;
            matrix[row][col] = '.';
        } else if (matrix[row][col] == 'B') {
            matrix[row][col] = '.';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == 'B') {
                        matrix[i][j] = '.';
                        row = i;
                        col = j;
                        return;
                    }
                }
            }
        } else {
            matrix[row][col] = '.';
        }
    }

    public static boolean checkTheSizeOfField(char[][] matrix, int moveRow, int moveCol) {
        return row + moveRow < matrix.length && row + moveRow >= 0
                && col + moveCol < matrix.length && col + moveCol >= 0;
    }
}
