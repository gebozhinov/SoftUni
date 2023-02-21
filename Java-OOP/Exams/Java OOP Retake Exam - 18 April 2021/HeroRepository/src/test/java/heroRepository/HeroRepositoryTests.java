package heroRepository;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class HeroRepositoryTests {

    private HeroRepository heroRepository;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
        addHeroesToRepository(heroRepository);
    }

    @Test
    public void testGetCountShouldReturnCountOfHeroes() {
        assertEquals(5, heroRepository.getCount());
    }

    @Test
    public void testCreateHeroShouldReturnStringIfHeroIsAddedSuccessful() {
        Hero hero = new Hero("Ivo", 68);
        assertEquals("Successfully added hero Ivo with level 68", heroRepository.create(hero));
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHeroShouldThrowIfHeroIsNull() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroShouldThrowIfHeroIsAlreadyInRepo() {
        Hero hero = new Hero("Ivan", 18);
        heroRepository.create(hero);
    }

    @Test
    public void testRemoveShouldRemoveHeroFromRepo() {
        assertEquals(5, heroRepository.getCount());
        assertTrue(heroRepository.remove("Ivan"));
        assertEquals(4, heroRepository.getCount());
        assertFalse(heroRepository.remove("Georgi"));
    }
    @Test(expected = NullPointerException.class)
    public void testRemoveShouldThrowIfGiveNameIsNull() {
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveShouldThrowIfGivenNameIsEmptyString() {
        heroRepository.remove("    ");
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        Hero hero = heroRepository.getHeroWithHighestLevel();
        assertEquals("Gosho", hero.getName());
        assertEquals(70, hero.getLevel());
    }

    @Test
    public void testGetHeroShouldReturnHeroByGivenName() {
        Hero hero = heroRepository.getHero("Plamen");
        assertEquals("Plamen", hero.getName());
        assertEquals(7, hero.getLevel());
        assertNull(heroRepository.getHero("Hero"));
    }

    @Test
    public void testGetHeroesShouldReturnCollectionOfHeroes() {
        Collection<Hero> heroes = heroRepository.getHeroes();
        for (Hero hero : heroes) {
            Hero hero1 = heroRepository.getHero(hero.getName());
            assertNotNull(hero1);

        }
    }
     private void addHeroesToRepository(HeroRepository heroRepository) {
        Hero hero1 = new Hero("Ivan", 12);
        Hero hero2 = new Hero("Petar", 45);
        Hero hero3 = new Hero("Gosho", 70);
        Hero hero4 = new Hero("Plamen", 7);
        Hero hero5 = new Hero("Simeon", 19);

        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);
        heroRepository.create(hero4);
        heroRepository.create(hero5);
    }
}

