package RiskView;

import RiskController.InitializationController;
import RiskController.NewGameController;
import RiskController.QuitGameController;
import RiskModel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JMenuItem quitGame;
    private Game gameModel;
    private BoardView boardView;

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
        quitGame = new JMenuItem("Quit Game");
        quitGame.addActionListener(new QuitGameController());
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
        menu.add(quitGame);
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
        boardView=new BoardView(board);
        this.add(boardView, BorderLayout.CENTER);
        this.add(gameStatusPanel, BorderLayout.SOUTH);
        menuBar.add(numberOfPlayers);
        menu.setText("Menu");
        menu.remove(newGame);
    }
    public void handleInitialization(Game game, GameState state, Player player){
        gameStatus.setText(state.toString());
        currentPlayer.setText(player.toString());
        boardView.InitializeBoard();
    }

    protected void addRiskActionListeners(ActionListener ev) {
        // add buttons for number of players.
    }
}
