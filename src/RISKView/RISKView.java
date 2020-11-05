package RISKView;

import javax.swing.*;

public class RISKView extends JFrame {

    public static final int BOARD_HEIGHT=6;
    public static final int BOARD_WIDTH=6;

    public RISKView(){
        super("RISK Game");
        this.add(new ContinentView());
        this.setSize(300,400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        RISKView view= new RISKView();
    }
}
