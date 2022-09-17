import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double houseHeight = Double.parseDouble(scanner.nextLine());
        double wallHeight = Double.parseDouble(scanner.nextLine());
        double roofHeight = Double.parseDouble(scanner.nextLine());

        // Walls
        double frontWall = houseHeight * houseHeight - (1.2 * 2);
        double backWall = houseHeight * houseHeight;
        double sideWalls = (2 * (houseHeight * wallHeight)) - (1.5 * 1.5 * 2);
        double totalAreaWalls = frontWall + backWall + sideWalls;
        double greenPaint = totalAreaWalls / 3.4;

        // Roof
        double sideRoof = houseHeight * wallHeight * 2;
        double frontBackRoof = houseHeight * roofHeight;
        double totalAreaRoof = sideRoof + frontBackRoof;
        double redPaint = totalAreaRoof / 4.3;

        System.out.printf("%.2f %n", greenPaint);
        System.out.printf("%.2f %n", redPaint);
    }
}
