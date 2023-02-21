package football;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FootballTeamTests {

    private FootballTeam footballTeam;

    @Before
    public void setUp() {
        footballTeam = new FootballTeam("Liverpool", 5);
        addFootballersToTeam();
    }


    @Test
    public void testGetNameShouldReturnTheNameOfTheTeam() {
        assertEquals("Liverpool", footballTeam.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfTheNameOfTheTeamIsNull() {
        FootballTeam footballTeamTest = new FootballTeam(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfTheNameOfTheTeamIsEmpty() {
        FootballTeam footballTeamTest = new FootballTeam("   ", 5);
    }

    @Test
    public void testGetVacantPositions() {
        assertEquals(5, footballTeam.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetVacantPositionsShouldThrowIfPositionIsNegativeNumber() {
        FootballTeam footballTeamTest = new FootballTeam("TestTeam", -5);
    }

    @Test
    public void testGetCountShouldReturnNumberOfFootballersInTheTeam() {
        assertEquals(5, footballTeam.getCount());
        footballTeam.removeFootballer("Ivan");
        assertEquals(4, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerShouldThrowIfTheTeamIsFull() {
        Footballer footballer = new Footballer("Pesho");
        footballTeam.addFootballer(footballer);
    }

    @Test
    public void testRemoveFootballerShouldRemoveFootballerWithGivenName() {
        assertEquals(5, footballTeam.getCount());
        footballTeam.removeFootballer("Ivan");
        assertEquals(4, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerShouldThrowIfThereIsNotFootballerWithThatName() {
        footballTeam.removeFootballer("Grozdan");
    }

    @Test
    public void testFootballerForSaleShouldReturnFootballerWhitGivenName() {
        Footballer footballer = new Footballer("Pete");
        FootballTeam footballTeam1 = new FootballTeam("PSG", 2);
        footballTeam1.addFootballer(footballer);
        assertEquals("Pete", footballTeam1.footballerForSale("Pete").getName());
        assertFalse(footballer.isActive());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleShouldThrowIfThereIsNotFootballerWithThatName() {
        footballTeam.footballerForSale("Misho");
    }

    @Test
    public void testGetStatisticShouldReturnStringWithFootballerNameAndTeamName() {
        String actualResult = footballTeam.getStatistics();
        String expectedResult = "The footballer Ivan, Peter, George, Martin, Simeon is in the team Liverpool.";

        assertEquals(expectedResult, actualResult);
    }

    private void addFootballersToTeam() {
        Footballer footballer1 = new Footballer("Ivan");
        Footballer footballer2 = new Footballer("Peter");
        Footballer footballer3 = new Footballer("George");
        Footballer footballer4 = new Footballer("Martin");
        Footballer footballer5 = new Footballer("Simeon");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.addFootballer(footballer4);
        footballTeam.addFootballer(footballer5);
    }

}
