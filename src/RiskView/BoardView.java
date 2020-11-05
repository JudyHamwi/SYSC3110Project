package RiskView;

import RiskModel.Board;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JPanel {

    public static final int CONTINENT_WIDTH=6;
    private JPanel continentsInformation;
    private ContinentView continentView;
    private JPanel playersInformation;
    private JPanel boardInformation;

    public BoardView(Board board){
        this.setLayout(new BorderLayout());
        continentsInformation=new JPanel();
        playersInformation=new JPanel();
        boardInformation=new JPanel();
        playersInformation.setLayout(new BoxLayout(playersInformation, BoxLayout.Y_AXIS));
        continentsInformation.setLayout(new BoxLayout(continentsInformation, BoxLayout.Y_AXIS));
        continentsInformation.add(new JLabel("North America : Yellow"));
        continentsInformation.add(new JLabel("South America : Red"));
        continentsInformation.add(new JLabel("Europe : Blue"));
        continentsInformation.add(new JLabel("Africa: Orange"));
        continentsInformation.add(new JLabel("Asia: Green"));
        continentsInformation.add(new JLabel("Australia : Pink"));
        continentView=new ContinentView(board);
        boardInformation.add(continentsInformation);
        boardInformation.add(playersInformation);
        this.add(boardInformation, BorderLayout.CENTER);
        this.add(continentView, BorderLayout.NORTH);
    }

    public void InitializeBoard(){
        continentView.InitializePlayerCountries();
        initializePlayerInformationPanel();
    }

    public void initializePlayerInformationPanel() {
        JLabel player1 = new JLabel("Player 1: BLUE");
        JLabel player2 = new JLabel("Player 2: RED");
        JLabel player3 = new JLabel("Player 3: GREEN");
        JLabel player4 = new JLabel("Player 4: ORANGE");
        JLabel player5 = new JLabel("Player 5: YELLOW");
        JLabel player6 = new JLabel("Player 6: PINK");
        playersInformation.add(player1);
        playersInformation.add(player2);
        playersInformation.add(player3);
        playersInformation.add(player4);
        playersInformation.add(player5);
        playersInformation.add(player6);

    }
}
