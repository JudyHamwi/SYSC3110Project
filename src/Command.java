public class Command {
    private String commandWord;
    private String secondWord;
    private String thirdWord;
    private String fourthWord;
    private String fifthWord;
    private String sixthWord;

    public Command(String word1, String word2, String word3, String word4, String word5, String word6) {
        this.commandWord = word1;
        this.secondWord = word2;
        this.thirdWord = word3;
        this.fourthWord = word4;
        this.fifthWord = word5;
        this.sixthWord = word6;

    }

    public String getCommandWord() {
        return commandWord;
    }
    public String getSecondWord() {
        return secondWord;
    }
    public String getThirdWord() {
        return thirdWord;
    }
    public String getFourthWord() { return fourthWord; }
    public String getFifthWord() { return fifthWord; }
    public String getSixthWord() { return sixthWord; }

    public boolean isUnknown() {
        return (commandWord == null);
    }

    public boolean hasSecondWord() {
        return (secondWord != null);
    }
    public boolean hasThirdWord() {
        return (thirdWord != null);
    }
    public boolean hasFourthWord() {
        return (fourthWord != null);
    }
    public boolean hasFifthWord() {return (fifthWord != null);}
    public boolean hasSixthWord() {return (sixthWord != null);}


}
