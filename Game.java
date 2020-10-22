public class Game {

    private Board board;
    private state gameState;
    private boolean finished;
    private List<Player> players;

    public Game(int numberOfPlayers){
        players = new ArrayList<Player>();
        board = new Board();

    }




    private void initialize(){

    }

    private void distributeCountries(){
        for (int i=0; i<board.getLengthOfCountries(); i+=players.getLength()){

            for (j=0; j<players.getLength(); j++ ) {
                players.add(country[i+j];
            }
        }
    }


    private void addPlayers(int numberOfPlayers){
        for (int i=0; i<numberOfPlayers; i++){
            
        }
    }

}
