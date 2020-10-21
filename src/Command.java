public class Command {
    private String commandWord;
    private String secondWord;

    public Command(String word1, String word2) {
        this.commandWord = word1;
        this.secondWord = word2;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public boolean isUnknown() {
        return (commandWord == null);
    }

    public boolean hasSecondWord() {
        return (secondWord != null);
    }

}
