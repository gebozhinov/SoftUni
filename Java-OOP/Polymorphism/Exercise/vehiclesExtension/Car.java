package polymorphism.exercises.vehiclesExtension;

public class Car extends VehicleImpl {

    private static final double INCREASED_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption + INCREASED_FUEL_CONSUMPTION, tankCapacity);
    }

    @Override
    public String drive(double kilometers) {
        return "Car " + super.drive(kilometers);
    }

    @Override
    public void refuel(double litres) {
        super.refuel(litres);
    }

}

