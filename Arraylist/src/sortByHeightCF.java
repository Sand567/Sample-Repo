import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Sharath Nagendra on 1/24/2018.
 */
public class sortByHeightCF {

    static int[] sortByHeight(int[] a) {
        if(a.length==0)
            return null;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<a.length;i++)
        {

                list.add(a[i]);

        }
        Collections.sort(list);
        System.out.println(list);

        //150 160 170 180 190
        // -1 150 190 170 -1 -1 160 180
        for(int i=0;i<list.size();i++){
            if(a[i] == -1)
                continue;
            else
                a[i]=list.get(i);
        }
        return a;

    }


    public static void main(String[] args) {
        int[] a= {-1, 150, 190, 170, -1, -1, 160, 180};
        int[] res = sortByHeight(a);
        for(int i:res)
            System.out.println(i);
    }
}
