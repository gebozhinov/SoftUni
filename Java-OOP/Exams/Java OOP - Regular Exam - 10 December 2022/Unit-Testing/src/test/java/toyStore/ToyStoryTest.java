package toyStore;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

import static org.junit.Assert.*;

public class ToyStoryTest {
    private ToyStore toyStore;
    private Toy toy;

    @Before
    public void setUp() {
        toyStore = new ToyStore();
        toy = new Toy("Lego", "10");
    }

    @Test
    public void testGetToyShelfShouldReturnCollectionOfToys() {
        Map<String, Toy> toyMap = toyStore.getToyShelf();
        for (Map.Entry<String, Toy> entry : toyStore.getToyShelf().entrySet()) {
            assertTrue(toyMap.containsKey(entry.getKey()));
            assertTrue(toyMap.containsValue(entry.getValue()));
        }
    }

    @Test
    public void testAddToyShouldAddToyToCollection() throws OperationNotSupportedException {
       String result = toyStore.addToy("A", toy);
        assertTrue(toyStore.getToyShelf().containsValue(toy));
        assertEquals(String.format("Toy:%s placed successfully!", toy.getToyId()), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyShouldThrowIfShelfDoesNotExist() throws OperationNotSupportedException {
        toyStore.addToy("Z", toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyShouldThrowIfShelfIsAlreadyTaken() throws OperationNotSupportedException {
        toyStore.addToy("A", toy);
        toyStore.addToy("A", toy);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowIfToyAlreadyIsInShelf() throws OperationNotSupportedException {
        toyStore.addToy("A", toy);
        toyStore.addToy("B", toy);
    }

    @Test
    public void testRemoveToyShouldRemoveToyFromCollection() throws OperationNotSupportedException {
        toyStore.addToy("A", toy);
       String result = toyStore.removeToy("A", toy);
        assertFalse(toyStore.getToyShelf().containsValue(toy));
        assertEquals(String.format("Remove toy:%s successfully!", toy.getToyId()), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyShouldThrowIfShelfDoesNotExist() {
        toyStore.removeToy("Z", toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyShouldThrowIfToyInShelfDoesNotExist() {
        toyStore.removeToy("B", toy);

    }


}