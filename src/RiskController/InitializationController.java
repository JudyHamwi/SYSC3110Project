package RiskController;

import RiskModel.Game;
import RiskView.RiskView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitializationController implements ActionListener {
    private Game gameModel;
    private int players;

    public InitializationController(Game game, int players){
        this.gameModel=game;
        this.players=players;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gameModel.setNumberOfPlayers(players);
        gameModel.theInitialState();


    }
}
