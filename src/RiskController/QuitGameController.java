package RiskController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitGameController implements ActionListener {

    public QuitGameController() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}