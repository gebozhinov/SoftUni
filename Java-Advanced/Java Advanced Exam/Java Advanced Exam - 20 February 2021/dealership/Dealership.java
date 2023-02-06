package exam.february2021.dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        return data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream().filter(e -> e.getManufacturer().equals(manufacturer))
                .filter(e -> e.getModel().equals(model))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(" The cars are in a car exam.february2021.dealership %s:", name)).append(String.format("%n"));
        data.forEach(e -> sb.append(e).append(String.format("%n")));
        return sb.toString().trim();
    }
}
