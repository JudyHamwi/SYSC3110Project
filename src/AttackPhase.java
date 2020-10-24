import java.util.ArrayList;
import java.util.List;

public class AttackPhase {


    private  Player player;
    private  Country attackerCountry;
    private  Country defenderCountry;
    private Dice dice ;
    private List<Integer> attackerDiceValues;
    private List<Integer> defenderDiceValues;
    private int attackerArmies;

    public AttackPhase(Player player,  Country attackerCountry, Country defenderCountry){
        this.player=player;
        this.attackerDiceValues = new ArrayList<>();
        this.defenderDiceValues = new ArrayList<>();
        this.attackerCountry = attackerCountry;
        this.defenderCountry = defenderCountry;
    }

    public int numberOfDiceForAttacker(){
        if(attackerArmies<1){
            System.out.println("Not Enough Armies to Attack");
        }
        else if(attackerArmies==1){
            return 1;
        }else if (attackerArmies==2){
            return 2;
        }
            return 3;
    }

    int numberOfDiceForDefender(){
        if(defenderCountry.getNumberOfArmies()==1) {
            return 1;
        }
        return 2;

    }

    public void rollForAttacker(){
        dice=new Dice(numberOfDiceForAttacker());
        dice.roll();
        attackerDiceValues = dice.sortedValues();
    }

    public void rollForDefender(){
        dice=new Dice(numberOfDiceForDefender());
        dice.roll();
        defenderDiceValues = dice.sortedValues();
    }

    public void compareDice(){
        if (attackerDiceValues.get(0) > defenderDiceValues.get(0)){
            defenderCountry.addArmy(-1);
        } else{
            attackerCountry.addArmy(-1);
            attackerArmies --;
        }
        if (attackerDiceValues.get(1) > defenderDiceValues.get(1)){
            defenderCountry.addArmy(-1);
        }else{
            attackerCountry.addArmy(-1);
            attackerArmies --;
        }
    }
    public  void numberOfArmiesToMove(){
        defenderCountry.addArmy(attackerArmies);
        attackerCountry.addArmy(-attackerArmies);

    }

    public void attack(){
        attackerArmies=(attackerCountry.getNumberOfArmies())-1;
        while (attackerArmies > 0 && defenderCountry.getNumberOfArmies()>0 ){
            numberOfDiceForAttacker();
            numberOfDiceForDefender();
            rollForAttacker();
            rollForDefender();
            compareDice();
        }
        if (defenderCountry.getNumberOfArmies() == 0){
            defenderCountry.getCurrentOwner().removeCountry(defenderCountry);
            player.addCountry(defenderCountry);
            numberOfArmiesToMove();
        }
    }


}

/*
Step1: Pick a country to attack, and to attack from
Step2: Attack with countryfrom.army-1
Step3: Example: If you attack 8 vs 6
    3.1: 3 vs 2 - and then attacker wins
    3.2: do it again until either attackingtroops or defenderCountry.army reaches 0
step4: if attacker wins, move attacking troops to defenderCountry
    4.1: Change ownership of countries, and update list of countries of playrs

Loop back: ask player if they want to attack again or end turn

 */