/**
 * Created by Sharath Nagendra on 1/26/2018.
 */


   public class Coordinate implements Comparable<Coordinate>{
        private int x;
        private int y;
        public Coordinate(int x,int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Coordinate c) {
            // TODO Auto-generated method stub
            if(this.x==c.x && this.y==c.y)
                return 0;
            return 1;
        }

    }

