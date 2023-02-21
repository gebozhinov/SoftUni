package magicGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MagicianTests {


    private Magician magician;
    private Magic magic;

    private Magic magicToBeRemoved;

    @Before
    public void setUp() {
        magician = new Magician("Test", 50);
        magic = new Magic("test", 5);

        Magic magic1 = new Magic("test1", 50);
        Magic magic2 = new Magic("test2", 50);
        Magic magic3 = new Magic("test3", 50);
        Magic magic4 = new Magic("test4", 50);

        magician.addMagic(magic);
        magician.addMagic(magic1);
        magician.addMagic(magic2);
        magician.addMagic(magic3);
        magician.addMagic(magic4);
    }

    @Test
    public void testGetUsername() {
        assertEquals("Test", magician.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameShoutThrowIfNameIsNull() {
        Magician magician1 = new Magician(null, 50);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameShoutThrowIfNameIsEmpty() {
        Magician magician1 = new Magician("", 50);
    }

    @Test
    public void testGetHealth() {
        assertEquals(50, magician.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthShouldThrowIfHealthIsBelowZero() {
        Magician magician1 = new Magician("Test", -50);
    }

    @Test
    public void testGetMagicsShouldReturnCollectionOfMagics() {
        List<Magic> magicList = magician.getMagics();
        for (int i = 0; i < magician.getMagics().size(); i++) {
            assertEquals(magicList.get(i), magician.getMagics().get(i));
        }
    }

    @Test
    public void testTakeDamageShouldExtractDamageFromHealth() {
        magician.takeDamage(20);
        assertEquals(30, magician.getHealth());
    }

    @Test
    public void testTakeDamageShouldSetMagicianHealthToZero() {
        magician.takeDamage(55);
        assertEquals(0, magician.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldThrowIfMagicianHealthIsBelowZero() {
        magician.takeDamage(50);
        magician.takeDamage(1);
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicShouldThrowIfMagicIsNull() {
        magician.addMagic(null);
    }

    @Test
    public void testRemoveMagicShouldReturnTrueIfMagicIsRemoved() {
        assertTrue(magician.removeMagic(magic));
    }

    @Test
    public void testRemoveMagicShouldReturnFalseIfMagicIsNotRemoved() {
        assertFalse(magician.removeMagic(magicToBeRemoved));
    }

    @Test
    public void testGetMagicShouldReturnMagicWithThatName() {
        Magic magic1 = magician.getMagic("test");
        assertEquals("test", magic1.getName());
        assertEquals(5, magic1.getBullets());
    }

    @Test
    public void testGetMagicShouldReturnNullIfThereIsNoMagicWithThatName() {
        Magic magic1 = magician.getMagic("no");
        assertNull(magic1);
    }
}
