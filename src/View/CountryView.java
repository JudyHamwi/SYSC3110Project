package View;

import javax.swing.*;
import java.awt.*;

public class CountryView {
    // private final int id; Add an Id. Relying on name is not good practice.
    private final String name;
    private JButton button;
    private final Point position;


    public CountryView(String name, Point position) {
        //this.id = id;
        this.name = name;
        this.position = position;

        // do something about button
    }

    public void setButton(JButton button) {
        this.button = button;
    }
}
