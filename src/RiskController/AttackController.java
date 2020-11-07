package RiskController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import RiskModel.Game;
import RiskModel.Player;
import RiskView.BoardView;

public class AttackController implements ActionListener {
    private Game gameModel;
    private Player player;

    public AttackController(Game game, Player player) {
        this.gameModel = game;
        this.player = player;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionEvent = e.getActionCommand();
        /*
        if (actionEvent.equals("attackButton")) {
            game.attack(player);
        } else if (actionEvent.equals("rollDiceButton")) {
            game.rollDice(player);
        } else {
        }
         */
    }
}