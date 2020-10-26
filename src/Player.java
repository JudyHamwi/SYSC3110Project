import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Player that plays in the Game.
 * @version 1.0
 * @author Sarah Jaber
 * @author Walid Baitul Islam
 * @author Judy Hamwi
 *  @author Diana Miraflor
 */
public class Player {

    private static int playerCounter =1;
    private final int PLAYER_ID;
    private List<Country> countriesOwned;
    private int placeArmy;

    /**
     * Player that plays in the Game
     */
    public Player(){
        this.PLAYER_ID = this.getNextPlayerId();
        this.countriesOwned = new ArrayList<>();
        this.placeArmy=0;

    }

    /**
     * gets the countries owned by the player
     * @return List of countries owned by the player
     */
    public List<Country> getCountriesOwned() {
        return countriesOwned;
    }

    /**
     * Instantiates the ID of the next player to be added to the Game
     * @return ID of the next player to be added in the game
     */
    public static int getNextPlayerId() {
        return playerCounter++;
    }

    /**
     * Returns the id of the player
     * @return the player's ID
     */
    public int getplayerID(){
        return this.PLAYER_ID;
    }

    /**
     * get the number of armies owned by the player
     * @return number of armies owned by the player
     */
    public int getPlayerArmy(){
        return placeArmy;
    }

    /**
     * adds a number of armnies that belongs to the player
     * @param army number of armies that are added to belong to the player
     */
    public void addPlayerArmy(int army){
        placeArmy += army;
    }

    /**
     * gets the number of countries owned by the player
     * @return number of countries owned by the player
     */
    public int getTotalNumberOfCountries(){
        return countriesOwned.size();
    }

    /**
     * adds a country owned by the player
     * @param country owned by the player
     */
    public void addCountry(Country country){
        this.countriesOwned.add(country);
        country.addCurrentOwner(this);
    }

    /**
     * removes a country when it no longer belongs to the player
     * @param country that no longer belongs to the player
     */
    public void removeCountry(Country country){
        countriesOwned.remove(country);
    }

    /**
     * checks the conditions if the player can attack a country by checking if th ecountry attacked from
     * and attacked, and number of armies follow the rules of the game
     * @param attackFrom country that the player wants to attack from
     * @param attackTo country that the player wants to attack
     * @return true of the player can do the attack and false otherwose
     */
    public boolean canAttack(Country attackTo, Country attackFrom){
        if(attackFrom.getCurrentOwner().equals(attackTo.getCurrentOwner())) {
            System.out.println("You can not attack your own country");
            return false;
        } else if(!attackFrom.isAdjacent(attackTo)) {
            System.out.println("The countries are not adjacent");
            return false;
        }
        else if (attackFrom.getNumberOfArmies()==1){
            System.out.println("There are not enough armies to attack");
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Text represenation of the player
     * @return String representation of the player
     */
    public String toString(){
        return "Player" + getplayerID();
    }

    @Override
    /**
     * Checks if two players are equal.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return PLAYER_ID == player.PLAYER_ID ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PLAYER_ID, countriesOwned, placeArmy);
    }

}
