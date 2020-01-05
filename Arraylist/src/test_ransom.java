import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 7/1/2017.
 */
public class test_ransom {


    public static void checkforsum(int[] arr) {
        Arrays.sort(arr);
        boolean found = false;
        for (int i = 0; i < arr.length -1; i++) {
            int l = i + 1;
            int r = arr.length - 1;
            while (l < r) {
                if (arr[l] + arr[r] + arr[i] == 0) {
                    System.out.println(arr[l] + "," + arr[r] + "," + arr[i]);
                    l++;
                    r--;
                    found=true;
                } else if (arr[l] + arr[r] + arr[i] < 0)
                    l++;
                else
                    r--;
//                else
//                    System.out.println("triplet not found");
            }
        }
        if(found==false)
            System.out.println("no triplet found");
    }

    public static void main(String[] args) {


        int[] arr = {-1 ,0 ,1 ,2, -1, -4};
        checkforsum(arr);
        int j = 0;
        String[] s = {"hello"};
        //   stringsum(s);
        for (int x = 0; x < s.length; x++)
            System.out.println(s[x]);
        //System.out.println(s);
        sumup(j);
        // System.out.println(j);
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            ransom[ransom_i] = in.next();
        }
        System.out.println(construct(magazine, ransom));
    }

    public static void stringsum(String[] s) {
        s[0] = s[0] + "hello";
    }

    public static void sumup(int j) {
        j = j + 1;
    }

    public static boolean construct(String[] magazine, String[] ransom) {

        String magazineString = Arrays.toString(magazine);
        String ransomString = Arrays.toString(ransom);

        int[] af = new int[256];
        int ops = 0;
        for (int i = 0; i < magazineString.length(); ++i) {

            af[magazineString.charAt(i) - 'a']++;
            //   System.out.println(af[i]);
        }
        for (int i = 0; i < ransomString.length(); ++i) {
            if (af[magazineString.charAt(i) - 'a']-- < 0)
                return false;
        }
        return true;
    }


}

