package exam.august2020;

import java.util.Scanner;

public class P02Bee {
    public static int row;
    public static int col;
    public static int flowers = 0;
    public static boolean isBeeOutOfField = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < matrix.length; i++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[i] = input;
        }

        getPosition(matrix);

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    moveBee(matrix, -1, 0);
                    break;
                case "down":
                    moveBee(matrix, 1, 0);
                    break;
                case "left":
                    moveBee(matrix, 0, -1);
                    break;
                case "right":
                    moveBee(matrix, 0, 1);
                    break;
            }
            if (isBeeOutOfField) {
                break;
            }
            command = scanner.nextLine();
        }
        if (isBeeOutOfField) {
            System.out.println("The bee got lost!");
        } else {
            matrix[row][col] = 'B';
        }
        if (flowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
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
                if (matrix[i][j] == 'B') {
                    row = i;
                    col = j;
                    matrix[i][j] = '.';
                    return;
                }
            }
        }
    }

    public static void moveBee(char[][] matrix, int moveRow, int moveCol) {
        if (!checkTheSizeOfField(matrix, moveRow, moveCol)) {
            isBeeOutOfField = true;
            return;
        }

        row += moveRow;
        col += moveCol;

        if (matrix[row][col] == 'f') {
            flowers++;
            matrix[row][col] = '.';
        } else if (matrix[row][col] == 'O') {
            matrix[row][col] = '.';
            moveBee(matrix, moveRow, moveCol);
        }
    }

    public static boolean checkTheSizeOfField(char[][] matrix, int moveRow, int moveCol) {
        return row + moveRow < matrix.length && row + moveRow >= 0
                && col + moveCol < matrix.length && col + moveCol >= 0;
    }
}
