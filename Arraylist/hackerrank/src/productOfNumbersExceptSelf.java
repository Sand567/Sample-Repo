/**
 * Created by Sharath Nagendra on 10/4/2017.
 */
public class productOfNumbersExceptSelf {


    static int[] findProduct(int[] arr){
        int[] pre = new int[arr.length];
        int[] after = new int[arr.length];
        int[] prod = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
        pre[i]=1;
        after[i]=1;
        }
        for(int i=1;i<arr.length;i++){
            pre[i] = pre[i-1]*arr[i-1];
        }

        for(int i=arr.length-2;i>=0;i--)
        {
            after[i]=after[i+1]*arr[i+1];
        }

        for(int i=0;i<arr.length;i++)
        {
            prod[i] = pre[i]*after[i];
        }
        return prod;
//        res[0]=1;
//        int n= arr.length;
//        for(int i=1;i<n;i++)
//        {
//            res[i] = res[i-1]*arr[i-1];
//        }
//        int right=1;
//        for(int j=n-1;j>0;j--){
//                res[j]=res[j]*right;
//                right =right *arr[j];
//        }


    }

    //j=4//res[4] =res[4]*1//24*1=24 //right =4
    //j=3//res[3] =res[3]*4//6*4=24 //right=24
    //j=2//res[2] =res[2]*24//2*24


    //i=0//res 0 n n n
    //i=1//res[1] = res[0]*arr[0] (1*1)=1
    //i=2//res[2] = res[1]*arr[1] (1*2)=2
    //i=3//res[3] = res[2]*arr[2] (2*3)=6
    //i=4//res[4] = res[3]*arr[3] (6*4)=24

    //1 2 6 24


    static int[] prodExcept(int[] nums){
        int[] result = new int[nums.length];

        result[nums.length-1]=1;
        for(int i=nums.length-2; i>=0; i--){
            result[i]=result[i+1]*nums[i+1];
        }

        int left=1;
        for(int i=0; i<nums.length; i++){
            result[i]=result[i]*left;
            left = left*nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        //int x[] = findProduct(arr);
        int[] x = prodExcept(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(x[i]);
        }

    }
}
