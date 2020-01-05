/**
 * Created by Sharath Nagendra on 1/26/2018.
 */
public interface Player {


    // This method will place a ship on the grid
    Location placeShip(int size, boolean retry);


    //This method will get the new target to aim for
    Location getTarget();

    // This method will notify the Player of the result of the previous shot
    void setResult(boolean hit, boolean sunk);

}
