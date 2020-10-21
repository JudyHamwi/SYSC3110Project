import java.util.*;

public class Dice {
    private Random random;
    private Die die;
    private int numberOfDice;
    private PriorityQueue<Integer> values;


    public Dice (int numberOfDice){
        this.random = new Random();
        this.numberOfDice = numberOfDice;
        this.values = new PriorityQueue<>();
    }

    public Collection<Integer> roll(){
        for (int i = 0; i <numberOfDice; i++){
            this.die = new Die();
            die.rollDie();
            this.values.add(die.getFaceValue());
        }
        return values;
    }

    public List<Integer> sortedValues(){
        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i< values.size(); i++)
        {
            sortedList.add(values.poll());
        }
        return sortedList;
    }
    public static void main(String[] args) {
        Dice player1Dice = new Dice(3);
        System.out.println("Player1 rolled : " + player1Dice.roll());
        Dice player2Dice = new Dice(2);
        System.out.println("Player2 rolled : " + player2Dice.roll());
        Dice player3Dice = new Dice(1);
        System.out.println("you rolled : " + player3Dice.roll());
    }

}
