package exam.february2021;

import java.util.Scanner;

public class P02Bomb {
    public static int row;
    public static int col;
    public static int countOfBombs = 0;
    public static int deactivatedBombs = 0;
    public static boolean isEndOfRouteFound = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] matrix = new char[n][n];
        for (int i = 0; i < matrix.length; i++) {
            char[] input = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = input;
        }

        getPositionAndCountOfBombs(matrix);

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            switch (currentCommand) {
                case "left":
                    moveSapper(matrix, 0, -1);
                    break;
                case "right":
                    moveSapper(matrix, 0, 1);
                    break;
                case "up":
                    moveSapper(matrix, -1, 0);
                    break;
                case "down":
                    moveSapper(matrix, 1, 0);
                    break;
            }
            if (isEndOfRouteFound) {
                break;
            }
            if (countOfBombs == 0) {
                break;
            }
        }
        if (countOfBombs == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (isEndOfRouteFound) {
            System.out.printf("END! %d bombs left on the field%n", countOfBombs);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", countOfBombs, row, col);
        }

    }

    public static void getPositionAndCountOfBombs(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 's') {
                    row = i;
                    col = j;
                } else if (matrix[i][j] == 'B') {
                    countOfBombs++;
                }
            }
        }
    }

    public static void moveSapper(char[][] matrix, int moveRow, int moveCol) {
        if (!checkSizeOfField(matrix, moveRow, moveCol)) {
            return;
        }

        row += moveRow;
        col += moveCol;
        if (matrix[row][col] == 'B') {
            matrix[row][col] = '+';
            deactivatedBombs++;
            countOfBombs--;
            System.out.println("You found a bomb!");
        } else if (matrix[row][col] == 'e') {
            isEndOfRouteFound = true;
        }

    }

    public static boolean checkSizeOfField(char[][] matrix, int moveRow, int moveCol) {
        return row + moveRow < matrix.length && row + moveRow >= 0
                && col + moveCol < matrix.length && col + moveCol >= 0;
    }
}
