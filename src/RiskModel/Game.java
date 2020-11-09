package RiskModel;

import RiskView.RiskView;
import RiskView.RiskViewFrame;

import java.util.Collections;
import java.util.Random;
import java.util.*;


/**
 * The RISK RISKModel.Game that initializes the game, manages the Attack Phase, and keeps track
 * of the turn of each player and winning player
 *
 * @author Sarah Jaber
 * @author Walid Baitul Islam
 * @author Judy Hamwi
 * @author Diana Miraflor
 * @version 2.0
 */

public class Game {

    private Board board;
    private GameState gameState;
    private boolean finished;
    private static LinkedList<Player> players;
    private int playerArmy;
    private int numPlayers;
    private Player currentPlayer;
    private ArrayList<RiskView> riskViews;
    private Country attackCountry;
    private Map<Integer,Integer> armiesForPlayers;
    /**
     * Starts a new RISKModel.Game
     */
    public Game() {
        players = new LinkedList<Player>();
        board = new Board();
        riskViews=new ArrayList<>();
        this.gameState = GameState.INITIALIZING;
        this.armiesForPlayers = new HashMap();
        setArmiesForPlayers();
    }

    /**
     * Initalizes the start of the RISKModel.Game
     *
     * @param numberOfPlayers that will play the game
     */
    public void initialize(int numberOfPlayers) {
        this.gameState = GameState.INITIALIZING;
        addPlayers(numberOfPlayers);
        initialArmyForPlayer();
        distributeCountries();
        distributeRandomArmyToCountry();
        currentPlayer = players.getFirst();
    }

    /**
     * gets the current state of the game
     *
     * @return RISKModel.GameState of the game
     */
    public GameState getState() {
        return this.gameState;
    }

