package Model;

import java.util.*;

/**
 * Model.Continent in the Model.Board of RISK Model.Game.
 * @version 1.0
 * @author Sarah Jaber
 * @author Walid Baitul Islam
 * @author Judy Hamwi
 * @author Diana Miraflor
 */
public class Continent {
    private String continentName;
    private LinkedList<Country> countries;
    private Player currentOwner;

    /**
     * Contrusctor of Model.Continent that creates a new Model.Continent
     *
     * @param name of the Model.Continent
     */
    public Continent(String name) {
        continentName = name;
        countries = new LinkedList<>();
    }

    /**
     * Add country to the continent
     * @param country added to the continent
     */
    public void addCountry(Country country) {
        countries.add(country);
    }

    public LinkedList<Country> getContinentCountries() {
        return countries;
    }

    /**
     * get the name of the continent
     * @return name of the continent
     */
    public String getContinentName() {
        return continentName;
    }

    /**
     * Text representation of the continent.
     * @return text representation of the continent
     */
    public String toString() {
        String continent = continentName + ": \n";
        for (Country c : countries) {
            continent += "    " + c.getCountryName();
            if (c.hasOwner()) {
                continent += " Owned by: " + c.getCurrentOwner();
            }
            continent += "\n Adjacent Countries: ";
            for (int i = 0; i < c.getAdjacentCountries().size(); i++) {
                continent += " " + c.getAdjacentCountries().get(i);
            }
            continent += "\n";
        }
        return continent;
    }
}
