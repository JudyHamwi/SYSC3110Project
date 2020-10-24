import java.util.*;

/**
 * Continent in the Board of RISK Game
 */
public class Continent {
    private String continentName;
    private List<Country> countries;
    private Player currentOwner;

    /**
     * Contrusctor of Continent that creates a new Continent
     *
     * @param name of the Continent
     */
    public Continent(String name) {
        continentName = name;
        countries = new LinkedList<>();
    }

    /**
     * Add country to the continent
     *
     * @param country added to the continent
     */
    public void addCountry(Country country) {
        countries.add(country);
    }

    public List<Country> getContinentCountries() {
        return countries;
    }

    /**
     * get the name of the continent
     *
     * @return name of the continent
     */
    public String getContinentName() {
        return continentName;
    }

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
