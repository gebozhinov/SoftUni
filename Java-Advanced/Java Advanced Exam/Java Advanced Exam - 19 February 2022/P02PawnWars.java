package exam.february2022;

import java.util.Scanner;

public class P02PawnWars {
    public static int whiteRow;
    public static int whiteCol;
    public static int blackRow;
    public static int blackCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        char[][] matrix = new char[8][8];
        for (int i = 0; i < matrix.length; i++) {
            char[] line = scanner.nextLine().toCharArray();
            matrix[i] = line;

        }

        getWhitePosition(matrix);
        getBlackPosition(matrix);

        while (true) {
            if (whiteRow -1 == blackRow && (whiteCol - 1 == blackCol || whiteCol + 1 == blackCol)) {
                System.out.printf("Game over! White capture on %c%d.", blackCol + 97, 8 - blackRow);
                break;
            }
            whiteRow -= 1;
            if (whiteRow == 0) {
                System.out.printf("Game over! White pawn is promoted to a queen at %c8.%n", whiteCol + 97);
                break;
            }
            if (whiteRow -1 == blackRow && (whiteCol - 1 == blackCol || whiteCol + 1 == blackCol)) {
                System.out.printf("Game over! Black capture on %c%d.", whiteCol + 97, 8 - whiteRow);
                break;
            }
            blackRow += 1;
            if (blackRow == 7) {
                System.out.printf("Game over! Black pawn is promoted to a queen at %c1.%n", blackCol + 97);
                break;
            }

        }

    }
    public static void getWhitePosition(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if (current == 'w') {
                    matrix[i][j] = '-';
                    whiteRow = i;
                    whiteCol = j;
                    return;
                }
            }
        }
    }
    public static void getBlackPosition(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if (current == 'b') {
                    matrix[i][j] = '-';
                    blackRow = i;
                    blackCol = j;
                    return;
                }
            }
        }
    }
}
