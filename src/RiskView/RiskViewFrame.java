package RiskView;

import RiskController.NewGameController;
import RiskModel.Board;
import RiskModel.Game;

import javax.swing.*;
import java.awt.*;

public class RiskViewFrame extends JFrame implements RiskView {

    public static final int BOARD_HEIGHT=6;
    public static final int BOARD_WIDTH=6;
    private JPanel gameStatusPanel;
    private JLabel gameStatus;
    private JLabel currentPlayer;
    private JOptionPane numberOfPlayers;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem newGame;
    private Game gameModel;

    public RiskViewFrame(){
        super("RISK Game");
        gameModel=new Game();
        this.setLayout(new BorderLayout());
        gameStatusPanel=new JPanel();
        gameStatusPanel.setLayout(new BorderLayout());
        gameStatus=new JLabel("Game Status: ");
        currentPlayer=new JLabel("Current Player: ");
        gameStatusPanel.add(gameStatus, BorderLayout.EAST);
        gameStatusPanel.add(currentPlayer,BorderLayout.WEST);
        numberOfPlayers=new JOptionPane();
        menuBar=new JMenuBar();
        menu=new JMenu("Start");
        newGame=new JMenuItem("New Game");
        newGame.addActionListener(new NewGameController(this, gameModel));
        menu.add(newGame);
        menuBar.add(menu);
        this.add(menuBar, BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300,400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        RiskViewFrame view= new RiskViewFrame();
    }

    @Override
    public void handleNewGame(Game game, Board board) {
        this.add(new BoardView(board), BorderLayout.CENTER);
        this.add(gameStatusPanel, BorderLayout.SOUTH);
    }
}
