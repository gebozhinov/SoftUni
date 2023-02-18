package polymorphism.exercises.vehiclesExtension;

public class Truck extends VehicleImpl {

    private static final double INCREASED_FUEL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption + INCREASED_FUEL_CONSUMPTION, tankCapacity);
    }


    @Override
    public String drive(double kilometers) {
        return "Truck " + super.drive(kilometers);
    }

    @Override
    public void refuel(double litres) {
        super.refuel(litres * 0.95);
    }

}
