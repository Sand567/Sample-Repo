import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 1/26/2018.
 */
public class HumanPlayer implements Player {

    private int shipSize, xPlace, yPlace, xTarget, yTarget;
    private boolean redo, horizontal;
    private HumanLocation ship, topLeftCoordinate, humanAim;
    private ArrayList<HumanLocation> setOfCoordinates, movesMade;
    private int[][] humanBoard;
    private int SIZE = 10;

    public HumanPlayer() {
        humanBoard = new int[SIZE][SIZE];
        setOfCoordinates = new ArrayList<HumanLocation>();
        movesMade = new ArrayList<HumanLocation>();

    }


    @Override
    public Location placeShip(int size, boolean retry)
            throws ArrayIndexOutOfBoundsException, InputMismatchException {
        // TODO Auto-generated method stub

        shipSize = size;
        redo = retry;

        Scanner in = new Scanner(System.in);
        String input = null;

        if (redo)
            System.out
                    .println("Error with input. "
                            + "Either Index outside the limit or you have selected an already taken position."
                            + " Please try again." + "\n");

        System.out
                .println("Vertical placement or horizontal placement "
                        + "Type v for vertical, h for horizontal: ");



        if (in.hasNext()) {
            input = in.next();

            if (input.equals("v")) {
                horizontal = false;
            }

            else if (input.equals("h")) {
                horizontal = true;
            }
        }

        System.out.println("Please enter a number (0 -9 ) "
                + "to represent the Y coordinate of your ship: ");
        xPlace = in.nextInt();

        System.out.println("Please enter a number (0 - 9) "
                + "to represent the X coordinate of your ship: ");
        yPlace = in.nextInt();

        if (xPlace < 0 || xPlace > 9 || yPlace < 0 || yPlace > 9
                || (horizontal && xPlace + shipSize > 10)
                || (!horizontal && yPlace + shipSize > 10))
            return placeShip(size, true);

        ship = new HumanLocation(xPlace, yPlace, horizontal, shipSize);
        if (isValid() == false) {
            return placeShip(size, true);
        }
        setBoard();
        topLeftCoordinate = ship;
        setOfCoordinates.add(topLeftCoordinate);
        return ship;

    }

    @Override
    public Location getTarget() throws ArrayIndexOutOfBoundsException,
            InputMismatchException {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        System.out
                .println("Please enter a number (0 - 9) "
                        + "to represent the Y coordinate of your target: ");
        if (in.hasNextInt()) {
            xTarget = in.nextInt();
        }

        System.out
                .println("Please enter a number (0 - 9) "
                        + "to represent the X coordinate of yout target: ");
        if (in.hasNextInt()) {
            yTarget = in.nextInt();
        }

        if (xTarget < 0 || yTarget < 0 || xTarget > 9 || yTarget > 9) {
            System.out
                    .println("Error: Target out of bounds.Retry."
                            + "\n");
            return getTarget();
        }

        humanAim = new HumanLocation(xTarget, yTarget, false, 0);


        for (HumanLocation l : movesMade) {

            if (l.getX() == humanAim.getX() && l.getY() == humanAim.getY()) {
                System.out.println("You have ALREADY TAKEN that position."
                        + "\n" + "Enter another set of coordinates" + "\n");
                return getTarget();
            }
        }

        movesMade.add(humanAim);
        return humanAim;
    }


    @Override
    public void setResult(boolean hit, boolean sunk) {
        // TODO Auto-generated method stub

        if (hit == true) {
            System.out.println("Your missile is a HIT!");
        }

        if (hit == false && sunk == false) {
            System.out.println("Your missile is a MISS.");
        }

        if (hit == true && sunk == true) {
            System.out.println("You SUNK an enemy ship!");
        }
    }

 //set board
    public void setBoard() {
        int boardIter = shipSize;
        if (shipSize == 1) {
            boardIter = 3;
        }

        if (horizontal == false) {
            int yCoor = ship.getY();
            while (boardIter > 0) {
                humanBoard[ship.getX()][yCoor] = shipSize;
                boardIter--;
                yCoor++;
            }
        }

        if (horizontal != false) {
            int xCoor = ship.getX();
            while (boardIter > 0) {
                humanBoard[xCoor][ship.getY()] = shipSize;
                boardIter--;
                xCoor++;
            }
        }
        for (int col = 0; col < SIZE; col++) {
            for (int r = 0; r < SIZE; r++) {
                if (humanBoard[r][col] != 0) {
                    humanBoard[r][col] = humanBoard[r][col];
                } else {
                    humanBoard[r][col] = 0;
                }
            }
        }
    }

//Print board
    public void printBoard() {
        System.out.println("Your current board: " + "\n");
        for (int col = 0; col < SIZE; col++) {
            for (int r = 0; r < SIZE; r++) {
                System.out.print(humanBoard[r][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

  //returns board
    public int[][] getBoard() {
        return humanBoard;
    }


    public boolean isValid() {

        boolean okay = true;

        int checkIter = shipSize;
        if (shipSize == 1) {
            checkIter = 3;
        }


        if (horizontal == false) {
            int yCoor = ship.getY();

            while (checkIter > 0) {

                if (humanBoard[ship.getX()][yCoor] > 0) {
                    okay = false;

                    return okay;
                }
                checkIter--;
                yCoor++;
            }
        }

        if (horizontal != false) {
            int xCoor = ship.getX();;
            while (checkIter > 0) {
                if (humanBoard[xCoor][ship.getY()] > 0) {
                    okay = false;

                    return okay;
                }
                checkIter--;
                xCoor++;
            }
        }

        else
            okay = true;

        return okay;

    }
}
