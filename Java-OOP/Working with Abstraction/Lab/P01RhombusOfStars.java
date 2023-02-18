package workingWithAbstraction.lab;

import java.util.Scanner;

public class P01RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printRhombus(n);
    }

    public static void printRhombus(int n) {
        for (int i = 0; i < n; i++) {
            printUpperRow(n, i, " ", "* ");
        }
        for (int i = 0; i < n - 1; i++) {
            printBottomRow(n, i, " ", "* ");
        }
    }

    public static void printUpperRow(int n, int start, String firstPattern, String secondPattern) {
        for (int j = start; j < n - 1; j++) {
            System.out.print(firstPattern);
        }
        for (int j = 0; j <= start; j++) {
            System.out.print(secondPattern);
        }
        System.out.println();

    }

    public static void printBottomRow(int n, int start, String firstPattern, String secondPattern) {
        for (int j = 0; j <= start; j++) {
            System.out.print(firstPattern);
        }
        for (int j = start; j < n - 1; j++) {
            System.out.print(secondPattern);
        }
        System.out.println();

    }

}