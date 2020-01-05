/**
 * Created by Sharath Nagendra on 11/28/2017.
 */
public class summm {
    public static void main(String[] args) {

        int a[] = {4, 7, 8, 3, 1,0};


        int target = 5;

        int i=0,j=0,k;
        while(j<a.length){

            if(a[j]>=target){
                j++;
            }

            else if(a[j]<target)
            {
                k=j;
                while(i<k)
                {
                    int temp = a[k];
                    a[k]=a[k-1];
                    a[k-1]=temp;
                    k--;
//                    swap(a[k],a[k-1]);

                }

                j++;
                i++;

            }

        }
        for(int p:a)
            System.out.println(p);

    }
}






