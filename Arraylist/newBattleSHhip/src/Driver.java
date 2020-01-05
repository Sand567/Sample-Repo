import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 1/26/2018.
 */
public class Driver {
    public static void main(String[] args) {
        Player p1 = null, p2 = null;
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to BattleShip!" + "\n");
            System.out
                    .println("Welcome to 2 player game:"
                            + "\n"
                            + "Type 1 to start: ");
            int decision = Integer.parseInt(input.next());

            switch (decision) {
                case 1:
                    p1 = new HumanPlayer();
                    p2 = new HumanPlayer();
                    break;
            }

            Game game = new BattleShipGame();
            game.initialize(p1, p2);
            game.playGame();
        }

        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
