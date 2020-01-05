/**
 * Created by Sharath Nagendra on 11/7/2017.
 */
public class consecutiveSum {

    // Utility method to compute number of ways
    // in which N can be represented as sum of
    // consecutive number
    public static int countConsecutive(int N) {
        // constraint on values of L gives us the
        // time Complexity as O(N^0.5)
        int count = 0;
        for (int L = 1; L * (L + 1) < 2 * N; L++) {
            float a = (float) ((1.0 * N - (L * (L + 1)) / 2) / (L + 1));
            if (a - (int) a == 0.0)
                count++;
        }
        return count;
    }


    public static long countConsecutive(long num){

        long sumOfFirstIntegers = 3;
        long count = 0;
        for(long i = 2 ; sumOfFirstIntegers<=num; ++i){
            if((i%2==0)?(num%i==i/2): (num%i==0)){
                ++count;
            }
            sumOfFirstIntegers+=i+1;
        }
        return count;
    }




    // Driver code to test above function
    public static void main(String[] args) {
        int N = 15;
        long num = 15;
//        long l = 0, r = 0, s = 0, c = 0;
//        while (r <= (num + 1) / 2) {
//            r++;
//            s += r;
//            while (s > num) {
//                l++;
//                s -= l;
//            }
//            if (s == num) c++;
//        }
//        System.out.println( c);

        long res =countConsecutive(num);
        System.out.println(res);
    }
//            System.out.println(countConsecutive(N));
}






