package RiskView;

import RiskController.AttackController;
import RiskController.EndTurnController;
import RiskModel.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardView extends JPanel {

    public static final int CONTINENT_WIDTH = 6;
    private static int colorCounter = 0;
    private Color[] colorArray;
    private HashMap<Color, String> colors;
    private JPanel boardInformation;
    private Board board;
    private ArrayList<ContinentView> continentViews;
    private JPanel playerColorsPanel;
    private JButton endTurnButton;
    private JButton attackButton;
    private JButton rollDiceButton;
    private JPanel inGamePanel;
    private Game game;

    private ArrayList<JButton> countryButtons;

    public BoardView(Board board) {
        this.board = board;
        this.continentViews = new ArrayList<>();
        this.countryButtons = new ArrayList<>();
        this.playerColorsPanel = new JPanel();
        playerColorsPanel.setLayout(new BoxLayout(playerColorsPanel, BoxLayout.Y_AXIS));
        this.setLayout(new GridLayout(3, 3, 3, 3));
        this.colors = new HashMap<>();
        this.colorArray = new Color[]{Color.magenta, Color.green, Color.blue, Color.orange, Color.pink, Color.red};
        this.createColors();
        this.boardInformation = new JPanel();
        initializeContinents();

        this.add(boardInformation);
        this.add(playerColorsPanel);

    }

    public void initializeContinents() {
        for (Continent c : board.getContinents()) {
            ContinentView continentview = new ContinentView(this, c, colorArray[colorCounter]);
            this.add(continentview);
            continentViews.add(continentview);
            colorCounter++;
        }
    }

    private void createColors() {
        colors.put(Color.magenta, "Purple");
        colors.put(Color.red, "Red");
        colors.put(Color.blue, "Blue");
        colors.put(Color.orange, "Orange");
        colors.put(Color.green, "Green");
        colors.put(Color.pink, "Pink");
        colors.put(Color.white, "White");
    }

    public void InitializeBoard(int numPlayers) {
        for (ContinentView cv : continentViews) {
            cv.InitializePlayerCountries();
        }
        initializePlayerInformationPanel(numPlayers);
    }

    public void initializePlayerInformationPanel(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            playerColorsPanel.add(new JLabel("Player" + (i + 1) + " : " + colors.get(colorArray[i])));
        }
    }

    public Color[] getColors() {
        return colorArray;
    }

    public JPanel inGamePanel(Game game, Player player) {
        inGamePanel = new JPanel();
        //inGamePanel.setPreferredSize();

        inGamePanel.setLayout(new GridLayout(3, 3));

        attackButton = new JButton("Attack!");
        endTurnButton = new JButton("End turn");
        rollDiceButton = new JButton("Roll Dice");

        inGamePanel.add(attackButton);
        inGamePanel.add(endTurnButton);
        inGamePanel.add(rollDiceButton);

        attackButton.addActionListener(new AttackController(game, player));
        endTurnButton.addActionListener(new EndTurnController(game));

        return inGamePanel;
    }

    public void addInGamePanel(Game game, Player player) {
        this.add(inGamePanel(game, player));
    }


}