import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<VehicleCatalogue> carCatalogue = new ArrayList<>();
        List<VehicleCatalogue> truckCatalogue = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String typeOfVehicle = input.split(" ")[0];
            String modelOfVehicle = input.split(" ")[1];
            String colorOfVehicle = input.split(" ")[2];
            int horsePowerOfVehicle = Integer.parseInt(input.split(" ")[3]);
            VehicleCatalogue vehicle = new VehicleCatalogue(typeOfVehicle, modelOfVehicle, colorOfVehicle, horsePowerOfVehicle);
            if (typeOfVehicle.equals("truck")) {
                truckCatalogue.add(vehicle);
            } else {
                carCatalogue.add(vehicle);
            }

            input = scanner.nextLine();
        }

        String modelInfo = scanner.nextLine();
        while (!modelInfo.equals("Close the Catalogue")) {
            for (VehicleCatalogue vehicle : carCatalogue) {
                if (vehicle.getModel().equals(modelInfo)) {
                    System.out.printf("Type: %s%n", vehicle.getType().substring(0, 1).toUpperCase() + vehicle.getType().substring(1));
                    System.out.printf("Model: %s%n", vehicle.getModel());
                    System.out.printf("Color: %s%n", vehicle.getColor());
                    System.out.printf("Horsepower: %d%n", vehicle.getHorsepower());
                    break;
                }
            }
            for (VehicleCatalogue vehicle : truckCatalogue) {
                if (vehicle.getModel().equals(modelInfo)) {
                    System.out.printf("Type: %s%n", vehicle.getType().substring(0, 1).toUpperCase() + vehicle.getType().substring(1));
                    System.out.printf("Model: %s%n", vehicle.getModel());
                    System.out.printf("Color: %s%n", vehicle.getColor());
                    System.out.printf("Horsepower: %d%n", vehicle.getHorsepower());
                    break;
                }

            }
            modelInfo = scanner.nextLine();
        }
        double carsAverageHorsepower = getAverageHorsepower(carCatalogue);
        double trucksAverageHorsepower = getAverageHorsepower(truckCatalogue);
        System.out.printf("Cars have average horsepower of: %.2f.%n", carsAverageHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", trucksAverageHorsepower);

    }
    
    public static double getAverageHorsepower(List<VehicleCatalogue> vehicleCatalogues) {
        double sum = 0;
        for (VehicleCatalogue vehicle : vehicleCatalogues) {
            sum += vehicle.getHorsepower();
        }
        if (sum > 0) {
            return sum / vehicleCatalogues.size();
        }
        return 0;
    }
}
