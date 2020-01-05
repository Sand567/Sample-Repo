import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharath Nagendra on 9/7/2018.
 */
public class permIntegerArray {

//    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        permute(num, 0, result);
//        return result;
//    }
//
//    static void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
//
//        if (start >= num.length) {
//            ArrayList<Integer> item = convertArrayToList(num);
//            result.add(item);
//        }
//
//        for (int j = start; j <= num.length - 1; j++) {
//            swap(num, start, j);
//            permute(num, start + 1, result);
//            swap(num, start, j);
//        }
//    }
//
//    static private ArrayList<Integer> convertArrayToList(int[] num) {
//        ArrayList<Integer> item = new ArrayList<Integer>();
//        for (int h = 0; h < num.length; h++) {
//            item.add(num[h]);
//        }
//        return item;
//    }
//
//    static private void swap(int[] a, int i, int j) {
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        List<Integer> result = new ArrayList<>();
        dfs(nums, results, result);
        return results;
    }

    public static void dfs(int[] nums, List<List<Integer>> results, List<Integer> result) {
        if (nums.length == result.size()) {
            List<Integer> temp = new ArrayList<>(result);
            results.add(temp);
        }
        for (int i=0; i<nums.length; i++) {
            if (!result.contains(nums[i])) {
                result.add(nums[i]);
                dfs(nums, results, result);
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }


}
