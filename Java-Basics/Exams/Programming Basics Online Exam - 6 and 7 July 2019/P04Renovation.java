import java.util.Scanner;

public class Renovation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wallHeight = Integer.parseInt(scanner.nextLine());
        int wallWidth = Integer.parseInt(scanner.nextLine());
        int unPaintWallsPercent = Integer.parseInt(scanner.nextLine());

        int wallsArea = wallHeight * wallWidth * 4;
        double paintArea = Math.ceil(wallsArea - (wallsArea * (unPaintWallsPercent / 100.0)));

        int totalLtrPaint = 0;
        while (paintArea >= totalLtrPaint) {
            try {
                int paintLtr = Integer.parseInt(scanner.nextLine());
                totalLtrPaint += paintLtr;

            } catch (Exception ex) {
                break;
            }
        }
        if (totalLtrPaint > paintArea) {
            System.out.printf("All walls are painted and you have %.0f l" +
                    " paint left!", totalLtrPaint - paintArea);
        } else if (totalLtrPaint == paintArea){
            System.out.println("All walls are painted! Great job, Pesho!");
        } else {
            System.out.printf("%.0f quadratic m left.", paintArea - totalLtrPaint);
        }
    }
}
