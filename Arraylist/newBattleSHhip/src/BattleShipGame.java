import com.sun.glass.ui.Size;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sharath Nagendra on 1/26/2018.
 */
public class BattleShipGame implements Game {


    private int[][] p1Board, p2Board, board;


    private Player p1, p2, playerWin, generalPlayer;


    private ArrayList<Integer> shipsToPlace;


    private ArrayList<Location> shipPlacementP1, shipPlacementP2;

    private ArrayList<Location> movesMadeP1, movesMadeP2;


    private boolean check, hit, sunk;


    private Location ship, target;


    private int hitShipSize, hits, p1SunkShips, p2SunkShips;

    //constructor
    public BattleShipGame() {
        shipPlacementP1 = new ArrayList<Location>();
        shipPlacementP2 = new ArrayList<Location>();
        movesMadeP1 = new ArrayList<Location>();
        movesMadeP2 = new ArrayList<Location>();
        p1Board = new int[SIZE][SIZE];
        p2Board = new int[SIZE][SIZE];
        board = new int[SIZE][SIZE];
        hit = false;
        sunk = false;
        hits = 0;
        p1SunkShips = 0;
        p2SunkShips = 0;
    }


    @Override
    public void initialize(Player p1, Player p2) {

        this.p1 = p1;
        this.p2 = p2;

        p1Board = new int[SIZE][SIZE];
        p2Board = new int[SIZE][SIZE];
        board = new int[SIZE][SIZE];
        check = false;
        shipsToPlace = new ArrayList<Integer>();

        //the official names of the ships in the battlefield game
        shipsToPlace.add(CARRIER);
        shipsToPlace.add(BATTLESHIP);
        shipsToPlace.add(SUBMARINE);
        shipsToPlace.add(CRUISER - 2); // Cruiser will be represented as a 1 on
        // the grid
        shipsToPlace.add(DESTROYER);

        System.out.println("Deploying ships for Player 1 ");
        for (int shipSize : shipsToPlace) {
            int size = shipSize;
            if (shipSize == 1) {
                size = 3;
            }
            System.out.println("Placing ship of size: " + size);
            ship = p1.placeShip(shipSize, check);
            shipPlacementP1.add(ship);
            setBoard(shipSize, p1);
            if(p1 instanceof HumanPlayer){
                System.out.println("\n"+ "Player 1's Board: ");
                printBoard(p1);
            }
        }

        System.out.println("\n" + "Player 1's Set Board: ");
        printBoard(p1);
        System.out.println("Player 1's ships have been deployed" + "\n");

        System.out.println("Deploying ships for Player 2 ");
        for (int shipSize : shipsToPlace) {
            int size = shipSize;
            if (shipSize == 1) {
                size = 3;
            }
            System.out.println("Placing ship of size: " + size);
            ship = p2.placeShip(shipSize, check);
            shipPlacementP2.add(ship);
            setBoard(shipSize, p2);
            if(p2 instanceof HumanPlayer){
                System.out.println("Player 2's Board: ");
                printBoard(p2);
            }
        }
        System.out.println("\n" + "Player 2's Set Board: ");
        printBoard(p2);
        System.out.println("\n"+ "Player 2's ships have been deployed" + "\n");

    }

