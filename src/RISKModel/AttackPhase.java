package RISKModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *One of the Phases of the RISKModel.Game, the Attack Phase. This Phase is entered when a player attacks a RISKModel.Country.
 * @version 1.0
 * @author Sarah Jaber
 * @author Walid Baitul
 * @author Judy Hamwi
 * @author Diana Miraflor
 */

public class AttackPhase {


    private Player player;
    private Country attackerCountry;
    private Country defenderCountry;
    private Dice dice ;
    private List<Integer> attackerDiceValues;
    private List<Integer> defenderDiceValues;
    private int attackerArmies;

    /**
     *  Constructor of Attack Phase initalizes the fields.
     * @param player initiating the attack
     * @param attackerCountry contains the armies that want to attack
     * @param defenderCountry country that contains armies to defend the attack
     */
    public AttackPhase(Player player, Country attackerCountry, Country defenderCountry){
        this.player=player;
        this.attackerDiceValues = new ArrayList<>();
        this.defenderDiceValues = new ArrayList<>();
        this.attackerCountry = attackerCountry;
        this.defenderCountry = defenderCountry;
    }

    /**
     *  Calculate the number of RISKModel.Dice that need to be rolled for the Attack. The number of dice
     *  used to attack is equal to the number of armies attacking. The number is calculated
     *  with the maximum number of armies atacking.
     * @return number of dice rolled for the attack
     */
    public int numberOfDiceForAttacker(){
        if(attackerArmies<1){
            System.out.println("Not Enough Armies to Attack");
        } else if (attackerArmies==1){
            return 1;
        } else if (attackerArmies==2){
            return 2;
        }
        return 3;
    }

    /**
     * Calculate teh number of dice to be rolled for the defender country. The number of dice represent the number
     * if armies defending the country. If the number of armies is only one, the defender can only roll one deice,
     * else the defender can roll two dice
     * @return number of dice rolled by the defender
     */
    int numberOfDiceForDefender(){
        if(defenderCountry.getNumberOfArmies()==1) {
            return 1;
        }
        return 2;

    }

    /**
     * Roll of RISKModel.Dice of th Attacker
     */
    public void rollForAttacker(){
        dice=new Dice(numberOfDiceForAttacker());
        dice.roll();
        attackerDiceValues = dice.sortedValues();
    }

    /**
     * Roll of RISKModel.Dice of the Defender
     */
    public void rollForDefender(){
        dice=new Dice(numberOfDiceForDefender());
        dice.roll();
        defenderDiceValues = dice.sortedValues();
    }

    /**
     * Compare the Roll of RISKModel.Dice of the Attacker and Defender. Remove armies of the losing country.
     */
    public void compareDice(){
        if (attackerDiceValues.get(0) > defenderDiceValues.get(0)){
            defenderCountry.addArmy(-1);
        } else if(attackerDiceValues.get(0) < defenderDiceValues.get(0)){
            attackerCountry.addArmy(-1);
            attackerArmies --;
        }
        if(attackerDiceValues.size()>1 && defenderDiceValues.size()>1 ) {
            if (attackerDiceValues.get(1) > defenderDiceValues.get(1)) {
                defenderCountry.addArmy(-1);
            } else {
                attackerCountry.addArmy(-1);
                attackerArmies--;
            }
        }
    }

    /**
     * If the Attacker wins, the armies are moved from the attacker country to the defender country
     */
    public  void numberOfArmiesToMove(){
        defenderCountry.addArmy(attackerArmies);
        attackerCountry.addArmy(-attackerArmies);

    }

    /**
     * Applies the attack phase of the RISKModel.Game. It implements the player attacking the defender, and
     * makes the decision of the attacker army conquering the defender armu.
     */
    public void attack() {
        attackerArmies=(attackerCountry.getNumberOfArmies())-1;
        System.out.println(player + " has attacked " + defenderCountry + " with " + attackerArmies + " armies.");
        System.out.println(defenderCountry + " is defending with " + defenderCountry.getNumberOfArmies() + " armies.");
        while (attackerArmies > 0 && defenderCountry.getNumberOfArmies()>0 ){
            numberOfDiceForAttacker();
            numberOfDiceForDefender();
            rollForAttacker();
            rollForDefender();
            compareDice();
        }
        if (defenderCountry.getNumberOfArmies() == 0) {
            defenderCountry.getCurrentOwner().removeCountry(defenderCountry);
            player.addCountry(defenderCountry);
            numberOfArmiesToMove();
            System.out.println(player + " has conquered " + defenderCountry + " and is occupied by " + attackerArmies
                                        + " armies.");
        } else {
            System.out.println(defenderCountry + " was not conquered and has " + defenderCountry.getNumberOfArmies()
                                        + " armies.");
        }
    }

    /**
     * Translates the commands entered by the players to be recognized and executed by the RISKModel.Game
     * @version 1.0
     * @author Sarah Jaber
     * @author Walid Baitul Islam
     * @author Judy Hamwi
     *  @author Diana Miraflor
     */
    public static class Parser {
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
}