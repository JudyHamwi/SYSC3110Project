/**
 * Command interprets the commands typed by the user and provides functionality for the
 * interaction between the user and the Game
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
    private String fifthWord;
    private String sixthWord;

    /**
     * Command contruction retrieves a maximum of six words from the user
     * @param word1 first word in the command entered by the user
     * @param word2 second word in the command entered by the user
     * @param word3 third word in the command entered by the user
     * @param word4 fourth word in the command entered by the user
     * @param word5 fifth word in the command entered by the user
     * @param word6 sixth word in the command entered by the user
     */
    public Command(String word1, String word2, String word3, String word4, String word5, String word6) {
        this.commandWord = word1;
        this.secondWord = word2;
        this.thirdWord = word3;
        this.fourthWord = word4;
        this.fifthWord = word5;
        this.sixthWord = word6;

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
     * retrieved the fifth command word entered by the user
     * @return fifth word entered by the user
     */
    public String getFifthWord() { return fifthWord; }

    /**
     * retrieved the sixth command word entered by the user
     * @return sixth word entered by the user
     */
    public String getSixthWord() { return sixthWord; }

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
    /**
     * Determines whether the command has a fifth word
     * @return false if it does not have a fifth command word and true otherwise
     */
    public boolean hasFifthWord() {return (fifthWord != null);}
    /**
     * Determines whether the command has a sixth word
     * @return false if it does not have a sixth command word and true otherwise
     */
    public boolean hasSixthWord() {return (sixthWord != null);}


}
