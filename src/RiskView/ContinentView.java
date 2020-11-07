package RiskView;

import RiskModel.Continent;
import RiskModel.Country;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ContinentView extends JPanel {

    private ArrayList<JButton> countryButtons;
    private Continent continent;
    private Color color;
    private JLabel continentLabel;
    private BoardView boardView;

    public ContinentView(BoardView bv, Continent continent, Color color){
        countryButtons=new ArrayList<>();
        this.continent=continent;
        boardView=bv;
        continentLabel=new JLabel(continent.getContinentName());
        this.color=color;
        this.setLayout(new GridLayout(3,3));
        this.add(continentLabel);
        createContinentView();
    }

    private void createContinentView() {
        this.setBackground(color);
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setLayout(new GridLayout(5, 5, 5, 5));
        LinkedList<Country> continentCountries = continent.getContinentCountries();
        for (Country c : continentCountries) {
            JButton b = new JButton(c.getCountryName());
            b.setFont(new Font("Arial", Font.BOLD, 12));
            b.setBounds(100,100,100,100);
            this.add(b);
            countryButtons.add(b);
        }
    }

    public void InitializePlayerCountries(){
        for (JButton b : countryButtons) {
            Country country=continent.getCountryFromContinent(b.getText());
            b.setForeground(boardView.getColors()[country.getCurrentOwner().getplayerID()-1]);
            b.setText(country.getCountryName()+" "+ country.getNumberOfArmies());
        }
    }

}