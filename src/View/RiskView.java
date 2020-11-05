package View;

import javax.swing.*;

public class RiskView extends JFrame {

    private final BoardView boardView;

    public RiskView(final BoardView boardView){
        super("Risk");
        this.setSize(1600,1108);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.boardView = boardView;
        this.add(boardView);

        pack();
        this.setVisible(true);
        this.toFront();
    }
}
