package exam.june2020.parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
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
        sb.append(String.format("The cars are parked in %s:", type)).append(String.format("%n"));
        data.forEach(e -> sb.append(e).append(String.format("%n")));
        return sb.toString().trim();
    }
}
