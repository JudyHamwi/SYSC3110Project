package RiskModel;

import RiskView.BoardView;
import RiskView.RiskView;
import RiskView.RiskViewFrame;

import java.awt.*;
import java.util.Collections;
import java.util.Random;
import java.util.*;


/**
 * The RISK RISKModel.Game that initializes the game, manages the Attack Phase, and keeps track
 * of the turn of each player and winning player
 * @version 1.0
 * @author Sarah Jaber
 * @author Walid Baitul Islam
 * @author Judy Hamwi
 * @author Diana Miraflor
 */

public class Game {

    private Board board;
    private GameState gameState;
    private boolean finished;
    private static LinkedList<Player> players;
    private int playerArmy;
    private int numPlayers;
    //private Parser parser;
    private Player currentPlayer;
    private ArrayList<RiskViewFrame> riskViews;

    /**
     * Starts a new RISKModel.Game
     */
    public Game() {
        players = new LinkedList<Player>();
        board = new Board();
        //parser = new Parser();
        riskViews=new ArrayList<>();
    }

    /**
     * Initalizes the start of the RISKModel.Game
     * @param numberOfPlayers that will play the game
     */
    public void initialize(int numberOfPlayers) {
        this.gameState = GameState.INITIALIZING;
        addPlayers(numberOfPlayers);
        initialArmyForPlayer();
        distributeCountries();
        distributeRandomArmyToCountry();
        currentPlayer = players.getFirst();
        for(RiskView rv:riskViews){
            rv.handleInitialization(this, gameState, currentPlayer);
        }
    }

    /**
     * gets the current state of the game
     * @return RISKModel.GameState of the game
     */
    public GameState getState() {
        return this.gameState;
    }

