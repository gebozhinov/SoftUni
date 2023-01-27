package exam.june2022;

import java.util.Scanner;

public class P02StickyFingers {
    public static int row;
    public static int col;
    public static int stolenMoney = 0;
    public static boolean gotCaught = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        String[] commands = scanner.nextLine().split(",");

        for (int i = 0; i < size; i++) {
            String input = scanner.nextLine().replaceAll(" ", "");
            matrix[i] = input.toCharArray();
        }

        startingPosition(matrix);
        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            switch (currentCommand) {
                case "left":
                    movePlayer(matrix, 0, -1);
                    break;
                case "right":
                    movePlayer(matrix, 0, 1);
                    break;
                case "up":
                    movePlayer(matrix, -1, 0);
                    break;
                case "down":
                    movePlayer(matrix, 1, 0);
                    break;
            }
            if (gotCaught) {
                break;
            }
        }


        if (!gotCaught) {
            matrix[row][col] = 'D';
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void startingPosition(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if (current == 'D') {
                    row = i;
                    col = j;
                    matrix[i][j] = '+';
                    return;
                }
            }
        }
    }

    public static void movePlayer(char[][] matrix, int moveRow, int moveCol) {
        if (!checkTheSizeOfField(matrix, moveRow, moveCol)) {
            System.out.println("You cannot leave the town, there is police outside!");
            return;
        }

        int currentRow = row + moveRow;
        int currentCol = col + moveCol;

        switch (matrix[currentRow][currentCol]) {
            case '$':
                matrix[currentRow][currentCol] = '+';
                int money = currentRow * currentCol;
                stolenMoney += money;
                System.out.printf("You successfully stole %d$.%n", money);
                break;
            case 'P':
                matrix[currentRow][currentCol] = '#';
                gotCaught = true;
                System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                break;
        }

        row = currentRow;
        col = currentCol;

    }

    public static boolean checkTheSizeOfField(char[][] matrix, int moveRow, int moveCol) {
        return row + moveRow < matrix.length && row + moveRow >= 0
                && col + moveCol < matrix.length && col + moveCol >= 0;
    }
}
