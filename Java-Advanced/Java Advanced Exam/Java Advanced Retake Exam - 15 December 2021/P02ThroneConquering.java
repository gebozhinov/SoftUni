package exam.december2021;

import java.util.Scanner;

public class P02ThroneConquering {
    public static int parisRow;
    public static int parisCol;
    public static int helenRow;
    public static int helenCol;

    public static int parisEnergy;

    public static boolean isParisDead = false;
    public static boolean isHelenFound = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n * 2];
        for (int i = 0; i < matrix.length; i++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[i] = input;
        }

        getPosition(matrix);
        parisEnergy = energy;

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            String direction = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);
            matrix[row][col] = 'S';
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
            if (isHelenFound) {
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
                break;
            }
            if (isParisDead || parisEnergy <= 0) {
                matrix[parisRow][parisCol] = 'X';
                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void getPosition(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char current = matrix[i][j];
                if (current == 'P') {
                    matrix[i][j] = '-';
                    parisRow = i;
                    parisCol = j;
                } else if (current == 'H') {
                    helenRow = i;
                    helenCol = j;
                }
            }
        }
    }


    public static void movePlayer(char[][] matrix, int moveRow, int moveCol) {
        parisEnergy -= 1;
        if (!checkFieldSize(matrix, moveRow, moveCol)) {
            return;
        }
        parisRow += moveRow;
        parisCol += moveCol;

        if (matrix[parisRow][parisCol] == 'S') {
            parisEnergy -= 2;
            if (parisEnergy <= 0) {
                isParisDead = true;
                matrix[parisRow][parisCol] = 'X';
            } else {
                matrix[parisRow][parisCol] = '-';
            }
        } else if (matrix[parisRow][parisCol] == 'H') {
            isHelenFound = true;
            matrix[parisRow][parisCol] = '-';
        }
    }

    public static boolean checkFieldSize(char[][] matrix, int moveRow, int moveCol) {
        return parisRow + moveRow < matrix.length && parisRow + moveRow >= 0
                && parisCol + moveCol < matrix[0].length && parisCol + moveCol >= 0;
    }
}
