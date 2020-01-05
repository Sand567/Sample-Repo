/**
 * Created by Sharath Nagendra on 11/21/2017.
 */
public class containerWithMaxWater {

    public static int maxArea(int[] a){
        int left =0;
        int maxArea=0;
        int right = a.length-1;
        while(left<right){
            maxArea = Math.max(maxArea,Math.min(a[left],a[right])*(right-left));
            if(a[left]<a[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] a = {2, 3, 1, 4, 1, 5, 6};
        int[] b ={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(b));
    }
}
