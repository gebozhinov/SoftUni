package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;

import java.util.*;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {


    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;

    }

    @Override
    public String createDriver(String driver) {
        if (driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }
        Driver driver1 = new DriverImpl(driver);
        driverRepository.add(driver1);
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        Car car = null;
        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }
        carRepository.add(car);

        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        } else if (carRepository.getByName(carModel) == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }
        Car car = carRepository.getByName(carModel);
        driverRepository.getByName(driverName).addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if (raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        } else if (driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        Driver driver = driverRepository.getByName(driverName);
        raceRepository.getByName(raceName).addDriver(driver);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        if (raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        long participants = raceRepository.getAll().stream().mapToInt(driver -> driver.getDrivers().size()).sum();
        if (participants < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        Map<String, Double> drivers = new LinkedHashMap<>();

        for (Race race : raceRepository.getAll()) {
            for (Driver driver : race.getDrivers()) {
                double racePoints = driver.getCar().calculateRacePoints(race.getLaps());
                String driveName = driver.getName();
                drivers.put(driveName, racePoints);
            }
        }
        Map<String, Double> sortedDrivers = new LinkedHashMap<>();

        drivers.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .forEachOrdered(x -> sortedDrivers.put(x.getKey(), x.getValue()));

        StringBuilder sb = new StringBuilder();

        List<String> result = new ArrayList<>();
        sortedDrivers.forEach((key, value) -> result.add(key));

        sb.append(String.format(DRIVER_FIRST_POSITION, result.get(0), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format(DRIVER_SECOND_POSITION, result.get(1), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format(DRIVER_THIRD_POSITION, result.get(2), raceName));
        return sb.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        Race race = new RaceImpl(name, laps);
        raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }
}
