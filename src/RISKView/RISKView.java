package RISKView;

import javax.swing.*;
import java.awt.*;

public class RISKView extends JFrame {

    public static final int BOARD_HEIGHT=6;
    public static final int BOARD_WIDTH=6;
    private JPanel gameStatusPanel;
    private JLabel gameStatus;
    private JLabel currentPlayer;
    private JOptionPane numberOfPlayers;

    public RISKView(){
        super("RISK Game");
        this.setLayout(new BorderLayout());
        gameStatusPanel=new JPanel();
        gameStatusPanel.setLayout(new BorderLayout());
        gameStatus=new JLabel("Game Status: ");
        currentPlayer=new JLabel("Current Player: ");
        gameStatusPanel.add(gameStatus, BorderLayout.EAST);
        gameStatusPanel.add(currentPlayer,BorderLayout.WEST);
        numberOfPlayers=new JOptionPane();
        this.add(new BoardView(), BorderLayout.CENTER);
        this.add(gameStatusPanel, BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300,400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        RISKView view= new RISKView();
    }
}
