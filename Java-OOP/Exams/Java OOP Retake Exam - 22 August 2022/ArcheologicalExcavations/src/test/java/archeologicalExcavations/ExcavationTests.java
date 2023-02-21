package archeologicalExcavations;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTests {

    private Excavation excavation;
    private Archaeologist archaeologist;

    @Before
    public void setUp() {
        excavation = new Excavation("Sofia", 10);
        archaeologist = new Archaeologist("Pesho", 15);
    }

    @Test
    public void testGetCount() {
        assertEquals(0, excavation.getCount());
    }

    @Test
    public void testGetName() {
        assertEquals("Sofia", excavation.getName());
    }

    @Test
    public void testGetCapacity() {
        assertEquals(10, excavation.getCapacity());
    }

    @Test
    public void testAddArchaeologistShouldAddArchaeologistToCollection() {
        excavation.addArchaeologist(archaeologist);
        assertEquals(1, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowIfThereIsNotEnoughCapacity() {
        Excavation excavationTest = new Excavation("Test", 0);
        excavationTest.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowIfThereIsAlreadyArchaeologistWithThatName() {
        excavation.addArchaeologist(archaeologist);
        Archaeologist archaeologistTest = new Archaeologist("Pesho", 2);
        excavation.addArchaeologist(archaeologistTest);
    }

    @Test
    public void testRemoveArchaeologistShouldRemoveArchaeologistAndReturnTrue() {
        excavation.addArchaeologist(archaeologist);
        assertTrue(excavation.removeArchaeologist(archaeologist.getName()));
        assertEquals(0, excavation.getCount());
    }

    @Test
    public void testRemoveArchaeologistShouldNotRemoveArchaeologistAndReturnFalse() {
        Archaeologist archaeologistTest = new Archaeologist("Ivan", 3);
        assertFalse(excavation.removeArchaeologist(archaeologistTest.getName()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowIfCapacityIsNegativeNumber() {
        Excavation excavation1 = new Excavation("Test", -5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsNull() {
        Excavation excavation1 = new Excavation(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsEmpty() {
        Excavation excavation1 = new Excavation("", 5);
    }

}
