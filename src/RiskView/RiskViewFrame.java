package RiskView;

import RiskController.InitializationController;
import RiskController.NewGameController;
import RiskModel.Board;
import RiskModel.Game;
import RiskModel.GameState;
import RiskModel.Player;

import javax.swing.*;
import java.awt.*;

public class RiskViewFrame extends JFrame implements RiskView {

    public static final int BOARD_HEIGHT=6;
    public static final int BOARD_WIDTH=6;
    private JPanel gameStatusPanel;
    private JLabel gameStatus;
    private JLabel currentPlayer;
    private JMenu numberOfPlayers;
    private JMenuItem twoPlayers;
    private JMenuItem threePlayers;
    private JMenuItem fourPlayers;
    private JMenuItem fivePlayers;
    private JMenuItem sixPlayers;
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
        menuBar=new JMenuBar();
        menu=new JMenu("Start");
        newGame=new JMenuItem("New Game");
        newGame.addActionListener(new NewGameController(this, gameModel));
        numberOfPlayers=new JMenu("Players");
        twoPlayers=new JMenuItem("2 Players");
        twoPlayers.addActionListener(new InitializationController(gameModel, 2));
        threePlayers=new JMenuItem("3 Players");
        threePlayers.addActionListener(new InitializationController(gameModel, 3));
        fourPlayers=new JMenuItem("4 Players");
        fourPlayers.addActionListener(new InitializationController(gameModel, 4));
        fivePlayers=new JMenuItem("5 Players");
        fivePlayers.addActionListener(new InitializationController(gameModel, 4));
        sixPlayers=new JMenuItem("6 Players");
        sixPlayers.addActionListener(new InitializationController(gameModel, 4));
        numberOfPlayers.add(twoPlayers);
        numberOfPlayers.add(threePlayers);
        numberOfPlayers.add(fourPlayers);
        numberOfPlayers.add(fivePlayers);
        numberOfPlayers.add(sixPlayers);
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
        menuBar.add(numberOfPlayers);
    }
    public void handleInitialization(Game game, GameState state, Player player){
        gameStatus.setText(state.toString());
        currentPlayer.setText(player.toString());
    }
}
