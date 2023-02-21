package aquarium;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {

    private Aquarium aquarium;

    @Before
    public void setUp() {
        this.aquarium = new Aquarium("Shark", 5);
        addFishToAquarium(aquarium);
    }

    @Test
    public void testGetNameShouldReturnTheNameOfTheAquarium() {
        assertEquals("Shark", aquarium.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfTheNameIsNull() {
        Aquarium aquarium1 = new Aquarium(null, 50);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsEmptyString() {
        Aquarium aquarium1 = new Aquarium("    ", 45);
    }

    @Test
    public void testGetCapacity() {
        assertEquals(5, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowIfTheNumberIsNegative() {
        Aquarium aquarium1 = new Aquarium("Test", -1);
    }

    @Test
    public void testGetCountShouldReturnCountOfFishInTheAquarium() {
        assertEquals(5, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFishShouldThrowIfAquariumIsFull() {
        Fish fish = new Fish("Petko");
        aquarium.add(fish);
    }

    @Test
    public void testRemoveShouldRemoveFishFromAquarium() {
        assertEquals(5, aquarium.getCount());
        aquarium.remove("Vanko");
        assertEquals(4, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowIfTheIsNoSuchFishInTheAquarium() {
        aquarium.remove("Vesko");
    }

    @Test
    public void testSellFishShouldChangeAvailableStatus() {
        Fish fish = aquarium.sellFish("Vanko");
        assertFalse(fish.isAvailable());
        assertEquals("Vanko", fish.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishShouldThrowIfThereIsNoSuchFish() {
        aquarium.sellFish("Penko");
    }

    @Test
    public void testReportShouldReturnStringWithInformationAboutAquariumAndFish() {
        String expected = "Fish available at Shark: Vanko, Pesho, Toni, Gosho, Moni";
        assertEquals(expected, aquarium.report());
    }

    private void addFishToAquarium(Aquarium aquarium) {
        Fish fish1 = new Fish("Vanko");
        Fish fish2 = new Fish("Pesho");
        Fish fish3 = new Fish("Toni");
        Fish fish4 = new Fish("Gosho");
        Fish fish5 = new Fish("Moni");

        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(fish3);
        aquarium.add(fish4);
        aquarium.add(fish5);
    }
}

