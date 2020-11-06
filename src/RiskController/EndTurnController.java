package RiskController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import RiskModel.Game;
import RiskModel.Player;

public class EndTurnController implements ActionListener {
    private Game gameModel;
    private Player player;

    public EndTurnController(Game game, Player player) {
        this.gameModel = game;
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameModel.endTurn(player);
    }
}
