package RiskView;

import RiskController.AttackController;
import RiskModel.Continent;
import RiskModel.Country;
import RiskModel.Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ContinentView extends JPanel {

    private ArrayList<JButton> countryButtons;
    private Continent continent;
    private Color color;
    private JLabel continentLabel;
    private BoardView boardView;
    private Game game;
    private RiskView rv;
    private JButton attackerButton;

    public ContinentView(RiskView rv, Game game, BoardView bv, Continent continent, Color color){
        this.rv=rv;
        countryButtons=new ArrayList<>();
        this.continent=continent;
        this.game=game;
        boardView=bv;
        attackerButton=new JButton();
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
            b.setText(c.getCountryName());
            b.setName(c.getCountryName());
            b.setFont(new Font("Arial", Font.BOLD, 12));
            b.setBounds(100,100,100,100);
            this.add(b);
            countryButtons.add(b);
            b.addActionListener(new AttackController(rv,game, c));
        }
    }

    public void InitializePlayerCountries(){
            for (JButton b : countryButtons) {
                Country country=continent.getCountryFromContinent(b.getText());
                b.setForeground(boardView.getColors()[country.getCurrentOwner().getplayerID()-1]);
                b.setText(country.getCountryName()+" "+ country.getNumberOfArmies());
            }
    }

    public void highlightAttackerButton(){
        System.out.println("10");
        attackerButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
    }

    public boolean hasCountryButton(Country country){
        for(JButton b:countryButtons){
            if(b.getName().equals(country.getCountryName())){
                attackerButton=b;
                return true;
            }
        }
        return false;
    }

    public void removeHighlightAttackerButton(){
        attackerButton.setBorder(new JButton().getBorder());
    }

}
