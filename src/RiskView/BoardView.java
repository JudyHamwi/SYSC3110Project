package RiskView;

import RiskModel.Board;
import RiskModel.Continent;

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
    private JPanel playerColors;

    public BoardView(Board board){
        this.board=board;
        continentViews=new ArrayList<>();
        playerColors=new JPanel();
        this.setLayout(new GridLayout(3,3,3,3));
        colors=new HashMap<>();
        colorArray=new Color[]{Color.magenta, Color.green, Color.blue, Color.orange, Color.pink, Color.red};
        createColors();
        boardInformation=new JPanel();
        initializeContinents();
        this.add(boardInformation);
        this.add(playerColors);
    }

    public void initializeContinents(){
        for(Continent c:board.getContinents()){
            ContinentView continentview=new ContinentView(this, c, colorArray[colorCounter]);
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

    public void InitializeBoard() {
        for (ContinentView cv : continentViews) {
            cv.InitializePlayerCountries();
        }
        initializePlayerInformationPanel();
    }

    public void initializePlayerInformationPanel(){
        for(int i=0; i<6; i++){
            playerColors.add(new JLabel("Player"+(i+1)+" : "+ colors.get(colorArray[i])));
        }
    }

    public Color[] getColors(){ return colorArray;}

}
