package View;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JPanel {
    private static final int BOARD_WIDTH = 1080 ;
    private static final int BOARD_HEIGHT = 980;
    private JLabel mapLabel;
    final ImageIcon mapIcon = new ImageIcon("images/mapIcon.png");

    private GridBagConstraints c;

    public BoardView(){
        mapLabel = new JLabel(mapIcon);
        c = new GridBagConstraints();

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(BOARD_WIDTH,BOARD_HEIGHT ));
        this.setVisible(true);
        this.add(mapLabel);
        this.add(new CountryPanel());

    }


}
