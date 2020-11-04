package View;

import Model.Board;

import javax.swing.*;
import java.awt.*;

public class RiskView extends JFrame {

    public RiskView(){
        super("Risk");
        this.setSize(1600,1108);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new BoardView());

        pack();
        this.setVisible(true);
        this.toFront();
    }

    public static void main(String[] args) {
        RiskView game = new RiskView();
    }
}
