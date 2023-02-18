package polymorphism.exercises.vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carTokens = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));

        String[] truckTokens = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        int commandsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandsCount; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");

            String driveOrRefuel = commandParts[0];
            String vehicle = commandParts[1];
            double kilometersOrLiters = Double.parseDouble(commandParts[2]);

            switch (vehicle) {
                case "Car":
                    if ("Drive".equals(driveOrRefuel)) {
                        System.out.println(car.drive(kilometersOrLiters));
                    } else {
                        car.refuel(kilometersOrLiters);
                    }
                    break;
                case "Truck":
                    if ("Drive".equals(driveOrRefuel)) {
                        System.out.println(truck.drive(kilometersOrLiters));
                    } else {
                        truck.refuel(kilometersOrLiters);
                    }
                    break;
            }
        }

        System.out.printf("Car: %.2f%n",car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n",truck.getFuelQuantity());
    }
}
