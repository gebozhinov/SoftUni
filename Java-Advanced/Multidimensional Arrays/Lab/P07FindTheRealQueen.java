package multidimensionalArrays.lab;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        char[][] chessBoard = new char[8][8];

        for (int row = 0; row < 8; row++) {
            char[] input = scanner.nextLine().replaceAll(" ", "").toCharArray();
            chessBoard[row] = input;
        }
        StringBuilder validQueenIndexes = new StringBuilder();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                char currentFigure = chessBoard[row][col];
                if (currentFigure != 'q') {
                    continue;
                }
                if (isQueenValid(chessBoard, row, col)) {
                    validQueenIndexes.append(row).append(" ").append(col);
                    break;
                }
            }
        }
        System.out.println(validQueenIndexes);

    }

    public static boolean isQueenValid(char[][] chessBoard, int row, int col) {
        return horizontalRight(chessBoard, row, col);
    }

    public static boolean horizontalRight(char[][] chessBoard, int row, int col) {
        for (int c = col + 1; c < 8; c++) {
            char currentFigure = chessBoard[row][c];
            if (currentFigure == 'q') {
                return false;
            }
        }
        return horizontalLeft(chessBoard, row, col);
    }

    public static boolean horizontalLeft(char[][] chessBoard, int row, int col) {
        for (int c = col - 1; c >= 0; c--) {
            char currentFigure = chessBoard[row][c];
            if (currentFigure == 'q') {
                return false;
            }
        }
        return verticalDown(chessBoard, row, col);
    }

    public static boolean verticalDown(char[][] chessBoard, int row, int col) {
        for (int r = row + 1; r < 8; r++) {
            char currentFigure = chessBoard[r][col];
            if (currentFigure == 'q') {
                return false;
            }
        }
        return verticalUp(chessBoard, row, col);
    }

    public static boolean verticalUp(char[][] chessBoard, int row, int col) {
        for (int r = row - 1; r >= 0; r--) {
            char currentFigure = chessBoard[r][col];
            if (currentFigure == 'q') {
                return false;
            }
        }
        return diagonalLeftDown(chessBoard, row, col);
    }

    public static boolean diagonalLeftDown(char[][] chessBoard, int row, int col) {
        for (int r = row + 1, c = col + 1; r < 8 && c < 8; r++, c++) {
            char currentFigure = chessBoard[r][c];
            if (currentFigure == 'q') {
                return false;
            }
        }
        return diagonalRightDown(chessBoard, row, col);
    }

    public static boolean diagonalRightDown(char[][] chessBoard, int row, int col) {
        for (int r = row + 1, c = col - 1; r < 8 && c >= 0; r++, c--) {
            char currentFigure = chessBoard[r][c];
            if (currentFigure == 'q') {
                return false;
            }
        }
        return diagonalLeftUp(chessBoard, row, col);
    }

    public static boolean diagonalLeftUp(char[][] chessBoard, int row, int col) {
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            char currentFigure = chessBoard[r][c];
            if (currentFigure == 'q') {
                return false;
            }
        }
        return diagonalRightUp(chessBoard, row, col);
    }

    public static boolean diagonalRightUp(char[][] chessBoard, int row, int col) {
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            char currentFigure = chessBoard[r][c];
            if (currentFigure == 'q') {
                return false;
            }
        }
        return true;
    }
}
