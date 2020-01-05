/**
 * Created by Sharath Nagendra on 1/26/2018.
 */
public interface Game {

    int SIZE = 10;

    int CARRIER = 5;
    int BATTLESHIP = 4;
    int SUBMARINE = 3;
    int CRUISER = 3;
    int DESTROYER = 2;

   //set up the board initially and after this the players can start playing
    void initialize(Player p1, Player p2);

  //start the game. This gives an outcome as to who will win the game
    Player playGame();
}