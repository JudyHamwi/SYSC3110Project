package RiskModel;

/**
 * RISKModel.Command Words contains a repository of valid command words to be enetered by the players to play the RISKModel.Game.
 * @version 1.0
 * @author Sarah Jaber
 * @author Walid Baitul Islam
 * @author Judy Hamwi
 * @author Diana Miraflor
 */
public class CommandWords {

    private static final String[] validCommands = {"help", "exit", "attack", "print", "end"};
    private static final String[] validNumOfPlayers = {"two", "2", "three", "3", "four", "4", "five", "5", "six", "6" };

    public CommandWords() {
    }

    /**
     * checks if the command entered by the player is a valid command
     * @param aString command entered by the user
     * @return true of the command is a valid command and false otherwise
     */
    public boolean isCommand(String aString) {
        for (int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString)) return true;
        }
        return false;
    }

    /**
     * Checks if the number of players entered by the player is a valid
     * number of players for the RISKModel.Game
     * @param aString number of players entered by the player
     * @return true of its a valid number of players and false otherwise
     */
    public boolean isValidNumOfPlayers(String aString) {
        for (int i = 0; i < validNumOfPlayers.length; i++) {
            if(validNumOfPlayers[i].equals(aString)) return true;
        }
        return false;
    }
}

