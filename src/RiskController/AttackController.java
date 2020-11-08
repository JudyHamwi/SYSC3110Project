package RiskController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import RiskModel.Country;
import RiskModel.Game;
import RiskModel.Player;
import RiskView.BoardView;
import RiskView.RiskView;

import javax.swing.*;

public class AttackController implements ActionListener {
    private Game gameModel;
    private Country country;
    private RiskView riskView;


    public AttackController(RiskView riskView, Game game, Country country) {
        this.gameModel = game;
        this.country=country;
        this.riskView=riskView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b=(JButton) e.getSource();
        if(b.getName().equals("attackButton")){
            riskView.handleNewAttack();
        } else if (riskView.getBoardView().getAttackButton().isEnabled()){
            gameModel.checkAttackingCountry(country);
        } else {
            gameModel.attackPhase(country);
        }
    }
}
