package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.Food;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double allPeople;


    protected BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReserved;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReserved = true;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);

    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double healthyFoodPrice = healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double beveragesPrice = beverages.stream().mapToDouble(Beverages::getPrice).sum();
        return healthyFoodPrice + beveragesPrice;
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.isReserved = false;
        this.numberOfPeople = 0;
        this.pricePerPerson = 0;
        this.allPeople = 0;
    }

    @Override
    public String tableInformation() {

        setAllPeople();
        String sb = "Table - " + this.number + System.lineSeparator() +
                "Size - " + this.size + System.lineSeparator() +
                "Type - " + this.getClass().getSimpleName() + System.lineSeparator() +
                "All Price - " + this.allPeople + System.lineSeparator();

        return sb.trim();
    }
    private void setAllPeople() {
        double healthyFoodPrice = healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double beveragesPrice = beverages.stream().mapToDouble(Beverages::getPrice).sum();
        this.allPeople = (healthyFoodPrice + beveragesPrice) * pricePerPerson;
    }
}
