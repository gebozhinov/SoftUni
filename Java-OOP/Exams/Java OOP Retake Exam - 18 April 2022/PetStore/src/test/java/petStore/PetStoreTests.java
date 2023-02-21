package petStore;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PetStoreTests {

    private PetStore petStore;
    private PetStore petStoreWithMaxKg;
    private PetStore petStoreWithSpice;

    @Before
    public void setUp() {
        petStore = new PetStore();
        addAnimals(petStore);

        petStoreWithMaxKg = new PetStore();
        petStoreWithSpice = new PetStore();
    }

    @Test
    public void testGetAnimalsShouldReturnListOfAnimals() {
        List<Animal> animals = petStore.getAnimals();

        for (int i = 0; i < petStore.getAnimals().size(); i++) {
            assertEquals(animals.get(i), petStore.getAnimals().get(i));
        }
    }

    @Test
    public void testGetCount() {
        assertEquals(5, petStore.getCount());
    }

    @Test
    public void testFindAllAnimalsWithMaxKilogramsShouldReturnListOfAnimalsWithMoreKgThanGiven() {
        int kg = 20;
        Animal animal1 = new Animal("dog", 25, 500);
        Animal animal2 = new Animal("cat", 5, 25);
        Animal animal3 = new Animal("cow", 250, 1500);
        petStoreWithMaxKg.addAnimal(animal1);
        petStoreWithMaxKg.addAnimal(animal2);
        petStoreWithMaxKg.addAnimal(animal3);

        List<Animal> animals = petStoreWithMaxKg.findAllAnimalsWithMaxKilograms(kg);
        assertEquals(animals.get(0), animal1);
        assertEquals(animals.get(1), animal3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalShouldThrowIfAnimalIsNull() {
        petStore.addAnimal(null);
    }

    @Test
    public void testGetTheMostExpensiveAnimalShouldReturnTheAnimalWithHighestPrice() {
        Animal animal = petStore.getTheMostExpensiveAnimal();
        assertEquals("cow", animal.getSpecie());
        assertEquals(250, animal.getMaxKilograms());
        assertEquals(1500, animal.getPrice(), 0);
    }

    @Test
    public void testFindAllAnimalBySpecieShouldReturnListOfAnimalsByGivenSpice() {
        String spice = "dog";
        Animal animal1 = new Animal("dog", 5, 100);
        Animal animal2 = new Animal("dog", 12, 160);
        Animal animal3 = new Animal("cat", 2, 80);
        Animal animal4 = new Animal("cat", 3, 55);

        petStoreWithSpice.addAnimal(animal1);
        petStoreWithSpice.addAnimal(animal2);
        petStoreWithSpice.addAnimal(animal3);
        petStoreWithSpice.addAnimal(animal4);

        List<Animal> animals = petStoreWithSpice.findAllAnimalBySpecie(spice);

        assertEquals(animal1, animals.get(0));
        assertEquals(animal2, animals.get(1));

    }

    private void addAnimals(PetStore petStore) {
        Animal animal1 = new Animal("dog", 10, 450);
        Animal animal2 = new Animal("cat", 2, 50);
        Animal animal3 = new Animal("cow", 250, 1500);
        Animal animal4 = new Animal("pig", 65, 800);
        Animal animal5 = new Animal("chicken", 1, 35);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);
        petStore.addAnimal(animal5);
    }

}

