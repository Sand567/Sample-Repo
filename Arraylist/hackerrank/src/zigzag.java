/**
 * Created by Sharath Nagendra on 2/21/2018.
 */
public class zigzag {

    static int findZigZag(int arr[]) {

        if(arr.length<=2)
            return 1;
        int max = 0;
        int longestLength = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i + 1] - arr[i] < 0) {
                if (arr[i + 2] - arr[i + 1] > 0) {
                    max++;
                }
            }  if (arr[i + 1] - arr[i] > 0) {
                if (arr[i + 2] - arr[i + 1] < 0) {
                    max++;
                }
            }
            longestLength = Math.max(max, longestLength);

        }
        return longestLength;

    }

    static int findAnotherZigZag(int a[]){
        int best = 1;
        int left = 0;
        while (left < a.length) {
            int right = left + 1;
            while (right < a.length) {
                if (right == left + 1) {
                    if (a[left] == a[right]) {
                        break;
                    }
                } else {
                    if ((a[right - 1] - a[right - 2]) * (a[right - 1] - a[right]) <= 0) {
                        break;
                    }
                }
                right++;
            }
            best=Math.max(best,right-left);
            left=right;
            if (left < a.length && a[left - 1] != a[left]) {
                left--;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        int arr[] = {4,4};
        //int[] arr = {4,4};
        //System.out.println(findAnotherZigZag(arr));
        System.out.println(findZigZag(arr));

    }
}
