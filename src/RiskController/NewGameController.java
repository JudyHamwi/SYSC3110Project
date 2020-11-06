package RiskController;

import RiskModel.Game;
import RiskView.RiskViewFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameController implements ActionListener {

    private Game game;
    private RiskViewFrame rv;
    JMenuItem newGame;
    JMenuItem quitGame;

    public NewGameController(RiskViewFrame rv, Game game){
        this.rv = rv;
        this.game=game;
        // add action listeners to view.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            game.addRiskView(rv);
    }
}
