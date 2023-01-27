package exam.august2021;

import java.util.Scanner;

public class P02FormulaOne {
    public static int row;
    public static int col;
    public static boolean isFinishLineReached = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int countOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < size; i++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[i] = input;
        }

        getPosition(matrix);

        for (int i = 0; i < countOfCommands; i++) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    movePlayer(matrix, -1, 0);
                    break;
                case "down":
                    movePlayer(matrix, 1, 0);
                    break;
                case "left":
                    movePlayer(matrix, 0, -1);
                    break;
                case "right":
                    movePlayer(matrix, 0, 1);
                    break;
            }
            if (isFinishLineReached) {
                break;
            }
        }
        if (isFinishLineReached) {
            System.out.println("Well done, the player won first place!");
        } else {
            matrix[row][col] = 'P';
            System.out.println("Oh no, the player got lost on the track!");
        }
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
                char current = matrix[i][j];
                if (current == 'P') {
                    matrix[i][j] = '.';
                    row = i;
                    col = j;
                    return;
                }
            }
        }
    }

    public static void movePlayer(char[][] matrix, int moveRow, int moveCol) {
        row += moveRow;
        col += moveCol;
        if (row < 0) {
            row = matrix.length - 1;
        } else if (row > matrix.length - 1) {
            row = 0;
        }
        if (col < 0) {
            col = matrix.length - 1;
        } else if (col > matrix.length - 1) {
            col = 0;
        }

        if (matrix[row][col] == 'B') {
            movePlayer(matrix, moveRow, moveCol);
        } else if (matrix[row][col] == 'T') {
            row -= moveRow;
            col -= moveCol;
        } else if (matrix[row][col] == 'F') {
            matrix[row][col] = 'P';
            isFinishLineReached = true;
        }

    }
}
