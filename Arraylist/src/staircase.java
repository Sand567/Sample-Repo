/**
 * Created by Sharath Nagendra on 7/25/2017.
 */
public class staircase {


    public static int countWaysUtil(int n, int m) {
        if (n <= 1)
            return n;
        int res = 0;
        for (int i = 1; i <= m && i <= n; i++)
            res += countWaysUtil(n - i, m);
        return res;
    }


    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        //int s = in.nextInt();//input 3 ie the number of stairs he can climb at a time
//        int m = in.nextInt();//number he can climb at once
//        // int s= 7;
//        int s;
//        for (int i = 0; i < m; i++) {
//            s = in.nextInt();//number of stairs
//            System.out.println(countWaysUtil(s + 1, m));
//
//        }
        System.out.println(countWaysUtil(3+1,2));
    }
}
