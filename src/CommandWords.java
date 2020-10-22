public class CommandWords {

    public static final String[] validCommands = {"help", "exit", "attack", "print board", "roll", "end turn"};

    public CommandWords() {
    }

    public boolean isCommand(String aString) {
        for (int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString)) return true;
        }
        return false;
    }
}
