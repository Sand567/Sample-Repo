import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 11/11/2017.
 */
public class stackUsingArraylist {
    static ArrayList<Integer> list = new ArrayList();

    public static void push(int data) {
        list.add(data);
    }

    public static Integer pop() {

        if(list.isEmpty())
            throw new EmptyStackException();
        return list.remove(list.size()-1);

    }

    public static Integer peek(){

        return list.get(list.size()-1);
    }


    public static void main(String[] args) {

        push(10);
        push(20);
        push(30);
        push(40);
        push(50);
        push(60);

        System.out.println(peek());

        System.out.println(pop());

       // System.out.println(peek());



    }
    }

