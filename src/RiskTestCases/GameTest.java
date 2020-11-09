package RiskTestCases;

import RiskModel.Board;
import RiskModel.Game;
import RiskModel.GameState;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    Game game;
    Board board;
    GameState gameState;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        board = game.getBoard();
    }

    @Test
    public void testGame(){
        assertTrue(game.equals(game));

    }

    @Test
    public void testGetState() {
        assertEquals("Game is initializing",GameState.INITIALIZING, game.getState());
    }

    @Test
    public void attackPhase() {

    }

    @Test
    public void initializePlayers() {
        game.initializePlayers();

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