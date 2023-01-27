package exam.april2022;

import java.util.Scanner;

public class P02Armory {
    public static int row;
    public static int col;
    public static int price = 0;
    public static boolean isOutOfField = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            matrix[i] = input.toCharArray();
        }

        startingPosition(matrix);

        String direction = scanner.nextLine();
        while (true) {
            switch (direction) {
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
            if (isOutOfField) {
                break;
            }
            if (price >= 65) {
                break;
            }
            direction = scanner.nextLine();
        }

        if (isOutOfField) {
            System.out.println("I do not need more swords!");
        } else {
            matrix[row][col] = 'A';
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", price);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static void startingPosition(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if (current == 'A') {
                    matrix[i][j] = '-';
                    row = i;
                    col = j;
                    return;
                }
            }
        }
    }

    public static void movePlayer(char[][] matrix, int moveRow, int moveCol) {
        if (!checkTheSizeOfField(matrix, moveRow, moveCol)) {
            isOutOfField = true;
            return;
        }

        int currentRow = row + moveRow;
        int currentCol = col + moveCol;

        char position = matrix[currentRow][currentCol];
        if (Character.isDigit(position)) {
            price += Character.getNumericValue(position);
            matrix[currentRow][currentCol] = '-';
        } else if (position == 'M') {
            matrix[currentRow][currentCol] = '-';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    char mirror = matrix[i][j];
                    if (mirror == 'M') {
                        row = i;
                        col = j;
                        matrix[i][j] = '-';
                        return;
                    }
                }
            }
        }
        row = currentRow;
        col = currentCol;
    }

    public static boolean checkTheSizeOfField(char[][] matrix, int moveRow, int moveCol) {
        return row + moveRow < matrix.length && row + moveRow >= 0
                && col + moveCol < matrix.length && col + moveCol >= 0;
    }
}
