package RISKView;

import RISKModel.Board;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JPanel {

    public static final int CONTINENT_WIDTH=6;

    public BoardView(){
        this.setLayout(new GridLayout(RISKView.BOARD_WIDTH, RISKView.BOARD_HEIGHT));

    }
}
