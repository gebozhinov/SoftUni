package exam.june2021;

import java.util.Scanner;

public class P02Python {
    public static int length = 1;
    public static int food;
    public static int row;
    public static int col;
    public static boolean isEnemyFound = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        String[] commands = scanner.nextLine().split(", ");

        for (int i = 0; i < matrix.length; i++) {
            char[] input = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = input;
        }

        getPositionAndTotalFood(matrix);

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            switch (currentCommand) {
                case "left":
                    movePython(matrix, 0, -1);
                    break;
                case "right":
                    movePython(matrix, 0, 1);
                    break;
                case "up":
                    movePython(matrix, -1, 0);
                    break;
                case "down":
                    movePython(matrix, 1, 0);
                    break;
            }
            if (isEnemyFound) {
                System.out.println("You lose! Killed by an enemy!");
                break;
            }
            if (food == 0) {
                break;
            }
        }
        if (!isEnemyFound) {
            if (food != 0) {
                System.out.printf("You lose! There is still %d food to be eaten.%n", food);
            } else {
                System.out.printf("You win! Final python length is %d%n", length);
            }
        }
    }
    public static void getPositionAndTotalFood(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if (current == 's') {
                    row = i;
                    col = j;
                } else if (current == 'f') {
                    food++;
                }
            }
        }
    }
    public static void movePython(char[][] matrix, int moveRow, int moveCol) {
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

        if (matrix[row][col] == 'f') {
            length++;
            food--;
            matrix[row][col] = '*';
        } else if (matrix[row][col] == 'e') {
            isEnemyFound = true;
        }

    }
}
