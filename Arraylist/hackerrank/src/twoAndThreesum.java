import java.util.Arrays;

/**
 * Created by Sharath Nagendra on 11/5/2017.
 */
public class twoAndThreesum {


    public static int findMinimum(int[] arr1, int[] aar2) {


        int n = arr1.length;
        int m = aar2.length;
        Arrays.sort(arr1);
        Arrays.sort(aar2);
        int i = 0;
        for (int k = 0; k < n; k++) {
            while (i < m - 1 && aar2[i] < arr1[k])
                i += 1;
            if (arr1[k] == aar2[i])
                return arr1[k];
        }
        return -1;
    }

    public static int findmin(int[] arr1,int[] arr2){

        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr2.length;j++)
            {
                if(arr1[i]==arr2[j])
                    return arr1[i];
            }
        }return -1;

    }

    public static void main(String[] args) {
        int[] arr1 = {2,1};
        int[] aar2 = {3, 3,1,2};
//        Arrays.sort(arr1);
//        Arrays.sort(aar2);
        //System.out.println(findmin(arr1,aar2));
//        Employee nub1 = new Employee ("Griffin", "Peter", 000001);
//        System.out.println(nub1);
//        Employee nub2 = new Employee ("Griffin", "Lois", 000002);
//        System.out.println(nub2);
//        Employee nub3 = new Employee ("Griffin", "Stewie", 000003);
//        System.out.println(nub3);x
//        Employee nub4 = new Employee ("Griffin", "Brian", 000004);
//        System.out.println(nub4);
//        System.out.println(nub1.empStat());

        //Random random = new Random();
//        int number = 10;
//        String randoms = String.format("%03d", number);
//        System.out.println(randoms);

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please Enter your name");
//        String name = scanner.nextLine();
//        name = name.substring(name.indexOf(" ")+1, name.length())+" "+name.substring(0, name.indexOf(" "));
//        System.out.println(name);



        System.out.println(findMinimum(arr1, aar2));  // 1





        // findMinimum([3, 5, 7, 9], [1, 2, 4, 7, 10]);
    }

}
