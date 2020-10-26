import java.util.Scanner;

/**
 * Translates the commands entered by the players to be recognized and executed by the Game
 * @version 1.0
 * @author Sarah Jaber
 * @author Walid Baitul Islam
 * @author Judy Hamwi
 *  @author Diana Miraflor
 */
public class Parser {
    private CommandWords validInput;
    private Scanner reader;

    public Parser() {
        validInput = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * Translates the inputs entered by the user and checks if they are valid commands
     * @return valid command entered by the user
     */
    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;
        String word3 = null;
        String word4 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
                if (tokenizer.hasNext()) {
                    word3 = tokenizer.next();
                    if (tokenizer.hasNext()) {
                        word4 = tokenizer.next();
                    }
                }
            }
        }

        if (validInput.isCommand(word1) || validInput.isValidNumOfPlayers(word1)) {
            return new Command(word1, word2, word3, word4);

        } else {
            return new Command(null, word2, word3, word4);
        }
    }
}
