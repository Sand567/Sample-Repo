import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Sharath Nagendra on 1/26/2018.
 */
class Board{
    public String playerName;
    private int[][] board = new int[20][20];
    public boolean gameOver = false;
    private int s1 = 2;
    private int s2 = 2;
    private int s3 = 1;
    Set<Coordinate> taken = new TreeSet<Coordinate>();
    int remainingShips = 5;

    public Board(String name){
        this.playerName = name;
    }

    public void placeShip(Ship s,int x,int y,Orientation o) throws Exception{
        if(remainingShips==0)
            throw new Exception("No more ship left");

        Set<Coordinate> tmp = new TreeSet<Coordinate>();
        switch(s){
            case Large: if(s3==0)
                throw new Exception("No more large ship left");

                if(o==Orientation.Horizontal){
                    if(x+5>19){
                        throw new Exception("cannot place ship there");
                    }

                    for(int i=0;i<5;i++){
                        Coordinate c = new Coordinate(x+i,y);
                        if(taken.contains(c))
                            throw new Exception("cannot place over another ship");
                        tmp.add(c);
                    }

                }else{
                    if(y+5>19){
                        throw new Exception("cannot place ship there");
                    }

                    for(int i=0;i<5;i++){
                        Coordinate c = new Coordinate(x,y+i);
                        if(taken.contains(c))
                            throw new Exception("cannot place over another ship");
                        tmp.add(c);
                    }
                }
                taken.addAll(tmp);
                tmp.clear();
                --s3;
                break;
            case Medium : if(s2==0)
                throw new Exception("No more medium ship left");


                if(o==Orientation.Horizontal){
                    if(x+3>19){
                        throw new Exception("cannot place ship there");
                    }

                    for(int i=0;i<3;i++){
                        Coordinate c = new Coordinate(x+i,y);
                        if(taken.contains(c))
                            throw new Exception("cannot place over another ship");
                        tmp.add(c);
                    }
                }else{
                    if(y+3>19){
                        throw new Exception("cannot place ship there");
                    }

                    for(int i=0;i<5;i++){
                        Coordinate c = new Coordinate(x,y+i);
                        if(taken.contains(c))
                            throw new Exception("cannot place over another ship");
                        tmp.add(c);
                    }
                }
                taken.addAll(tmp);
                tmp.clear();
                --s2;
                break;
            case Small : if(s1==0)
                throw new Exception("No more small ship left");


                if(o==Orientation.Horizontal){
                    if(x+3>19){
                        throw new Exception("cannot place ship there");
                    }

                    for(int i=0;i<3;i++){
                        Coordinate c = new Coordinate(x+i,y);
                        if(taken.contains(c))
                            throw new Exception("cannot place over another ship");
                        tmp.add(c);
                    }
                }else{
                    if(y+3>19){
                        throw new Exception("cannot place ship there");
                    }

                    for(int i=0;i<5;i++){
                        Coordinate c = new Coordinate(x,y+i);
                        if(taken.contains(c))
                            throw new Exception("cannot place over another ship");
                        tmp.add(c);
                    }
                }
                taken.addAll(tmp);
                tmp.clear();
                --s1;
                break;
        }
    }

    public boolean bombard(int x,int y, String name){
        Coordinate c = new Coordinate(x,y);
        if(this.board[x][y]==1){
            System.out.println("already hit, try again");
            return true;
        }

        this.board[x][y]=1;
        if(taken.contains(c)){
            taken.remove(c);
        }
        if(taken.size()==0){
            System.out.println(name+" WINNER");
            this.gameOver=true;
        }
        return false;
    }
}
