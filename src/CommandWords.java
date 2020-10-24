public class CommandWords {

    private static final String[] validCommands = {"help", "exit", "attack", "print", "end"};
    private static final String[] validNumOfPlayers = {"two", "2", "three", "3", "four", "4", "five", "5", "six", "6" };

    public CommandWords() {
    }

    public boolean isCommand(String aString) {
        for (int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString)) return true;
        }
        return false;
    }

    public boolean isValidNumOfPlayers(String aString) {
        for (int i = 0; i < validNumOfPlayers.length; i++) {
            if(validNumOfPlayers[i].equals(aString)) return true;
        }
        return false;
    }
}

