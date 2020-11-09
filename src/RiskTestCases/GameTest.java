package RiskTestCases;

import RiskModel.*;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class GameTest {
    Game game;
    Board board;
    GameState gameState;
    LinkedList<Player> players;
    int numPlayers = 2;
    Player currentPlayer;
    Country attackingCountry;
    Country defendingCountry;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        board = game.getBoard();
        players = new LinkedList<>();
        currentPlayer = new Player();
        game.initialize(numPlayers);
        attackingCountry = new Country("Alaska");
        defendingCountry = new Country("Alberta");
    }

    @Test
    public void testGame(){
        assertTrue(game.equals(game));

    }

    @Test
    public void testGetState(){
        assertEquals("Game is initializing",GameState.INITIALIZING, game.getState());
    }

    @Test
    public void testAddPlayers(){
        game.addPlayers(numPlayers);
        assertEquals(players.size(), game.getNumPlayers());
    }

    @Test
    public void attackPhase() {
        AttackPhase playerAttack = new AttackPhase(currentPlayer, attackingCountry,defendingCountry);
        currentPlayer.addPlayerArmy(3);
        players.add(currentPlayer);
        game.attackPhase(defendingCountry);
    }

    @Test
    public void theInitialState() {

    }

    @Test
    public void setNumberOfPlayers() {
    }

    @Test
    public void play() {
    }

    @Test
    public void endTurn() {
    }

    @Test
    public void getNumPlayers() {
    }

    @org.junit.Test
    public void attack() {
    }

    @org.junit.Test
    public void addRiskView() {
    }

    @org.junit.Test
    public void removeRiskView() {
    }

    @org.junit.Test
    public void checkAttackingCountry() {
    }
}