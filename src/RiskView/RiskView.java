package RiskView;

import RiskModel.*;

/**
 * Risk View listener of the model. Updates the view when the model applies a change.
 * @version 1.0
 * @author Sarah Jaber
 * @author Walid Baitul Islam
 * @author Judy Hamwi
 * @author Diana Miraflor
 */
public interface RiskView {
    public void handleNewGame(Game game, Board board);
    public void handleInitialization(Game game, GameState state, Player player, int numPlayers);
    public void handleEndTurn(Game game, Player currentPlayer);
    public void handlePrintHelp(Game game, String pH);
    public void handleCanAttackFrom(Game game, Country country);
    public void handleCanNotAttackFrom(Game game);
    public void handleNewAttack();
    public BoardView getBoardView();
    public void handleAttackPhase(Game game, Country attackerCountry, Country defenderCountry, boolean attackSuccess);
}
