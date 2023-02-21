package farmville;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    private Farm farm;

    @Before
    public void setUp() {
        this.farm = new Farm("Cat Farm", 6);
        addAnimalsToFarm(farm);
    }

    @Test
    public void testGetCountShouldReturnNumberOfAnimals() {
        assertEquals(5, farm.getCount());
    }

    @Test
    public void testGetNameShouldReturnNameOfFarm() {
        assertEquals("Cat Farm", farm.getName());
    }

    @Test
    public void testGetCapacity() {
        assertEquals(6, farm.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfCapacityIsNotEnough() {
        Animal animal1 = new Animal("Sheep", 5);
        farm.add(animal1);
        Animal animal2 = new Animal("Horse", 170);
        farm.add(animal2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfAnimalAlreadyExistInTheFarm() {
        Animal animal1 = new Animal("Cat", 60);
        farm.add(animal1);
    }

    @Test
    public void testRemoveShouldRemoveAnimalFromFarmAndReturnBoolean() {
        assertTrue(farm.remove("Cat"));
        assertFalse(farm.remove("Sheep"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowIfCapacityIsNegative() {
        Farm farm1 = new Farm("Test", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsNull() {
        Farm farm1 = new Farm(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsEmptyString() {
        Farm farm1 = new Farm("    ", 5);
    }

    private void addAnimalsToFarm(Farm farm) {
        Animal animal1 = new Animal("Cat", 60);
        Animal animal2 = new Animal("Dog", 120);
        Animal animal3 = new Animal("Cow", 40);
        Animal animal4 = new Animal("Tiger", 220);
        Animal animal5 = new Animal("Lion", 210);

        farm.add(animal1);
        farm.add(animal2);
        farm.add(animal3);
        farm.add(animal4);
        farm.add(animal5);
    }
}
