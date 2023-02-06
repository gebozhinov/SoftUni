package exam.december2020;

import java.util.Scanner;

public class P02Selling {
    public static int row;
    public static int col;
    public static int collectedMoney = 0;
    public static boolean isPlayerOutOfField = false;

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
            if (isPlayerOutOfField) {
                System.out.println("Bad news, you are out of the exam.december2020.bakery.");
                break;
            }
            if (collectedMoney >= 50) {
                matrix[row][col] = 'S';
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
        }
        System.out.printf("Money: %d%n", collectedMoney);

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
                    matrix[i][j] = '-';
                    row = i;
                    col = j;
                    return;
                }
            }
        }
    }

    public static void movePlayer(char[][] matrix, int moveRow, int moveCol) {
        if (!checkSizeOfField(matrix, moveRow, moveCol)) {
            isPlayerOutOfField = true;
            return;
        }

        row += moveRow;
        col += moveCol;
        if (Character.isDigit(matrix[row][col])) {
            collectedMoney += Character.getNumericValue(matrix[row][col]);
            matrix[row][col] = '-';
        } else if (matrix[row][col] == 'O') {
            matrix[row][col] = '-';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == 'O') {
                        matrix[i][j] = '-';
                        row = i;
                        col = j;
                        return;
                    }
                }
            }
        }
    }

    public static boolean checkSizeOfField(char[][] matrix, int moveRow, int moveCol) {
        return row + moveRow < matrix.length && row + moveRow >= 0
                && col + moveCol < matrix.length && col + moveCol >= 0;
    }
}
