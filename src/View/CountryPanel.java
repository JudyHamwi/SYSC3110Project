package View;

import Model.Board;
import Model.Continent;
import Model.Country;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class CountryPanel extends JPanel{
    private Continent continent;
    private Board board;
    private GridBagConstraints c;

    public CountryPanel(){
        this.setLayout(new GridLayout());
        this.setPreferredSize(new Dimension(1300, 900));

        board = new Board();
        this.add(northAmericaPanel());
        this.add(southAmericaPanel());
        this.add(europePanel());
        this.add(africaPanel());
        this.add(asiaPanel());
        this.add(australiaPanel());
        setCountryPanelConstraints();
    }

    private JPanel northAmericaPanel(){
        JPanel northAmericaPanel = new JPanel();
        northAmericaPanel.setPreferredSize(new Dimension(1300, 480));
        northAmericaPanel.setLayout(new GridLayout(5,5,5,5));

        LinkedList<Country> northAmericaCountries = board.getContinent("NorthAmerica").getContinentCountries();

        for(Country c : northAmericaCountries){
            JLabel countryLabel = new JLabel(c.getCountryName());
            countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
            northAmericaPanel.add(countryLabel);
        }
        return northAmericaPanel;

    }

    private JPanel southAmericaPanel(){
        JPanel southAmericaPanel = new JPanel();
        southAmericaPanel.setPreferredSize(new Dimension(1300, 840));
        southAmericaPanel.setLayout(new GridLayout(3,3,5,5));

        LinkedList<Country> southAmericaCountries = board.getContinent("SouthAmerica").getContinentCountries();

        for(Country c : southAmericaCountries){
            JLabel countryLabel = new JLabel(c.getCountryName());
            countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
            southAmericaPanel.add(countryLabel);
        }
        return southAmericaPanel;

    }

    private JPanel europePanel(){
        JPanel EuropePanel = new JPanel();
        EuropePanel.setPreferredSize(new Dimension(1300, 430));
        EuropePanel.setLayout(new GridLayout(3,3,5,5));

        LinkedList<Country> EuropeCountries = board.getContinent("Europe").getContinentCountries();

        for(Country c : EuropeCountries){
            JLabel countryLabel = new JLabel(c.getCountryName());
            countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
            EuropePanel.add(countryLabel);
        }
        return EuropePanel;

    }

    private JPanel africaPanel(){
        JPanel AfricaPanel = new JPanel();
        AfricaPanel.setPreferredSize(new Dimension(1300, 840));
        AfricaPanel.setLayout(new GridLayout(4,4,5,5));

        LinkedList<Country> AfricaCountries = board.getContinent("Africa").getContinentCountries();

        for(Country c : AfricaCountries){
            JLabel countryLabel = new JLabel(c.getCountryName());
            countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
            AfricaPanel.add(countryLabel);
        }
        return AfricaPanel;

    }

    private JPanel asiaPanel(){
        JPanel AsiaPanel = new JPanel();
        AsiaPanel.setPreferredSize(new Dimension(1300, 570));
        AsiaPanel.setLayout(new GridLayout(5,6,5,5));

        LinkedList<Country> AsiaCountries = board.getContinent("Asia").getContinentCountries();

        for(Country c : AsiaCountries){
            JLabel countryLabel = new JLabel(c.getCountryName());
            countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
            AsiaPanel.add(countryLabel);
        }
        return AsiaPanel;

    }

    private JPanel australiaPanel(){
        JPanel AustraliaPanel = new JPanel();
        AustraliaPanel.setPreferredSize(new Dimension(1300, 820));
        AustraliaPanel.setLayout(new GridLayout(2,2,5,5));

        LinkedList<Country> AustraliaCountries = board.getContinent("Australia").getContinentCountries();

        for(Country c : AustraliaCountries){
            JLabel countryLabel = new JLabel(c.getCountryName());
            countryLabel.setFont(new Font("Arial", Font.PLAIN, 10));
            AustraliaPanel.add(countryLabel);
        }
        return AustraliaPanel;

    }

    private void setCountryPanelConstraints() {
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        this.add(new JLabel("North America"), c);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        this.add(northAmericaPanel(), c);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        this.add(new JLabel("South America"), c);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        this.add(southAmericaPanel(), c);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        this.add(new JLabel("Europe"), c);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 5;
        this.add(europePanel(), c);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 6;
        this.add(new JLabel("Africa"), c);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 7;
        this.add(africaPanel(), c);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 8;
        this.add(new JLabel("Asia"), c);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 9;
        this.add(asiaPanel(), c);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 10;
        this.add(new JLabel("Australia"), c);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 11;
        this.add(australiaPanel(), c);
    }
}
