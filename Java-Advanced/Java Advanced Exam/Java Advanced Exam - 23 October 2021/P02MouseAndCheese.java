package exam.october2021;

import java.util.Scanner;

public class P02MouseAndCheese {
    public static int row;
    public static int col;
    public static int eatenCheese = 0;
    public static boolean isMoseOutOfField = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[i] = input;
        }


        getPosition(matrix);

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    moveMouse(matrix, -1, 0);
                    break;
                case "down":
                    moveMouse(matrix, 1, 0);
                    break;
                case "left":
                    moveMouse(matrix, 0, -1);
                    break;
                case "right":
                    moveMouse(matrix, 0, 1);
                    break;
            }

            if (isMoseOutOfField) {
                System.out.println("Where is the mouse?");
                break;
            }

            command = scanner.nextLine();
        }
        if (!isMoseOutOfField) {
            matrix[row][col] = 'M';
        }

        if (eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
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
                if (current == 'M') {
                    matrix[i][j] = '-';
                    row = i;
                    col = j;
                    return;
                }
            }
        }
    }

    public static void moveMouse(char[][] matrix, int moveRow, int moveCol) {
        if (!checkSizeField(matrix, moveRow, moveCol)) {
            matrix[row][col] = '-';
            isMoseOutOfField = true;
            return;
        }

        row += moveRow;
        col += moveCol;
        if (matrix[row][col] == 'c') {
            matrix[row][col] = '-';
            eatenCheese++;
        } else if (matrix[row][col] == 'B') {
            matrix[row][col] = '-';
            moveMouse(matrix, moveRow, moveCol);
        }

    }

    public static boolean checkSizeField(char[][] matrix, int moveRow, int moveCol) {
        return row + moveRow < matrix.length && row + moveRow >= 0
                && col + moveCol < matrix.length && col + moveCol >= 0;
    }
}