    @Override
    public Player playGame() {


        while (p1SunkShips < 5 || p2SunkShips < 5) {
            System.out.println("\n" + "Player 1's turn to fire missle" + "\n");
            target = p1.getTarget();
            int p1TargetX = target.getX();
            int p1TargetY = target.getY();
            movesMadeP1.add(target);

            if (p2Board[p1TargetX][p1TargetY] > 0) {
                hit = true;
                hitShipSize = p2Board[p1TargetX][p1TargetY];
                p2Board[p1TargetX][p1TargetY] = (-1)
                        * p2Board[p1TargetX][p1TargetY];
            }

            if (hit == false) {
                sunk = false;
            }

            if (hit == true) {
                sunk = checkSunkFor(p1, hitShipSize);

            }

            if (hit == true && sunk == true) {
                p1SunkShips++;

            }

            p1.setResult(hit, sunk);
            System.out.println("Player1 has sunk " + p1SunkShips
                    + "/5 of player 2's ships");
            if (p1SunkShips == 5) {
                playerWin = p1;
                System.out.println("Player 2's board: ");
                printBoard(p2);
                System.out.println("\n" + "Player 1 WON!");
                return playerWin;
            }
            System.out.println("P2's board:");
            printBoard(p2);

            System.out.println("\n" + "Player 2 is firing a missile" + "\n");
            target = p2.getTarget();
            int p2TargetX = target.getX();
            int p2TargetY = target.getY();
            movesMadeP2.add(target);

            if (p1Board[p2TargetX][p2TargetY] > 0) {
                hit = true;
                hitShipSize = p1Board[p2TargetX][p2TargetY];
                p1Board[p2TargetX][p2TargetY] = (-1)
                        * p1Board[p2TargetX][p2TargetY];
            } else {
                hit = false;
                sunk = false;
            }

            if (hit == true) // check if sunk
            {
                sunk = checkSunkFor(p2, hitShipSize);

            }

            if (hit == false) {
                sunk = false;
            }

            if (hit == true && sunk == true) {
                p2SunkShips++; // number of ships of p2 that player
                // 1 has sunk

            }
                p2.setResult(hit, sunk);
                System.out.println("Player2 has sunk " + p2SunkShips
                        + "/5 of player 1's ships");

                if (p2SunkShips == 5) {
                    playerWin = p2;
                    System.out.println("Player 1's board: ");
                    printBoard(p1);
                    System.out.println("Player 2 WON!");

                    return playerWin;
                }
                System.out.println("P1's board:");
                printBoard(p1);

                hit = false;
                sunk = false;
            }



        return playerWin;
    }


    public void setBoard(int i, Player p) {
        int boardIter = i;
        if (boardIter == 1) {
            boardIter = 3;
        }
        int shipSize = i;
        generalPlayer = p;

        if (generalPlayer == p1) {
            board = p1Board;
        }

        if (generalPlayer == p2) {
            board = p2Board;
        }

        boolean horizontal = ship.isShipHorizontal();

        if (horizontal == false) {
            int yCoor = ship.getY();
            while (boardIter > 0) {
                board[ship.getX()][yCoor] = shipSize;
                boardIter--;
                yCoor++;
            }
        }

        if (horizontal != false) {
            int xCoor = ship.getX();
            while (boardIter > 0) {
                board[xCoor][ship.getY()] = shipSize;
                boardIter--;
                xCoor++;
            }
        }
        for (int col = 0; col < SIZE; col++) {
            for (int r = 0; r < SIZE; r++) {
                if (board[r][col] != 0) {
                    board[r][col] = board[r][col];
                } else {
                    board[r][col] = 0;
                }

            }

        }

        if (generalPlayer == p1) {
            p1Board = board;
        }

        if (generalPlayer == p2) {
            p2Board = board;
        }

    }

   //return player board
    public int[][] getBoard(Player p) {
        generalPlayer = p;

        if (generalPlayer == p1) {
            board = p1Board;
        }

        if (generalPlayer == p2) {
            board = p2Board;
        }

        return board;
    }

   //print player board
    public void printBoard(Player p) {

        generalPlayer = p;
        if (generalPlayer == p1) {
            board = p1Board;
        }

        if (generalPlayer == p2) {
            board = p2Board;
        }

        for (int col = 0; col < SIZE; col++) {
            for (int r = 0; r < SIZE; r++) {
                System.out.print(board[r][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //if sunk or not
    public boolean checkSunkFor(Player p, int hitSize) {
        // System.out.println("hitSize: " + hitSize);
        generalPlayer = p;
        sunk = false;

        if (generalPlayer == p1) {
            board = p2Board;

        }

        if (generalPlayer == p2) {
            board = p1Board;

        }

        for (int col = 0; col < 10; col++) {
            for (int r = 0; r < 10; r++) {
                if (board[r][col] == -hitSize) {
                    hits++;
                }
            }
        }

        if (hits == hitSize && hitSize != 1) {

            sunk = true;
        }

        if (hitSize == 1) {

            if (hits == 3) {
                sunk = true;
            }
        }
        hits = 0;
        return sunk;
    }

}