import java.util.Collections;
import java.util.Random;
import java.util.*;

public class Game {

    private Board board;
    private GameState gameState;
    private boolean finished;
    private static List<Player> players;
    private int playerArmy;

    public Game(int numberOfPlayers){
        players = new ArrayList<Player>();
        board = new Board();
        initialize(numberOfPlayers);
    }

    private void initialize(int numberOfPlayers){
        this.gameState = GameState.IN_PROGRESS;
        addPlayers(numberOfPlayers);
        initialArmyForPlayer();
        distributeCountries();
        distributeRandomArmyToCountry();
    }

    public GameState getState(){
        return this.gameState;
    }

    private void addPlayers(int numberOfPlayers){
        for (int i=0; i<numberOfPlayers; i++){
            players.add(new Player());
        }

    }

    private void distributeCountries(){
        Collections.shuffle(board.getCountries());
        for (int i=0; i<board.getCountries().size(); i+=players.size()){

            for (int j=0; j<players.size(); j++ ) {
                players.get(j).addCountry(board.getCountries().get(i+j));
            }
        }
    }

    private void initialArmyForPlayer(){
        if (players.size()==2){
            playerArmy = 50;
        }
        if (players.size()==3){
            playerArmy = 35;
        }
        if (players.size()==4){
            playerArmy = 30;
        }
        if (players.size()==5){
            playerArmy = 25;
        }
        if (players.size()==6){
            playerArmy = 20;
        }
        for (Player p:players){
            p.addPlayerArmy(playerArmy);
        }
    }

   /* private void distributeRandomArmies(Player p, int army) {
        Random r = new Random();
        for (Country c : p.getPlayerCountries()) {
            if(army>0){
                int randomArmy=(r.nextInt(army+1));
                c.addArmy(randomArmy);
                army-=randomArmy;
            }
        }
    }

    */

    private void distributeOneArmyToCountry(){
        for(Player p:players){
            for(Country c:p.getCountriesOwned()){
                c.addArmy(1);
                p.addPlayerArmy(-1);
            }
        }
    }

    private void distributeRandomArmyToCountry(){
        distributeOneArmyToCountry();
        Random r = new Random();
        for (Player p: players) {
            for (Country c : p.getCountriesOwned()) {
                if (p.getPlayerArmy() > 0) {
                    int randomArmy = (r.nextInt(p.getPlayerArmy()))+ 1;
                    c.addArmy(randomArmy);
                    p.addPlayerArmy(-randomArmy);
                }
            }
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

    public void printBoard(){
        System.out.println(board);
    }

    public static void main(String[] args) {
        Game game=new Game(3);
        for(Player p:players) {
            System.out.println(p);
            System.out.println("owns: " + p.getCountriesOwned());
            System.out.println("Leftover:" + p.getCountriesOwned());
            for(Country c:p.getCountriesOwned()){
                System.out.println(" "+ c + " Number of Armies: "+ c.getNumberOfArmies());
            }

        }
        game.printBoard();
    }

}
