import java.util.Scanner;

public class P02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        int firstPoint = getClosestPoint(x1, y1);
        int secondPoint = getClosestPoint(x2, y2);

        if (firstPoint <= secondPoint) {
            System.out.printf("(%d, %d)", x1, y1);
        } else {
            System.out.printf("(%d, %d)", x2, y2);
        }

    }

    public static int getClosestPoint(int x1, int y1) {
        int distance = 0;
        while (x1 != 0) {
            if (x1 < 0) {
                x1++;
            } else {
                x1--;
            }
            distance++;
        }
        while (y1 != 0) {
            if (y1 < 0) {
                y1++;
            } else {
                y1--;
            }
            distance++;
        }
        return distance;
    }
}
