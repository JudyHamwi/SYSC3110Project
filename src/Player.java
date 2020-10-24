import java.util.ArrayList;
import java.util.List;

public class Player {
    private static int playerCounter =1;
    private final int PLAYER_ID;
    private List<Country> countriesOwned;
    private List<Continent> continents;
    private int placeArmy;

    public Player(){
        this.PLAYER_ID = this.getNextPlayerId();
        this.countriesOwned = new ArrayList<>();
        this.placeArmy=0;
    }

    public List<Country> getCountriesOwned() {
        return countriesOwned;
    }

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

    public int getPlayerArmy(){
        return placeArmy;
    }

    public void addPlayerArmy(int army){
        placeArmy += army;
    }

    public int getTotalNumberOfCountries(){
        return countriesOwned.size();
    }

    public void addCountry(Country country){
        this.countriesOwned.add(country);
        country.addCurrentOwner(this);
    }

    public void removeCountry(Country country){
        countriesOwned.remove(country);
    }

    public boolean canAttack(Country attackFrom, Country attackTo){
        if ( attackFrom.getAdjacentCountries().contains(attackTo)
                && attackFrom.getNumberOfArmies() > 1 && attackTo.getNumberOfArmies() > 0){
            return true;
        }
        return false;
    }

    public String toString(){
        return "Player" + getplayerID();
    }
    /*

    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        System.out.println(player1.printPlayerId());
        System.out.println(player2.printPlayerId());
    }

     */

}
