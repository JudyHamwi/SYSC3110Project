package RiskView;

import RiskModel.Board;
import RiskModel.Game;
import RiskModel.GameState;
import RiskModel.Player;

public interface RiskView {
    public void handleNewGame(Game game, Board board);
    public void handleInitialization(Game game, GameState state, Player player);
    public void handleEndTurn(Game game, Player currentPlayer);
    void handlePrintHelp(Game game, String pH);
}
