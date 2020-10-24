import org.ietf.jgss.GSSManager;

import java.util.Collections;
import java.util.Random;
import java.util.*;


public class Game {

    private Board board;
    private GameState gameState;
    private boolean finished;
    private static LinkedList<Player> players;
    private int playerArmy;
    private int numPlayers;
    private Parser parser;
    private Player currentPlayer;


    public Game() {
        players = new LinkedList<Player>();
        board = new Board();
        parser = new Parser();
    }

    private void initialize(int numberOfPlayers) {
        this.gameState = GameState.INITIALIZING;
        addPlayers(numberOfPlayers);
        initialArmyForPlayer();
        distributeCountries();
        distributeRandomArmyToCountry();
        currentPlayer = players.getFirst();
    }

    public GameState getState() {
        return this.gameState;
    }

    private void addPlayers(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player());
        }
    }


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

    private void distributeOneArmyToCountry() {
        for (Player p : players) {
            for (Country c : p.getCountriesOwned()) {
                c.addArmy(1);
                p.addPlayerArmy(-1);
            }
        }
    }

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

    private void attackPhase(Player player, Country attackerCountry, Country defenderCountry) {
        if (player.canAttack(attackerCountry, defenderCountry)) {
            AttackPhase playerAttack = new AttackPhase(player, attackerCountry, defenderCountry);
            playerAttack.attack();
            removePlayer();
            checkWinner();
        }
    }

    private void removePlayer() {
        for (Player p : players) {
            if (p.getCountriesOwned().size() == 0) {
                players.remove(p);
                System.out.println(p + " has lost.");
            }
        }
    }

    private void checkWinner() {
        if(players.size() == 1){
            System.out.println(players.get(0) + ", you have conquered all your enemies' territories!");
            System.out.println("");
            System.out.println("The game has now ended.");
            System.exit(0);
        }
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to RISK!: Global Domination!");
        System.out.println("The goal of RISK! is to conquer your enemies' territories.");
        System.out.println();
        System.out.println("The number of players ranges from 2-6.");
        System.out.println("Please type in the number of players.");
    }

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

    public void initializePlayers() {
        Command numOfPlayers = parser.getCommand();
        this.numPlayers = processNumOfPlayers(numOfPlayers);
    }

    public void theInitialState() {
        printWelcome();
        initializePlayers();
        initialize(numPlayers);
        printInitialState();
        this.gameState = GameState.IN_PROGRESS;
    }

    public void play() {
        theInitialState();
        while (gameState == GameState.IN_PROGRESS) {
            try {
                System.out.println(currentPlayer + ", it is your turn.");
                Command command = parser.getCommand();
                processCommand(command, currentPlayer);
            } catch (Exception e) {
                System.out.println("Exception Occured: " + e);
                System.out.println("Please enter command again...");
            }
        }
    }


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


    private void printInitialState() {
        System.out.println("HERE IS THE INITIAL STATE OF THE MAP: ");
        for (Player p : players) {
            System.out.println(p);
            System.out.println("owns: " + p.getCountriesOwned());
            System.out.println("Leftover:" + p.getCountriesOwned());
            System.out.println(p.getTotalNumberOfCountries());
            for (Country c : p.getCountriesOwned()) {
                System.out.println(" " + c + " Number of Armies: " + c.getNumberOfArmies());
            }
        }
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    private void printHelp() {
        System.out.println("Aim to conquer enemy territories!");
        System.out.println("Your command words are: ");
        System.out.println("help   exit   attack   print board");
        System.out.println("");
        System.out.println("While attacking, your command words are: ");
        System.out.println("attack (country) from (owned country)       end turn");
    }

    private boolean exit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Exit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

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

        if (command.hasSixthWord()) {
            if (command.getFourthWord().equals("from")) {
                attackingCountry = command.getFifthWord() + " " + command.getSixthWord();
                attackingC = turnAttackerCIntoCountry(p, attackingCountry);

                defendingCountry = command.getSecondWord() + " " + command.getThirdWord();
                System.out.println(defendingCountry);  //testing
                defendingC = turnDefendingCIntoCountry(p, defendingCountry);
            }
        }

        if (!command.hasSixthWord()) {
            if (command.getThirdWord().equals("from")) {
                defendingCountry = command.getSecondWord();
                defendingC = turnDefendingCIntoCountry(p, defendingCountry);
                attackingCountry = command.getFourthWord() + " " + command.getFifthWord();
                attackingC = turnAttackerCIntoCountry(p, attackingCountry);
            }

            if (command.getFourthWord().equals("from")) {
                defendingCountry = command.getSecondWord() + " " + command.getThirdWord();
                defendingC = turnDefendingCIntoCountry(p, defendingCountry);
                attackingCountry = command.getFifthWord();
                attackingC = turnAttackerCIntoCountry(p, attackingCountry);
            }
        }

        if (command.getThirdWord().equals("from")) {
            attackingCountry = command.getFourthWord();
            attackingC = turnAttackerCIntoCountry(p, attackingCountry);
            defendingCountry = command.getSecondWord();
            defendingC = turnDefendingCIntoCountry(p, defendingCountry);
        }

        attackPhase(p, attackingC, defendingC);
    }

    public Country turnAttackerCIntoCountry(Player p, String country) {
        Country attackingC = null;
        for (Country c : p.getCountriesOwned()) {
            if (c.getCountryName().equals(country)) {
                attackingC = c;
            }
        }
        return attackingC;
    }

    public Country turnDefendingCIntoCountry(Player p, String country) {
        Country defendingC = null;
        for (Country c : p.getCountriesOwned()) {
            for (Country adjC : c.getAdjacentCountries()) {
                if (adjC.getCountryName().equals(country)) {
                    defendingC = adjC;
                }
            }
        }
        return defendingC;
    }

    public void printBoard(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Print what?");
            return;
        }
        System.out.println(board);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();

    }

}
