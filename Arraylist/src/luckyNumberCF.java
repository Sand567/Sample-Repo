/**
 * Created by Sharath Nagendra on 1/24/2018.
 */
public class luckyNumberCF {
    static boolean isLucky(int n){
       if(n==0)
           return false;
       int x=n;
       int length = String.valueOf(n).length();
       // System.out.println(length);
       int shortLength = (length/2);
       // System.out.println(shortLength);
       int rem=0,sum=0;
       int rem1=0,sum1=0;
       while(x!=0)
       {
           rem=x%10;
           sum=sum + rem;
           x = x/10;
       }
       int count=0;
       while(count<shortLength)
       {
           rem1=n%10;
           sum1 =sum1 +rem1;
           n=n/10;
           count++;
       }

       if(sum-sum1==sum1)
           return true;
       return false;


    }

    public static void main(String[] args) {
        int n = 239017;
        System.out.println(isLucky(n));
    }
}