    /**
     * Adds a number of players to the game
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
     * Calculates the number of armies that will be assigned to every player
     */
    private void initialArmyForPlayer() {
        if (players.size() == 2) {
            playerArmy = 50;
        }
        if (players.size() == 3) {
            playerArmy = 35;
        }
        if (players.size() == 4) {
            playerArmy = 30;
        }
        if (players.size() == 5) {
            playerArmy = 25;
        }
        if (players.size() == 6) {
            playerArmy = 20;
        }
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
     * @param player who wants to attack
     * @param attackerCountry the country that the player wants to attack from
     * @param defenderCountry the country that will be defending from the attack
     */
    private void attackPhase(Player player, Country attackerCountry, Country defenderCountry) {
        if (player.canAttack(attackerCountry, defenderCountry)) {
            AttackPhase playerAttack = new AttackPhase(player, attackerCountry, defenderCountry);
            playerAttack.attack();
            removePlayer();
            checkWinner();
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
        if(players.size() == 1){
            System.out.println(players.get(0) + ", you have conquered all your enemies' territories!");
            System.out.println("");
            System.out.println("The game has now ended.");
            System.exit(0);
        }
    }

    /**
     * prints the welcome message shown when the game starts
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to RISK!: Global Domination!");
        System.out.println("The goal of RISK! is to conquer your enemies' territories.");
        System.out.println();
        System.out.println("The number of players ranges from 2-6.");
        System.out.println("Please type in the number of players.");
    }

    /**
     * Processes the commands entered by the user to produce the required result
     * @param command enetered by the user
     * @param p
     */
    private void processCommand(Command command, Player p) {
        boolean wantToExit = false;

        if (command.isUnknown()) {
            System.out.println("Sorry, I did not understand that.");
        }

        String commandWord = command.getCommandWord();

        if (commandWord.equals("help")) {
            printHelp();
        }
        if (commandWord.equals("attack")) {
            attack(command, p);
        }
        if (commandWord.equals("print")) {
            printBoard(command);
        }
        if(commandWord.equals("end")) {
            endTurn(p);
        }
        if(commandWord.equals("exit")) {
            System.out.println(p + " has quit the game!");
            System.exit(0);
        }
    }


    /**
     * Processes the number of players enetered by the user
     * @param command of number of players enetered by the user
     * @return number of players to play the game
     */
    private int processNumOfPlayers(Command command) {

        if (command.isUnknown()) {
            System.out.println("Invalid number");
        }

        String numPlayers = command.getCommandWord();

        if (numPlayers.equals("two") || numPlayers.equals("2")) {
            return 2;
        }
        if (numPlayers.equals("three") || numPlayers.equals("3")) {
            return 3;
        }
        if (numPlayers.equals("four") || numPlayers.equals("4")) {
            return 4;
        }
        if (numPlayers.equals("five") || numPlayers.equals("5")) {
            return 5;
        }
        if (numPlayers.equals("six") || numPlayers.equals("6")) {
            return 6;
        }
        return 0;
    }

    /**
     * Intializes the number of players in the game
     */
    public void initializePlayers() {
        do{
            try{
                //Command numOfPlayers =parser.getCommand();
               // this.numPlayers =processNumOfPlayers(numOfPlayers);

            }
            catch(Exception e){
                System.out.println("Please enter a valid number between 2 and 6..");
            }
        }
        while(this.numPlayers >6 || this.numPlayers < 2);
    }

    /**
     * Initialzes the state of the game at the start of the game
     */
    public void theInitialState() {
        printWelcome();
        initializePlayers();
        initialize(numPlayers);
        printInitialState();
        this.gameState = GameState.IN_PROGRESS;
    }

    /**
     * Play loop of the game that responds to the player's turns commands
     */
    public void play() {
        theInitialState();
        while (gameState == GameState.IN_PROGRESS) {
            System.out.println(currentPlayer + ", it is your turn.");
            try {
              //  Command command = parser.getCommand();
                //processCommand(command, currentPlayer);
            } catch (Exception e) {
                System.out.println("Exception Occured: " + e);
                System.out.println("Please enter command again...");
            }
        }
    }


    /**
     * ends the turn of the current player and passes the turn to the next player
     * @param p is the current player that will end their turn
     */
    private void endTurn(Player p) {
        gameState = GameState.COMPLETED;
        if (players.getLast().equals(p)) {
            currentPlayer = players.getFirst();
        } else {
            int i = players.indexOf(p);
            currentPlayer = players.get(i + 1);
        }
        gameState = GameState.IN_PROGRESS;
    }


    /**
     * Prints the initial state of the game after the initialization happens
     */
    private void printInitialState() {
        System.out.println("HERE IS THE INITIAL STATE OF THE MAP: ");
        for (Player p : players) {
            System.out.println(p);
            System.out.println("owns: " + p.getCountriesOwned());
            for (Country c : p.getCountriesOwned()) {
                System.out.println(" " + c + " Number of Armies: " + c.getNumberOfArmies());
            }
        }
        printHelp();
    }

    /**
     * returns the number of players in the game
     * @return number of players in the game
     */
    public int getNumPlayers() {
        return numPlayers;
    }

    private void printHelp() {
        System.out.println("Aim to conquer enemy territories!");
        System.out.println("Your command words are: ");
        System.out.println("help   exit   attack   end print board");
        System.out.println("");
        System.out.println("While attacking, your command words are: ");
        System.out.println("attack (country) from (owned country)");
        System.out.println("To end your turn, enter the command : end");
    }

    /**
     * Exits the game
     * @param command that exits the game
     * @return true if it is the right command to exit the game
     */
    private boolean exit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Exit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

    /**
     * Responds to the command of the player to attack
     * @param command entered by the player to attack
     * @param p player that wants to attack
     */
    private void attack(Command command, Player p) {

        String attackingCountry = null;
        String defendingCountry = null;
        Country attackingC = null;
        Country defendingC = null;
        this.gameState = GameState.IN_PROGRESS;

        if (!command.hasSecondWord()) {
            System.out.println("What country would you like to attack?");
            return;
        }

        if (!command.hasThirdWord()) {
            System.out.println("What country would you like to attack from?");
        }

        attackingCountry = command.getFourthWord();
        defendingCountry = command.getSecondWord();

        for(Country c: board.getCountries()) {
            if(c.getCountryName().equals(attackingCountry)) {
                attackingC = c;
            }
        }

        for(Country c : board.getCountries()) {
            if(c.getCountryName().equals(defendingCountry)) {
                defendingC = c;
            }
        }

        attackPhase(p, attackingC, defendingC);
    }

    /**
     * Prints the RISKModel.Board of the RISKModel.Game
     * @param command entered by the player to print the board
     */
    public void printBoard(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Print what?");
            return;
        }
        System.out.println(board);
    }

    public void addRiskView(RiskViewFrame rv){
        riskViews.add(rv);
        rv.handleNewGame(this,board);
    }

    public void removeRiskView(RiskViewFrame rv){
        riskViews.remove(rv);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
