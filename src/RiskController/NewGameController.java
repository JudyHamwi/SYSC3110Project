package RiskController;

import RiskModel.Game;
import RiskView.RiskView;
import RiskView.RiskViewFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameController implements ActionListener {

    private Game game;
    private RiskView rv;

    public NewGameController(RiskView rv, Game game){
        this.rv = rv;
        this.game=game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.addRiskView(rv);
    }
}
