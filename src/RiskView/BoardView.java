package RiskView;

import RiskController.AttackController;
import RiskController.EndTurnController;
import RiskModel.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardView extends JPanel {

    public static final int CONTINENT_WIDTH=6;
    private static int colorCounter =0;
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
    private RiskView rv;

    public BoardView(RiskView rv,Game game, Board board){
        this.board=board;
        this.rv=rv;
        this.game=game;
        continentViews=new ArrayList<>();
        playerColorsPanel=new JPanel();
        playerColorsPanel.setLayout(new BoxLayout(playerColorsPanel, BoxLayout.Y_AXIS));
        this.setLayout(new GridLayout(3,3,3,3));
        colors=new HashMap<>();
        colorArray=new Color[]{Color.magenta, Color.green, Color.blue, Color.orange, Color.pink, Color.red};
        createColors();
        boardInformation=new JPanel();
        initializeContinents();
        this.add(boardInformation);
        this.add(playerColorsPanel);
    }

    public void initializeContinents(){
        for(Continent c:board.getContinents()){
            ContinentView continentview=new ContinentView(rv, game,this, c, colorArray[colorCounter]);
            this.add(continentview);
            continentViews.add(continentview);
            colorCounter++;
        }
    }

    private void createColors(){
        colors.put(Color.magenta, "Purple");
        colors.put(Color.red, "Red");
        colors.put(Color.blue,"Blue");
        colors.put(Color.orange, "Orange");
        colors.put( Color.green, "Green");
        colors.put(Color.pink, "Pink");
        colors.put( Color.white, "White");
    }

    public void InitializeBoard(int numPlayers) {
        for (ContinentView cv : continentViews) {
            cv.InitializePlayerCountries();
        }
        initializePlayerInformationPanel(numPlayers);
    }

    public void initializePlayerInformationPanel(int numPlayers){
        for(int i=0; i<numPlayers; i++){
            playerColorsPanel.add(new JLabel("Player"+(i+1)+" : "+ colors.get(colorArray[i])));
        }
    }

    public Color[] getColors(){ return colorArray;}

    public JPanel inGamePanel(Game game, Player player) {
        inGamePanel = new JPanel();

        inGamePanel.setLayout(new GridLayout(3,3));

        attackButton = new JButton("Attack!");
        attackButton.setName("attackButton");
        endTurnButton = new JButton("End turn");
        rollDiceButton = new JButton("Roll Dice");

        inGamePanel.add(attackButton);
        inGamePanel.add(endTurnButton);
        inGamePanel.add(rollDiceButton);

        endTurnButton.addActionListener(new EndTurnController(game));
        attackButton.addActionListener(new AttackController(rv, game, null));

        return inGamePanel;
    }

    public void addInGamePanel(Game game, Player player) {
        this.add(inGamePanel(game, player));
    }

    public void highlightAttackerCountry(Country country){
        for(ContinentView cv:continentViews){
            if(cv.hasCountryButton(country) != null){
                cv.highlightButton(cv.hasCountryButton(country));
                highlightAdjacentCountries(country);
            }
        }
    }

    public void highlightAdjacentCountries(Country country) {
        for (Country adjacentCountry : country.getAdjacentCountries()) {
            for (ContinentView cv : continentViews) {
                if (cv.hasCountryButton(adjacentCountry) != null){
                    cv.highlightButton(cv.hasCountryButton(adjacentCountry));
                }
            }
        }
    }

    public void removeHighlightCountry(Country country){
        for(ContinentView cv:continentViews){
            if(cv.hasCountryButton(country) != null){
                cv.removeHighlightButton(cv.hasCountryButton(country));
                removeHighLightAdjacentCountry(country);
            }
        }
    }

    public void removeHighLightAdjacentCountry(Country country){
        for(Country adjacentCountry: country.getAdjacentCountries()){
            for (ContinentView cv : continentViews){
                if (cv.hasCountryButton(adjacentCountry) != null){
                    cv.removeHighlightButton(cv.hasCountryButton(adjacentCountry));
                }
            }
        }
    }


    public void TransferOwnership(Country attackerCountry, Country defenderCountry){
        JButton attacker=new JButton();
        JButton defender=new JButton();
        for (ContinentView cv:continentViews){
            if(cv.hasCountryButton(attackerCountry) != null){
                attacker=cv.hasCountryButton(attackerCountry);
                attacker.setForeground(getColors()[attackerCountry.getCurrentOwner().getplayerID()-1]);
                attacker.setText(attackerCountry.getCountryName()+" "+ attackerCountry.getNumberOfArmies());
            }if(cv.hasCountryButton(defenderCountry) != null){
                defender=cv.hasCountryButton(defenderCountry);
                defender.setForeground(getColors()[defenderCountry.getCurrentOwner().getplayerID()-1]);
                defender.setText(defenderCountry.getCountryName()+" "+ defenderCountry.getNumberOfArmies());
            }
        }


    }

    public void updateArmy(){

    }
    public JButton getAttackButton(){
        return attackButton;
    }


}
