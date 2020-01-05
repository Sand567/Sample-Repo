/**
 * Created by Sharath Nagendra on 1/25/2018.
 */
public class alternatingSum {


    static int[] alternatingSums(int[] a) {
        int[] res= new int[2];
        if(a.length==0)
            return null;
        int totalSum=0;
        int sum=0;
        for(int i=0;i<a.length;i++)
            totalSum=totalSum+a[i];
        for(int i=0;i<a.length;i=i+2)
        {
            sum=sum+a[i];
        }

//        System.out.println(totalSum);
//        System.out.println(sum);
        int resSum=totalSum-sum;
      //  System.out.println(totalSum-sum);


//        int t1Sum=0,t2Sum=0;
//        int i=0;
//        for(i=1;i<a.length;i=i+2){
//            t1Sum+=a[i-1];
//            t2Sum+=a[i];
//
//        }
//        t1Sum+=a[i-1];
//        System.out.println(i);
//        res[0]=t1Sum;
//        res[1]=t2Sum;
//        return res;
        res[0]=sum;
        res[1] = resSum;
return res;
    }
//215
    //110

    public static void main(String[] args) {
        int[] a = {50, 60, 60, 45,70};//70
        int[] res = alternatingSums(a);
        for(int i=0;i<res.length;i++)
            System.out.println(res[i]);
    }
}
