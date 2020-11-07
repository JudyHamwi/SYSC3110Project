package RiskController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import RiskModel.Game;
import RiskModel.Player;

public class EndTurnController implements ActionListener {
    private Game gameModel;

    public EndTurnController(Game game) {
        this.gameModel = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameModel.endTurn();
    }
}
