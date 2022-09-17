import java.util.Scanner;

public class WeatherForecastPartTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String weather = "";
        double degrees = Double.parseDouble(scanner.nextLine());
        if ((degrees < 5) | (degrees > 35)) {
            weather = "unknown";
        } else if (degrees < 12) {
            weather = "Cold";
        } else if (degrees < 15) {
            weather = "Cool";
        } else if (degrees <= 20) {
            weather = "Mild";
        } else if (degrees < 26) {
            weather = "Warm";
        } else if (degrees <= 35) {
            weather = "Hot";
        }

        System.out.println(weather);
    }
}
