import java.util.Collections;
import java.util.Random;

public class Game {

    private Board board;
    private state gameState;
    private boolean finished;
    private List<Player> players;
    private int playerArmy;

    public Game(int numberOfPlayers){
        players = new ArrayList<Player>();
        board = new Board();
        initialize();
    }

    private void initialize(){
        addPlayers(numberOfPlayers);
        distributeCountries();
        distributeArmyToCountry();

    }

    private void addPlayers(int numberOfPlayers){
        for (int i=0; i<numberOfPlayers; i++){
            players.add(new Player());
        }
    }

    private void distributeCountries(){
        Collections.shuffle(board.getListOfCountries());
        for (int i=0; i<board.getLengthOfCountries(); i+=players.getLength()){

            for (j=0; j<players.getLength(); j++ ) {
                players.add(country[i+j];
            }
        }
    }

    private int initialArmyForPlayer(){
        if (players.length()==2){
            playerArmy = 50;
        }
        if (players.length()==3){
            playerArmy = 35;
        }
        if (players.length()==4){
            playerArmy = 30;
        }
        if (players.length()==5){
            playerArmy = 25;
        }
        if (players.length()==6){
            playerArmy = 20;
        }
    }

    private void distributeRandomArmies(Player p, int army) {
        for (Country c : p.getCountries()) {
            Random r = new Random();
            int randomArmy=r.nextInt(army)+1;
            if(army>0){
                c.addArmy(randomArmy);
            }
            army-=randomArmy;
        }
    }

    private void distributeArmyToCountry(){
        for(Player p:players){
            int counter=playerArmy;
            for(Country c:p.getCountries()){
                c.addArmy(1);
                counter--;
            }
            distributeRandomArmies(p,counter);
        }
    }

    //Example every player has 30 army, and 10 countries
    //distribute one at time so each country has at least (because this is must)
    //Each country has 1, and army to place 20/per player
    //After thats complete, do same loop, except you ad


    private void attack(Country from, Country to){
        int[] attackerDice= new int[3];
        int[] defenderDice= new int[2];

    }

}
