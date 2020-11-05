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
    private ArrayList<JButton> northAmericabuttons;

    public ContinentView(){
        board=new Board();
        northAmericabuttons=new ArrayList<>();
        setNorthAmericaPanel();
    }

    private void setNorthAmericaPanel(){
        northAmericaPanel=new JPanel();
        northAmericaPanel.setLayout(new GridLayout(5,5,5,5));

        LinkedList<Country> northAmericaCountries = board.getContinent("NorthAmerica").getContinentCountries();
        for(Country c : northAmericaCountries){
            JButton b=new JButton(c.getCountryName());
            northAmericabuttons.add(b);
        }

    }


    private void setSouthAmericaPanel(){
        southAmericaPanel=new JPanel();
        southAmericaPanel.setLayout(new GridLayout(5,5,5,5));
    }


    private void setEuropePanel(){
        EuropePanel=new JPanel();
        EuropePanel.setLayout(new GridLayout(5,5,5,5));
    }


    private void setAfricaPanel(){
        AfricaPanel=new JPanel();
        AfricaPanel.setLayout(new GridLayout(5,5,5,5));
    }


    private void setAsiaPanel(){
        AsiaPanel=new JPanel();
        AsiaPanel.setLayout(new GridLayout(5,5,5,5));
    }


    private void setAustraliaPanel(){
        AustraliaPanel=new JPanel();
        AustraliaPanel.setLayout(new GridLayout(5,5,5,5));
    }


}
