package definingClasses.exercises.rawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04RawData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split(" ");
            String model = carInfo[0];
            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];
            List<Tire> tireList = new ArrayList<>();
            for (int j = 5; j < carInfo.length; j += 2) {
                double tyrePressure = Double.parseDouble(carInfo[j]);
                int tyreYear = Integer.parseInt(carInfo[j + 1]);
                Tire tire = new Tire(tyrePressure, tyreYear);
                tireList.add(tire);

            }
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Car car = new Car(model, engine, cargo, tireList);
            carList.add(car);

        }

        String input = scanner.nextLine();
        if (input.equals("fragile")) {
            carList.stream().filter(e -> e.getCargo().getType().equals("fragile"))
                    .filter(Car::isTyrePressureEnough)
                    .forEach(e -> System.out.println(e.getModel()));

        } else {
            carList.stream().filter(e -> e.getCargo().getType().equals("flamable"))
                    .filter(Car::isEnginePowerEnough)
                    .forEach(e -> System.out.println(e.getModel()));
        }

    }
}
