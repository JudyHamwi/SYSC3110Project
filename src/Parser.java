import java.util.Scanner;

public class Parser {
    private CommandWords validInput;
    private Scanner reader;

    public Parser() {
        validInput = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;
        String word3 = null;
        String word4 = null;
        String word5 = null;
        String word6 = null;

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
                        if (tokenizer.hasNext()) {
                            word5 = tokenizer.next();
                            if (tokenizer.hasNext()) {
                                word6 = tokenizer.next();
                            }
                        }
                    }
                }
            }
        }

        if (validInput.isCommand(word1) || validInput.isValidNumOfPlayers(word1)) { // I don't know if this is correct.
            return new Command(word1, word2, word3, word4, word5, word6);

        } else {
            return new Command(null, word2, word3, word4, word5, word6);
        }
    }
}
