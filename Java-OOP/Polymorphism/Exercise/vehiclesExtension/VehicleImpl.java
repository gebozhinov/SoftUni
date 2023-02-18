package polymorphism.exercises.vehiclesExtension;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    private int tankCapacity;

    private DecimalFormat df = new DecimalFormat("#.##");

    public VehicleImpl(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getTankCapacity() { return tankCapacity;}

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }


    @Override
    public String drive(double kilometers) {
        if (fuelConsumption * kilometers < fuelQuantity) {
            fuelQuantity -= fuelConsumption * kilometers;
            return "travelled " + df.format(kilometers) + " km";
        }
        return "needs refueling";
    }

    @Override
    public void refuel(double litres) {
        if (litres <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }
        if (fuelQuantity + litres > tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        fuelQuantity += litres;
    }
}
