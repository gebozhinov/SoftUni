package definingClasses.exercises.speedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P03SpeedRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Car> carMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split(" ");
            String model = carInfo[0];
            int fuelAmount = Integer.parseInt(carInfo[1]);
            double fuelCost = Double.parseDouble(carInfo[2]);
            Car car = new Car(model, fuelAmount, fuelCost);
            carMap.putIfAbsent(model, car);

        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String model = input.split(" ")[1];
            double kilometers = Double.parseDouble(input.split(" ")[2]);
            if (carMap.get(model).isFuelEnough(kilometers)) {
                carMap.get(model).moveCar(kilometers);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }

        carMap.forEach((key, value) -> System.out.println(value));
    }
}
