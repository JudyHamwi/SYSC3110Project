package RISKView;

import RISKModel.Board;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JPanel {

    public static final int CONTINENT_WIDTH=6;
    private JPanel continentsInformation;

    public BoardView(){
        this.setLayout(new BorderLayout());
        continentsInformation=new JPanel();
        continentsInformation.setLayout(new BoxLayout(continentsInformation, BoxLayout.Y_AXIS));
        continentsInformation.add(new JLabel("North America : Yellow"));
        continentsInformation.add(new JLabel("South America : Red"));
        continentsInformation.add(new JLabel("Europe : Blue"));
        continentsInformation.add(new JLabel("Africa: Orange"));
        continentsInformation.add(new JLabel("Asia: Green"));
        continentsInformation.add(new JLabel("Australia : Pink"));
        this.add(continentsInformation, BorderLayout.SOUTH);
        this.add(new ContinentView(), BorderLayout.CENTER);
    }

}
