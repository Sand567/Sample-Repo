/**
 * Created by Sharath Nagendra on 1/24/2018.
 */
public class instaCart {


    public static boolean[] delivery(int[] order, int[][] shoppers) {
        if(order.length==0){

            return new boolean[shoppers.length];
        }
        boolean[] res = new boolean[shoppers.length];
        int totalCustWaitTime = order[1]+order[2];
        for(int i=0;i<shoppers.length;i++){
            double approxTime=0.0;

            for(int j=0;j<1;j++){
                approxTime = (((double)order[j]+(double)shoppers[i][j])/shoppers[i][j+1])+shoppers[i][j+2];
            }
            System.out.println(approxTime);
//           if(approxTime<order[1])
//               res[i]=false;
//           if(approxTime==order[1])
//           {
//                res[i]=true;
//           }
//                if(approxTime>order[1] && approxTime<=order[1]+order[2])
//                   res[i]=true;

//                if(approxTime>order[1] && approxTime>order[1]+order[2])
//                   res[i]=false;

//           }
//
            if(approxTime<order[1]){
                res[i]=false;

            }
            if(approxTime==order[1]){
                res[i] = true;

            }

            if(approxTime>order[1] && approxTime>totalCustWaitTime){

                res[i]=false;

            }
            else if(approxTime>order[1] && approxTime<=totalCustWaitTime){
                res[i]=true;
            }
        }



        return res;
    }
    public static void main(String[] args) {
        int[] order = {100,4,3};
        int[][] shoppers = {{100,33,1}};
        boolean[] res = delivery(order,shoppers);
        System.out.println(res.length);
        for(int i=0;i<res.length;i++)
            System.out.println(res[i]);

    }
}
