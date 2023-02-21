package garage;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {

    private Garage garage;

    @Before
    public void setUp() {
        this.garage = new Garage();
        addCarsToGarage(garage);
    }

    @Test
    public void testGetCarsShouldReturnCollectionOfCars() {
        List<Car> cars = garage.getCars();
        for (int i = 0; i < garage.getCount(); i++) {
            assertEquals(cars.get(i), garage.getCars().get(i));
        }
    }

    @Test
    public void testGetCountShouldReturnTheCountOfCars() {
        assertEquals(5, garage.getCount());
    }


    @Test
    public void testFindAllCarsWithMaxSpeedAboveShouldReturnCollectionOfCars() {
        List<Car> cars = garage.findAllCarsWithMaxSpeedAbove(250);
        assertEquals("BMW", cars.get(0).getBrand());
        assertEquals(280, cars.get(0).getMaxSpeed());
        assertEquals(80000, cars.get(0).getPrice(), 0);

        assertEquals("Nissan", cars.get(1).getBrand());
        assertEquals(320, cars.get(1).getMaxSpeed());
        assertEquals(145000, cars.get(1).getPrice(), 0);

        assertEquals(2, cars.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarShouldThrowIfTheCarIsNull() {
        garage.addCar(null);
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        Car car = garage.getTheMostExpensiveCar();

        assertEquals("Nissan", car.getBrand());
        assertEquals(320, car.getMaxSpeed());
        assertEquals(145000, car.getPrice(), 0);
    }

    @Test
    public void testFindAllCarsByBrand() {
        List<Car> cars = garage.findAllCarsByBrand("VW");

        assertEquals("VW", cars.get(0).getBrand());
        assertEquals(220, cars.get(0).getMaxSpeed());
        assertEquals(8500, cars.get(0).getPrice(), 0);

        assertEquals(1, cars.size());
    }

    private void addCarsToGarage(Garage garage) {
        Car car1 = new Car("VW", 220, 8500);
        Car car2 = new Car("Mini", 240, 9900);
        Car car3 = new Car("BMW", 280, 80000);
        Car car4 = new Car("Nissan", 320, 145000);
        Car car5 = new Car("Mercedes", 220, 13000);

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.addCar(car4);
        garage.addCar(car5);
    }
}