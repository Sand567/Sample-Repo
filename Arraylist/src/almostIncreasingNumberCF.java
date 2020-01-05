/**
 * Created by Sharath Nagendra on 1/24/2018.
 */
public class almostIncreasingNumberCF {

    static boolean almostIncreasingSequence(int[] sequence) {
        if(sequence.length==0)
            return false;
        boolean found=false;
        int i=0,count=0;
        for(i=1;i<sequence.length;i++)
        {
            if(sequence[i]<=sequence[i-1]){// 1 3 2 1
                count++;
                if(found){
                    return false;
                }
                found=true;
                if(i==1 || i+1 ==sequence.length )
                    continue;
                    //c=1
                else if(sequence[i]> sequence[i-2] )
                    sequence[i-1] = sequence[i-2];
                else if(sequence[i-1] >=sequence[i+1])
                    return false;
            }
        }

//&& sequence[i+1]<=sequence[i-1]

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1};
        System.out.println( almostIncreasingSequence(arr));
    }
}
