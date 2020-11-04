package View;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JPanel {
    private static final int BOARD_WIDTH = 1300 ;
    private static final int BOARD_HEIGHT = 900;
    private JPanel mapPanel;
    private JLabel mapLabel;
    private ImageIcon mapImageIcon;
    private GridBagConstraints c;

    public BoardView(){
        c = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(BOARD_WIDTH,BOARD_HEIGHT ));
        this.setVisible(true);
        this.add(mapPanel());
        //this.add(new CountryPanel());

    }

    private JPanel mapPanel(){
        mapPanel = new JPanel();
        mapPanel.setLayout(new GridLayout(1,1,5,5));
        mapImageIcon = new ImageIcon("images/riskMap.png");
        this.mapLabel = new JLabel(mapImageIcon);
        mapLabel.setPreferredSize(new Dimension(BOARD_WIDTH,BOARD_HEIGHT));
        mapPanel.add(mapLabel);
        return mapPanel;
    }


}