    public Board getBoard(){ return this.board;}
    /**
     * Adds a number of players to the game
     *
     * @param numberOfPlayers that will play the game
     */
    private void addPlayers(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player());
        }
    }


    /**
     * Distribute equal amount of random countries to each player
     */
    private void distributeCountries() {
        Collections.shuffle(board.getCountries());
        int totalCountries = board.getCountries().size();
        int leftovers = totalCountries % players.size();
        int countryLoop = totalCountries - leftovers;
        for (int i = 0; i < countryLoop; i += players.size()) {
            for (int j = 0; j < players.size(); j++) {
                players.get(j).addCountry(board.getCountries().get(i + j));
            }
        }

        if (leftovers > 0) {
            int i = totalCountries - leftovers;
            for (int j = 0; j < leftovers; j++) {
                players.get(j).addCountry(board.getCountries().get(i + j));
            }
        }
    }

    /**
     * sets the number of initial armies according to the number of players
     */
    public void setArmiesForPlayers(){
        armiesForPlayers.put(2,50);
        armiesForPlayers.put(3,35);
        armiesForPlayers.put(4,30);
        armiesForPlayers.put(5,25);
        armiesForPlayers.put(6,20);
    }
    /**
     * Calculates the number of armies that will be assigned to every player
     */
    private void initialArmyForPlayer() {
        playerArmy = armiesForPlayers.get(players.size());
        for (Player p : players) {
            p.addPlayerArmy(playerArmy);
        }
    }

    /**
     *  Distributes one army to every country owned by the players
     */
    private void distributeOneArmyToCountry() {
        for (Player p : players) {
            for (Country c : p.getCountriesOwned()) {
                c.addArmy(1);
                p.addPlayerArmy(-1);
            }
        }
    }

    /**
     * distributes a random number of armies to every country of the players
     */
    private void distributeRandomArmyToCountry() {
        distributeOneArmyToCountry();
        Random r = new Random();
        for (Player p : players) {
            for (Country c : p.getCountriesOwned()) {
                if (p.getPlayerArmy() > 0) {
                    int randomArmy = (r.nextInt(p.getPlayerArmy())) + 1;
                    c.addArmy(randomArmy);
                    p.addPlayerArmy(-randomArmy);
                }
            }
        }
    }

    /**
     * Initiates the atack phase of the game, which is entered when a player decided to attack
     *
     * @param defenderCountry the country that will be defending from the attack
     */
    public void attackPhase(Country defenderCountry) {
        if (currentPlayer.canAttack(attackCountry, defenderCountry)) {
            AttackPhase playerAttack = new AttackPhase(currentPlayer, attackCountry, defenderCountry);
            Boolean attackSuccess = playerAttack.attack();
            removePlayer();
            checkWinner();
            for (RiskView rv : riskViews) {
                rv.handleAttackPhase(this, attackCountry, defenderCountry, attackSuccess);
            }
        } else {
            for (RiskView rv : riskViews) {
                rv.handleCanNotAttackFrom(this);
            }
        }
    }

    /**
     * Removes a player from the game if lost all their armies
     */
    private void removePlayer() {
        for (Player p : players) {
            if (p.getCountriesOwned().size() == 0) {
                players.remove(p);
                System.out.println(p + " has lost.");
            }
        }
    }

    /**
     * checks if a player won the game if it conquered all the countries in the board
     */
    private void checkWinner() {
        if (players.size() == 1) {
            System.out.println(players.get(0) + ", you have conquered all your enemies' territories!");
            System.out.println("");
            System.out.println("The game has now ended.");
            System.exit(0);
        }
    }

    /**
     * Initializes the number of players in the game
     */
    public void initializePlayers() {
        do {
            try {
                //Command numOfPlayers =parser.getCommand();
                // this.numPlayers =processNumOfPlayers(numOfPlayers);

            } catch (Exception e) {
                System.out.println("Please enter a valid number between 2 and 6..");
            }
        }
        while (this.numPlayers > 6 || this.numPlayers < 2);
    }

    /**
     * Initializes the state of the game at the start of the game
     */
    public void theInitialState() {
        initialize(numPlayers);
        this.gameState = GameState.IN_PROGRESS;
        for(RiskView rv:riskViews){
            rv.handleInitialization(this, gameState,currentPlayer, numPlayers);
        }
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        numPlayers = numberOfPlayers;
    }

    /**
     * Play loop of the game that responds to the player's turns commands
     */
    public void play() {
        theInitialState();
    }


    /**
     * ends the turn of the current player and passes the turn to the next player
     */
    public void endTurn() {
        gameState = GameState.COMPLETED;
        Player p = currentPlayer;
        if (players.getLast().equals(p)) {
            currentPlayer = players.getFirst();
        } else {
            int i = players.indexOf(p);
            currentPlayer = players.get(i + 1);
        }
        gameState = GameState.IN_PROGRESS;

        for(RiskView rv : riskViews) {
            rv.handleEndTurn(this, currentPlayer);
        }

    }

    /**
     * returns the number of players in the game
     *
     * @return number of players in the game
     */
    public int getNumPlayers() {
        return numPlayers;
    }

    /**
     * Prints the help information when the player requests help
     */
    public void printHelp() {
        String pH;
        pH = ("Aim to conquer enemy territories!" + "\n" + "\n" + "In game, you have choices to attack countries and end your turn."
                + "\n" + "To attack, press the country you wish to attack from followed by the attack button, and then" +
                " an enemy territory." + "\n" + "Pass your turn to the next player by pressing" +
                " the end turn button." + "\n" + "\n" + "NOTE: \nIn order to attack an enemy's territory, the country you are " +
                "attacking from must have a minimum of 2 armies." + "\n\n" + "GOOD LUCK!");

        for (RiskView rv : riskViews) {
            rv.handlePrintHelp(this, pH);
        }
    }

    /**
     * adds the view to the list of viewers of the game model
     *
     * @param rv view of the model
     */
    public void addRiskView(RiskView rv) {
        riskViews.add(rv);
        for(RiskView rv2:riskViews) {
            rv2.handleNewGame(this, board);
        }
    }

    /**
     * removes a view from the viewers of the game model
     *
     * @param rv view to be removed from the viewers of the model
     */
    public void removeRiskView(RiskViewFrame rv) {
        riskViews.remove(rv);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

    /**
     * checks of the attacker country chosen by the player is a valid country
     * that the play can attack from, following the rules of the attack
     *
     * @param attackCountry that the player wants to attack from in the attack phase
     */
    public void checkAttackingCountry(Country attackCountry) {
        if (attackCountry.getCurrentOwner().equals(currentPlayer)) {
            this.attackCountry = attackCountry;
            for (RiskView rv : riskViews) {
                rv.handleCanAttackFrom(this, attackCountry);
            }
        } else {
            for (RiskView rv : riskViews) {
                rv.handleCanNotAttackFrom(this);
            }
        }
    }
}
