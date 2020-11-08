package RiskView;

import RiskController.*;
import RiskModel.*;

import javax.swing.*;
import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RiskViewFrame extends JFrame implements RiskView {

    public static final int BOARD_HEIGHT = 1100;
    public static final int BOARD_WIDTH = 800;
    private static final int MAX_NUM_PLAYERS = 6;

    private JPanel gameStatusPanel;
    private JLabel gameStatus;
    private JLabel currentPlayer;
    private JMenu numberOfPlayers;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem newGame;
    private JMenuItem quitGame;
    private JMenuItem helpMenuItem;
    private Game gameModel;
    private BoardView boardView;
    private Country selectedAttackButton;

    public RiskViewFrame() {
        super("RISK Game");
        gameModel = new Game();
        selectedAttackButton=null;
        this.setLayout(new BorderLayout());
        gameStatusPanel = new JPanel();
        gameStatusPanel.setLayout(new BorderLayout());
        gameStatus = new JLabel("Game Status: ");
        currentPlayer = new JLabel("Current Player: ");
        gameStatusPanel.add(gameStatus, BorderLayout.EAST);
        gameStatusPanel.add(currentPlayer, BorderLayout.WEST);
        menuBar = new JMenuBar();
        menu = new JMenu("Start");
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(new NewGameController(this, gameModel));
        quitGame = new JMenuItem("Quit Game");
        quitGame.addActionListener(new QuitGameController());
        helpMenuItem = new JMenuItem("Help");
        helpMenuItem.addActionListener(new HelpController(gameModel));

        menu.add(newGame);
        menu.add(quitGame);
        menuBar.add(menu);
        setNumberOfPlayersMenu();
        this.add(menuBar, BorderLayout.NORTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setVisible(true);
        this.setLocation(200, 0);
        this.setMinimumSize(new Dimension(BOARD_HEIGHT, BOARD_WIDTH));
    }

    public static void main(String[] args) {
        RiskViewFrame view = new RiskViewFrame();
    }

    public void setNumberOfPlayersMenu() {
        this.numberOfPlayers = new JMenu("Players");
        for (int i = 2; i <= MAX_NUM_PLAYERS; i++) {
            JMenuItem numPlayer = new JMenuItem(i + " Players");
            numPlayer.addActionListener(new InitializationController(gameModel, i));
            numberOfPlayers.add(numPlayer);
        }
        menuBar.add(numberOfPlayers);
    }

    @Override
    public void handleNewGame(Game game, Board board) {
        boardView = new BoardView(this, game, board);
        this.add(boardView, BorderLayout.CENTER);
        this.add(gameStatusPanel, BorderLayout.SOUTH);
        menuBar.add(numberOfPlayers);
        menu.setText("Menu");
        menu.remove(newGame);
        menu.add(helpMenuItem);
    }

    public void handleInitialization(Game game, GameState state, Player player, int numPlayers) {
        gameStatus.setText(state.toString());
        currentPlayer.setText(player.toString());
        boardView.InitializeBoard(numPlayers);
        boardView.addInGamePanel(game, player);
        this.numberOfPlayers.setVisible(false);
    }

    public void handleEndTurn(Game game, Player player) {
        currentPlayer.setText(player.toString());
        JOptionPane.showMessageDialog(this, player.toString() + ", it is your turn!");
    }

    public void handlePrintHelp(Game game, String string) {
        JOptionPane.showMessageDialog(this, string);
    }

    @Override
    public void handleCanNotAttackFrom(Game game) {
        JOptionPane.showMessageDialog(this, "Can not attack from this Country");
    }

    @Override
    public void handleCanAttackFrom(Game game, Country country) {
        if(selectedAttackButton!=null) {
            boardView.removeHighlightCountry(selectedAttackButton);

        }
        selectedAttackButton=country;
        boardView.highlightAttackerCountry(country);
    }

    public void handleNewAttack() {
        boardView.getAttackButton().setEnabled(false);
    }

    public BoardView getBoardView() {
        return boardView;
    }

    public void handleAttackPhase(Game game, Country attackerCountry, Country defenderCountry) {
        JOptionPane.showMessageDialog(this, "Attack Phase Complete");
        boardView.getAttackButton().setEnabled(true);
        boardView.removeHighlightCountry(attackerCountry);
        boardView.TransferOwnership(attackerCountry, defenderCountry);
        selectedAttackButton=null;

    }
}
