package polymorphism.exercises.vehicles;

import java.text.DecimalFormat;

public class VehicleImpl implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    private DecimalFormat df = new DecimalFormat("#.##");

    public VehicleImpl(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
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
        fuelQuantity += litres;
    }
}
