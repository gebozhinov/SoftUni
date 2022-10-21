import java.util.Scanner;

public class P03LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());
        int x4 = Integer.parseInt(scanner.nextLine());
        int y4 = Integer.parseInt(scanner.nextLine());

        getClosestPoint(x1, y1, x2, y2, x3, y3, x4, y4);

    }

    public static void getClosestPoint(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double firstLine = Math.sqrt((Math.pow(x1 - x2, 2)) + Math.pow(y1 - y2, 2));
        double secondLine = Math.sqrt((Math.pow(x3 - x4, 2)) + Math.pow(y3 - y4, 2));
        if (firstLine >= secondLine) {
            getLongestLine(x1, y1, x2, y2);
        } else {
            getLongestLine(x3, y3, x4, y4);
        }

    }

    public static void getLongestLine(int x1, int y1, int x2, int y2) {
        double firstLine = Math.sqrt((Math.pow(x1, 2)) + Math.pow(y1, 2));
        double secondLine = Math.sqrt((Math.pow(x2, 2)) + Math.pow(y2, 2));
        if (firstLine <= secondLine) {
            System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
        } else {
            System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
        }

    }
}


