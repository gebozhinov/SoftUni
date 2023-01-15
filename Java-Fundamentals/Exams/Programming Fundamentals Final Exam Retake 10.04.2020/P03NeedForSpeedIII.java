package exam.finale.april2020;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Map<Integer, Integer>> carsMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String car = input.split("\\|")[0];
            int mileage = Integer.parseInt(input.split("\\|")[1]);
            int fuel = Integer.parseInt(input.split("\\|")[2]);
            carsMap.putIfAbsent(car, new LinkedHashMap<>());
            carsMap.get(car).putIfAbsent(mileage, fuel);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String command = input.split(" : ")[0];
            String car = input.split(" : ")[1];
            int currentMileage = getKey(carsMap, car);
            int currentFuel = getValue(carsMap, car);
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(input.split(" : ")[2]);
                    int driveFuel = Integer.parseInt(input.split(" : ")[3]);
                    if (currentFuel >= driveFuel) {
                        carsMap.get(car).clear();
                        carsMap.get(car).put(currentMileage + distance, currentFuel - driveFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n"
                                , car, distance, driveFuel);
                        if (currentMileage + distance >= 100000) {
                            carsMap.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }

                    break;
                case "Refuel":
                    int refuel = Integer.parseInt(input.split(" : ")[2]);
                    int neededFuel = refuel + currentFuel;
                    if (neededFuel > 75) {
                        neededFuel = 75;
                    }
                    carsMap.get(car).clear();
                    carsMap.get(car).put(currentMileage, neededFuel);
                    System.out.printf("%s refueled with %d liters%n", car, neededFuel - currentFuel);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(input.split(" : ")[2]);
                    int decreaseMileage = currentMileage - kilometers;
                    if (decreaseMileage < 10000) {
                        decreaseMileage = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    carsMap.get(car).clear();
                    carsMap.get(car).put(decreaseMileage, currentFuel);

                    break;
            }


            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<Integer, Integer>> car : carsMap.entrySet()) {
            for (Map.Entry<Integer, Integer> entry : car.getValue().entrySet()) {
                System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n"
                        , car.getKey(), entry.getKey(), entry.getValue());
            }

        }


    }

    public static int getValue(Map<String, Map<Integer, Integer>> carsMap, String car) {
        int currentValue = 0;
        for (Map.Entry<Integer, Integer> entry : carsMap.get(car).entrySet()) {
            currentValue = entry.getValue();
        }
        return currentValue;
    }

    public static int getKey(Map<String, Map<Integer, Integer>> carsMap, String car) {
        int currentKey = 0;
        for (Map.Entry<Integer, Integer> entry : carsMap.get(car).entrySet()) {
            currentKey = entry.getKey();
        }
        return currentKey;
    }

}
