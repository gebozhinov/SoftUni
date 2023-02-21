package cats;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.text.Format;

public class HouseTests {

    private House house;

    @Before
    public void setUp() {
        this.house = new House("MyHouse", 5);
        addCatsToHouse(house);
    }

    @Test
    public void testGetName() {
        assertEquals("MyHouse", house.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfTheNameIsNull() {
        House house1 = new House(null, 15);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfTheNameIsEmptyString() {
        House house1 = new House("     ", 15);
    }

    @Test
    public void testGetCapacity() {
        assertEquals(5, house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowIfTheCapacityIsBellowZero() {
        House house1 = new House("Test", -1);
    }

    @Test
    public void testGetCountShouldReturnTheNumberOfCatsInTheHouse() {
        assertEquals(5, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatShouldThrowIfTheHouseIsFull() {
        Cat cat = new Cat("Peycho");
        house.addCat(cat);
    }

    @Test
    public void testRemoveCatShouldRemoveCatByName() {
        assertEquals(5, house.getCount());
        house.removeCat("Pesho");
        assertEquals(4, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatShouldThrowIfThereIsNoCatWithThatName() {
        house.removeCat("No Such Cat");
    }

    @Test
    public void testCatForSaleShouldReturnCatByNameAndSetHungryToFalse() {
        Cat cat = house.catForSale("Pesho");
        assertFalse(cat.isHungry());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleShouldThrowIfCatWithThatNameDoesNotExist() {
        Cat cat = house.catForSale("Peycho");

    }

    @Test
    public void testStatistic() {
        String actualResult = house.statistics();
        String expectedResult = "The cat Pesho, Vankata, Pisi, Meow, Topcho is in the house MyHouse!";
        assertEquals(expectedResult, actualResult);
    }
    private void addCatsToHouse(House house) {
        Cat cat1 = new Cat("Pesho");
        Cat cat2 = new Cat("Vankata");
        Cat cat3 = new Cat("Pisi");
        Cat cat4 = new Cat("Meow");
        Cat cat5 = new Cat("Topcho");

        house.addCat(cat1);
        house.addCat(cat2);
        house.addCat(cat3);
        house.addCat(cat4);
        house.addCat(cat5);
    }
}
