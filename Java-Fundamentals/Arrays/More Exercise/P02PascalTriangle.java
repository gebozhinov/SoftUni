import java.util.Scanner;

public class P02PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printPascal(n);

    }
    public static void printPascal(int n)
    {
        int[][] arr = new int[n][n];

        for (int line = 0; line < n; line++)
        {
            for (int i = 0; i <= line; i++)
            {
                if (line == i || i == 0)
                    arr[line][i] = 1;
                else
                    arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
                System.out.print(arr[line][i] + " ");
            }
            System.out.println("");
        }
    }
}
