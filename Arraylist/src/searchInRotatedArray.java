/**
 * Created by Sharath Nagendra on 12/12/2017.
 */
public class searchInRotatedArray {

    public static int findKey(int[] arr,int key){

        int low=0;
        int high = arr.length-1;

        while(low<=high){
           int  mid=(low+high)/2;
            if(key==arr[mid])
            return mid;
            if(arr[low]<=arr[mid] && key<=arr[mid] && key>= arr[low]){
                high=mid-1;
            }
            else if(arr[high]<=arr[mid] && key<=arr[high] && key>=arr[mid]){
                low=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findKey(arr,0));
    }
}
