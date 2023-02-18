package polymorphism.exercises.vehicles;

public class Truck extends VehicleImpl{

    private static final double INCREASED_FUEL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + INCREASED_FUEL_CONSUMPTION);
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
