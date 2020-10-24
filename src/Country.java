import java.util.LinkedList;
import java.util.List;

/**
 * Country in the Board of RISK Game
 */
public class Country {

    private String countryName;
    private List<Country> adjacentCountries;
    private int numberOfArmies;
    private Player currentOwner;

    /**
     * Contrusctor to create a new Country with a specific name
     * @param name of the country
     */
    public Country(String name){
        countryName=name;
        adjacentCountries=new LinkedList<>();
        numberOfArmies=0;
    }

    /**
     * set the country adjacent to this country
     */
    public void setAdjacentCountry(Country country){
        adjacentCountries.add(country);
    }

    /**
     * get the name of the country
     * @return name of the country
     */
    public String getCountryName(){
        return countryName;
    }

    /**
     * get the number of Armies occupying a country
     * @return number of armies occupying a country
     */
    public int getNumberOfArmies(){
        return numberOfArmies;
    }

    public List<Country> getAdjacentCountries() {
        return adjacentCountries;
    }

    /**
     * returns the current owner of the country
     * @return player that owns the country
     */
    public Player getCurrentOwner(){
        return currentOwner;
    }


    public boolean hasOwner(){
        return currentOwner!=null;
    }
    /**
     * adds a new owner to the country
     */
    public void addCurrentOwner(Player player){
        currentOwner=player;
    }

    public String toString(){
        return countryName;
    }

    public void addArmy(int numberArmies){
        this.numberOfArmies+=numberArmies;
    }

    public boolean isAdjacent(Country country){
        return adjacentCountries.contains(country);
    }
}
