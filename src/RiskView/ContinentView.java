package RiskView;

import RiskModel.Board;
import RiskModel.Country;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ContinentView extends JPanel {

    private JPanel northAmericaPanel;
    private JPanel southAmericaPanel;
    private JPanel EuropePanel;
    private JPanel AfricaPanel;
    private JPanel AsiaPanel;
    private JPanel AustraliaPanel;
    private Board board;
    private ArrayList<JButton> countryButtons;

    public ContinentView(Board board){
        this.board=board;
        countryButtons=new ArrayList<>();
        this.setLayout(new GridLayout(3,3));
        setNorthAmericaPanel();
        setSouthAmericaPanel();
        setEuropePanel();
        setAfricaPanel();
        setAsiaPanel();
        setAustraliaPanel();
        this.add(northAmericaPanel);
        this.add(southAmericaPanel);
        this.add(EuropePanel);
        this.add(AfricaPanel);
        this.add(AsiaPanel);
        this.add(AustraliaPanel);
    }

    private void setNorthAmericaPanel() {
        northAmericaPanel = new JPanel();
        northAmericaPanel.setBackground(Color.YELLOW);
        northAmericaPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        northAmericaPanel.setLayout(new GridLayout(5, 5, 5, 5));
        LinkedList<Country> northAmericaCountries = board.getContinent("NorthAmerica").getContinentCountries();
        for (Country c : northAmericaCountries) {
            JButton b = new JButton(c.getCountryName());
            b.setFont(new Font("Arial", Font.BOLD, 12));
            b.setBounds(100,100,100,100);
            northAmericaPanel.add(b);
            countryButtons.add(b);
        }
    }

    private void setSouthAmericaPanel() {
        southAmericaPanel = new JPanel();
        southAmericaPanel.setBackground(Color.RED);
        southAmericaPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        southAmericaPanel.setLayout(new GridLayout(5, 5, 5, 5));
        LinkedList<Country> southAmericaCountries = board.getContinent("SouthAmerica").getContinentCountries();
        for (Country c : southAmericaCountries) {
            JButton b = new JButton(c.getCountryName());
            b.setFont(new Font("Arial", Font.BOLD, 12));
            southAmericaPanel.add(b);
            countryButtons.add(b);
        }
    }

    private void setEuropePanel(){
        EuropePanel=new JPanel();
        EuropePanel.setBackground(Color.BLUE);
        EuropePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        EuropePanel.setLayout(new GridLayout(5,5,5,5));
        LinkedList<Country> EuropeCountries = board.getContinent("Europe").getContinentCountries();
        for (Country c : EuropeCountries) {
            JButton b = new JButton(c.getCountryName());
            b.setFont(new Font("Arial", Font.BOLD, 12));
            EuropePanel.add(b);
            countryButtons.add(b);
        }
    }

    private void setAfricaPanel(){
        AfricaPanel=new JPanel();
        AfricaPanel.setBackground(Color.ORANGE);
        AfricaPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        AfricaPanel.setLayout(new GridLayout(5,5,5,5));
        LinkedList<Country> AfricaCountries = board.getContinent("Africa").getContinentCountries();
        for (Country c : AfricaCountries) {
            JButton b = new JButton(c.getCountryName());
            b.setFont(new Font("Arial", Font.BOLD, 12));
            AfricaPanel.add(b);
            countryButtons.add(b);
        }

    }

    private void setAsiaPanel(){
        AsiaPanel=new JPanel();
        AsiaPanel.setBackground(Color.GREEN);
        AsiaPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        AsiaPanel.setLayout(new GridLayout(5,5,5,5));
        LinkedList<Country> AsiaCountries = board.getContinent("Asia").getContinentCountries();
        for (Country c : AsiaCountries) {
            JButton b = new JButton(c.getCountryName());
            b.setFont(new Font("Arial", Font.BOLD, 12));
            AsiaPanel.add(b);
            countryButtons.add(b);
        }
    }


    private void setAustraliaPanel(){
        AustraliaPanel=new JPanel();
        AustraliaPanel.setBackground(Color.PINK);
        AustraliaPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        AustraliaPanel.setLayout(new GridLayout(5,5,5,5));
        LinkedList<Country> AustraliaCountries = board.getContinent("Australia").getContinentCountries();
        for (Country c : AustraliaCountries) {
            JButton b = new JButton(c.getCountryName());
            b.setFont(new Font("Arial", Font.BOLD, 12));
            b.setText(c.getCountryName());
            AustraliaPanel.add(b);
            countryButtons.add(b);
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2= (Graphics2D) g;
        g2.drawLine(countryButtons.get(0).getX()+countryButtons.get(0).getWidth(),
                countryButtons.get(0).getY(), countryButtons.get(1).getX(), countryButtons.get(1).getY());
    }

    public void InitializePlayerCountries(){
            for (JButton b : countryButtons) {
                Country country = board.getCountry(b.getText());
                if (country.getCurrentOwner().getplayerID() == 1) {
                    b.setForeground(Color.BLUE);
                }
                else if(country.getCurrentOwner().getplayerID() == 2){
                    b.setForeground(Color.RED);
                }
                else if(country.getCurrentOwner().getplayerID() == 3){
                    b.setForeground(Color.GREEN);
                } else if(country.getCurrentOwner().getplayerID() == 4){
                    b.setForeground(Color.ORANGE);

                }else if(country.getCurrentOwner().getplayerID() == 5){
                    b.setForeground(Color.YELLOW);
                }else
                    b.setForeground(Color.PINK);
            }
    }

}
