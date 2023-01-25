package definingClasses.exercises.carSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engineList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] engineInfo = scanner.nextLine().split(" ");
            String model = engineInfo[0];
            int power = Integer.parseInt(engineInfo[1]);
            Engine engine = new Engine(model, power);
            switch (engineInfo.length) {
                case 3:
                    if (engineInfo[2].matches("\\d+")) {
                        String displacement = engineInfo[2];
                        engine.setDisplacement(displacement);

                    } else {
                        String efficiency = engineInfo[2];
                        engine.setEfficiency(efficiency);
                    }
                    break;
                case 4:
                    String displacement = engineInfo[2];
                    String efficiency = engineInfo[3];
                    engine.setDisplacement(displacement);
                    engine.setEfficiency(efficiency);
                    break;
            }
            engineList.add(engine);
        }

        List<Car> cars = new ArrayList<>();
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] carInfo = scanner.nextLine().split(" ");
            String model = carInfo[0];
            String engine = carInfo[1];
            Car car = new Car(model, engineList.get(getIndexOfTheEngine(engineList, engine)));

            switch (carInfo.length) {
                case 3:
                    if (carInfo[2].matches("\\d+")) {
                        String weight = carInfo[2];
                        car.setWeight(weight);
                    } else {
                        String color = carInfo[2];
                        car.setColor(color);
                    }
                    break;
                case 4:
                    String weight = carInfo[2];
                    String color = carInfo[3];
                    car.setWeight(weight);
                    car.setColor(color);
                    break;
            }
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine());
            System.out.println("Weight: " + car.getWeight());
            System.out.println("Color: " + car.getColor());
        }
    }

    public static int getIndexOfTheEngine(List<Engine> engineList, String engine) {
        for (int i = 0; i < engineList.size(); i++) {
            if (engineList.get(i).getModel().equals(engine)) {
                return i;
            }
        }
        return -1;
    }
}
