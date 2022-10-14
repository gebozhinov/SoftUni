import java.util.Scanner;

public class P06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        int result = rectangleArea(width, length);
        System.out.println(result);

    }

    public static int rectangleArea(int width, int length) {
        return width * length;
    }
}
