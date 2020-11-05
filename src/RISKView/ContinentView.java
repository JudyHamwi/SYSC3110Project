package RISKView;

import RISKModel.Board;
import RISKModel.Country;

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

    public ContinentView(){
        board=new Board();
        this.setLayout(new GridLayout(6,6));
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
        northAmericaPanel.setLayout(new GridLayout(5, 5, 5, 5));
        LinkedList<Country> northAmericaCountries = board.getContinent("NorthAmerica").getContinentCountries();
        for (Country c : northAmericaCountries) {
            JButton b = new JButton(c.getCountryName());
            northAmericaPanel.add(b);
        }
    }



    private void setSouthAmericaPanel() {
        southAmericaPanel = new JPanel();
        southAmericaPanel.setLayout(new GridLayout(5, 5, 5, 5));
        LinkedList<Country> southAmericaCountries = board.getContinent("NorthAmerica").getContinentCountries();
        for (Country c : southAmericaCountries) {
            JButton b = new JButton(c.getCountryName());
            southAmericaPanel.add(b);
        }
    }


    private void setEuropePanel(){
        EuropePanel=new JPanel();
        EuropePanel.setLayout(new GridLayout(5,5,5,5));
        LinkedList<Country> EuropeCountries = board.getContinent("NorthAmerica").getContinentCountries();
        for (Country c : EuropeCountries) {
            JButton b = new JButton(c.getCountryName());
            EuropePanel.add(b);
        }
    }


    private void setAfricaPanel(){
        AfricaPanel=new JPanel();
        AfricaPanel.setLayout(new GridLayout(5,5,5,5));
        LinkedList<Country> AfricaCountries = board.getContinent("NorthAmerica").getContinentCountries();
        for (Country c : AfricaCountries) {
            JButton b = new JButton(c.getCountryName());
            AfricaPanel.add(b);
        }

    }


    private void setAsiaPanel(){
        AsiaPanel=new JPanel();
        AsiaPanel.setLayout(new GridLayout(5,5,5,5));
        LinkedList<Country> AsiaCountries = board.getContinent("NorthAmerica").getContinentCountries();
        for (Country c : AsiaCountries) {
            JButton b = new JButton(c.getCountryName());
            AsiaPanel.add(b);
        }
    }


    private void setAustraliaPanel(){
        AustraliaPanel=new JPanel();
        AustraliaPanel.setLayout(new GridLayout(5,5,5,5));
        LinkedList<Country> AustraliaCountries = board.getContinent("NorthAmerica").getContinentCountries();
        for (Country c : AustraliaCountries) {
            JButton b = new JButton(c.getCountryName());
            AustraliaPanel.add(b);
        }
    }


}
