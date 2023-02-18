package polymorphism.exercises.vehiclesExtension;

public class Bus extends VehicleImpl {

    private boolean driveEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        driveEmpty = false;

    }



    public boolean isDriveEmpty() {
        return driveEmpty;
    }



    public void setDriveEmpty(boolean driveEmpty) {
        this.driveEmpty = driveEmpty;
    }

    @Override
    public String drive(double kilometers) {
        if (!driveEmpty) {
            setFuelConsumption(getFuelConsumption() + 1.4);
            return "Bus " + super.drive(kilometers);
        }
        setFuelConsumption(getFuelConsumption());
        return "Bus " + super.drive(kilometers);
    }

    @Override
    public void refuel(double litres) {
        super.refuel(litres);
    }
}
