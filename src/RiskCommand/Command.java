package RiskCommand;

/**
 * RISKModel.Command interprets the commands typed by the user and provides functionality for the
 * interaction between the user and the RISKModel.Game
 * @version 1.0
 * @author Sarah Jaber
 * @author Walid Baitul Islam
 * @author Judy Hamwi
 *@author Diana Miraflor
 */

public class Command {
    private String commandWord;
    private String secondWord;
    private String thirdWord;
    private String fourthWord;

    /**
     * RISKModel.Command contruction retrieves a maximum of six words from the user
     * @param word1 first word in the command entered by the user
     * @param word2 second word in the command entered by the user
     * @param word3 third word in the command entered by the user
     * @param word4 fourth word in the command entered by the user
     */
    public Command(String word1, String word2, String word3, String word4) {
        this.commandWord = word1;
        this.secondWord = word2;
        this.thirdWord = word3;
        this.fourthWord = word4;
    }

    /**
     * retrieves the first command word entered by the user
     * @return first word entered by the user
     */
    public String getCommandWord() {
        return commandWord;
    }

    /**
     * retrieves the second command word entered by the user
     * @return second word entered by the user
     */
    public String getSecondWord() {
        return secondWord;
    }

    /**
     * retrieves the third command word entered by the user
     * @return third word entered by the user
     */
    public String getThirdWord() {
        return thirdWord;
    }

    /**
     * retrieves the first command word entered by the user
     * @return first word entered by the user
     */
    public String getFourthWord() { return fourthWord; }

    /**
     * Determines whether or not it is a valid command word
     * @return false if it is not a valid command word and true otherwise
     */
    public boolean isUnknown() {
        return (commandWord == null);
    }
    /**
     * Determines whether the command has a second word
     * @return false if it does not have a second command word and true otherwise
     */
    public boolean hasSecondWord() {
        return (secondWord != null);
    }
    /**
     * Determines whether the command has a third word
     * @return false if it does not have a third command word and true otherwise
     */
    public boolean hasThirdWord() {
        return (thirdWord != null);
    }
    /**
     * Determines whether the command has a fourth word
     * @return false if it does not have a fourth command word and true otherwise
     */
    public boolean hasFourthWord() {
        return (fourthWord != null);
    }

}
