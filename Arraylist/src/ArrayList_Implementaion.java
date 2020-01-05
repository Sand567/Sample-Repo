import java.util.Arrays;

/**
 * Created by Sharath Nagendra on 10/21/2018.
 */
public class ArrayList_Implementaion<Integer> {

    int capacity = 10;
     int size = 0;
    static Object[] arr;

    ArrayList_Implementaion() {
        arr = new Object[capacity];
    }
     void add(int num) {
        if (size == arr.length){
            increaseCapacity();
        }

        else {
        arr[size++] = num;
        }

    }
    private static void increaseCapacity(){
        int newcap = arr.length*2;
        arr =  Arrays.copyOf(arr,newcap);
    }

     int get(int i){
        if(i<0 || i>=size){
            throw new IndexOutOfBoundsException();
        }
        return (int) arr[i];
    }

    public static void main(String[] args) {
        ArrayList_Implementaion list = new ArrayList_Implementaion();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(3));

    }
}
