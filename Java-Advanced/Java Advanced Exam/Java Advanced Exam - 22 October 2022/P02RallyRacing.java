package exam.october2022;

import java.util.Scanner;

public class P02RallyRacing {
    public static int row = 0;
    public static int col = 0;
    public static int passedKilometers = 0;
    public static boolean isFinalReached = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();

        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                matrix[i][j] = input[j].charAt(0);
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "left":
                    moveCar(matrix, 0, -1);
                    break;
                case "right":
                    moveCar(matrix, 0, 1);
                    break;
                case "up":
                    moveCar(matrix, -1, 0);
                    break;
                case "down":
                    moveCar(matrix, 1, 0);
                    break;
            }
            if (isFinalReached) {
                break;
            }

            command = scanner.nextLine();
        }
        matrix[row][col] = 'C';
        if (isFinalReached) {
            System.out.printf("Racing car %s finished the stage!%n", carNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }
        System.out.printf("Distance covered %d km.%n", passedKilometers);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void moveCar(char[][] matrix, int firstDirection, int secondDirection) {

        int currentRow = row + firstDirection;
        int currentCol = col + secondDirection;

        if (matrix[currentRow][currentCol] == '.') {
            passedKilometers += 10;
        } else if (matrix[currentRow][currentCol] == 'F') {
            passedKilometers += 10;
            isFinalReached = true;
        } else {
            matrix[currentRow][currentCol] = '.';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == 'T') {
                        matrix[i][j] = '.';
                        row = i;
                        col = j;
                        passedKilometers += 30;
                        return;
                    }
                }
            }
        }
        row = currentRow;
        col = currentCol;
    }

}
