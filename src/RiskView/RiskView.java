package RiskView;

import RiskModel.*;

import javax.swing.*;

public interface RiskView {
    public void handleNewGame(Game game, Board board);
    public void handleInitialization(Game game, GameState state, Player player, int numPlayers);
    public void handleEndTurn(Game game, Player currentPlayer);
    void handlePrintHelp(Game game, String pH);
    public void handleCanAttackFrom(Game game, Country country);
    public void handleCanNotAttackFrom(Game game);
    public void handleNewAttack();
    public BoardView getBoardView();
    public void handleAttackPhase(Game game, Country attackerCountry, Country defenderCountry);
}
