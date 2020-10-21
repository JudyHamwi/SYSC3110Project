import java.util.ArrayList;
import java.util.List;

public class Player {
    private static int playerCounter =1;
    private final int PLAYER_ID;
    private List<Country> countries;
    private List<Continent> continents;

    public Player(){
        this.PLAYER_ID = this.getNextPlayerId();
        this.countries = new ArrayList<>();
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

    public int getTotalNumberOfCountries(){
        return 1;
    }

    public boolean canAttack(Country country){
        return false;
    }

    public boolean hasContinent(){
        return false;
    }

    public List<Continent> ownsContinent(){
        return continents;
    }

}
