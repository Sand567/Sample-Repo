import java.util.Scanner;
import java.util.Stack;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * Created by Sharath Nagendra on 7/2/2017.
 */
public class queue_using_2_stacks

{
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack

            if(stackNewestOnTop.size() ==0)
                stackNewestOnTop.push(value);
            else
            {
                int l = stackNewestOnTop.size();
                for (int i = 0; i < l; i++)
                    stackOldestOnTop.push(stackNewestOnTop.pop());
            /* push the new element to stack s */
                stackNewestOnTop.push(value);
            /* pop all elements from stack tmp and
             * push them to stack s */
                for (int i = 0; i < l; i++)
                    stackNewestOnTop.push(stackOldestOnTop.pop());
            }
            }



        public T peek() {
        if(stackNewestOnTop.size() ==0)
            throw new NoSuchElementException("StackUnderflow");
           return stackNewestOnTop.peek();
        }

        public T dequeue() {
            if(stackNewestOnTop.size()==0)
                throw new NoSuchElementException();
            return stackNewestOnTop.pop();
        }
    }



    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
