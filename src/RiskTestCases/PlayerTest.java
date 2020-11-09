package RiskTestCases;

import RiskModel.Country;
import RiskModel.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player;
    List<Country> countriesOwned;

    @Before
    public void setUp() throws Exception {
       player = new Player();
       countriesOwned = new ArrayList<>();
    }

    @Test
    public void testPlayer(){
        assertTrue(player.equals(player));
    }

    @Test
    public void testGetCountriesOwned() {
        Country country = new Country("Alaska");
        player.addCountry(country);
        countriesOwned.add(country);
        assertEquals(countriesOwned,player.getCountriesOwned());
    }

    @Test
    public void getNextPlayerId() {
        int playerID = 1;
        assertEquals(2,player.getNextPlayerId());
    }

    @Test
    public void getplayerID() {
        assertEquals(1, player.getPlayerID());
    }

    @Test
    public void addPlayerArmy() {
    }

    @Test
    public void getTotalNumberOfCountries() {
    }

    @Test
    public void addCountry() {
    }

    @Test
    public void removeCountry() {
    }

    @Test
    public void canAttack() {
    }

    @Test
    public void canAttackFrom() {
    }
}