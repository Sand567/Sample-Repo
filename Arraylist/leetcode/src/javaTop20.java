import java.util.*;
import java.util.Stack;

/**
 * Created by Sharath Nagendra on 5/18/2018.
 */
public class javaTop20 {


    //How to Print duplicate characters from String?
    //check without dup, null, empty etc
    public static void printDuplicate(String s) {

        if (s.length() == 0) {
            System.out.println("empty string");
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> mentry : map.entrySet()) {
            if (mentry.getValue() > 1) {
                System.out.println(mentry.getKey());
            }
        }

    }


    public static void maxCount(String s) {

        if (s.length() == 0) {
            System.out.println("empty string");
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int maxVal = Collections.max(map.values());
        System.out.println(maxVal);
        for (Map.Entry<Character, Integer> mentry : map.entrySet()) {
            if (mentry.getValue() == maxVal)
                System.out.println(mentry.getKey());
        }

    }

    //check anagram
    static void checkAnagram(String res, String top) {

        if (res.length() != top.length()) {
            System.out.println("Not an anagram");
        } else {
            int[] arr = new int[26];
            int[] arr2 = new int[26];

            for (int i = 0; i < res.length(); i++) {
                arr[res.charAt(i) - 'a']++;
            }

            for (int i = 0; i < top.length(); i++) {
                arr[top.charAt(i) - 'a']--;
            }

            for (int i : arr) {
                if (i == 0) {
//                    System.out.println("not anagram");
//                    break;

                } else {
                    System.out.println("not anagram");
                    break;
                }


            }
            //System.out.println("anagram");
            // System.out.println(Arrays.equals(arr,arr2));
        }
    }

    static void printFirstUnique(String res) {
        if (res.isEmpty()) {
            System.out.println("String empty");

        } else {
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < res.length(); i++) {
                if (map.containsKey(res.charAt(i))) {
                    map.put(res.charAt(i), map.get(res.charAt(i)) + 1);

                } else {
                    map.put(res.charAt(i), 1);
                }
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    System.out.println(entry.getKey());
                    break;
                }
            }


        }
    }

    //reverse string Iteration
    static void reverseStringIteration(String res) {


        //using extra space o(n) time
//        StringBuilder sb = new StringBuilder();
//        for(int i=res.length()-1;i>=0;i--){
//            sb.append(res.charAt(i));
//        }
//        System.out.println(sb.toString());

        char[] ch = new char[res.length()];
        int j = 0;
        for (int i = res.length() - 1; i >= 0; i--) {
            ch[j] = res.charAt(i);
            j++;
        }

        for (char i : ch) {
            System.out.print(i);
        }

    }

    static String reverseStringRecursion(String res) {
        if (res.length() < 2) {
            return res;
        }

      //  String cap = res.substring(1) + res.charAt(0);
        //  System.out.println("This is cap------- "+cap);
        return reverseStringRecursion(res.substring(1)) + res.charAt(0);
    }

    //Java,a

    //Jv
    static String removeChars(String s, char c) {
        if (s.isEmpty())
            return null;
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == c) {
                sb.deleteCharAt(i);
            }

        }
        return sb.toString();

        //   Map.Entry<Character, Integer> entry = map.entrySet();
//        if(map.containsKey(c)){
//      //      entry.remove(c);
//            map.remove(c);
//            return map.toString();
//
//
//
//        }
//       return null;

    }

    public static class QQueue {
        Stack<Integer> stackNew = new Stack<>();

        Stack<Integer> stackOld = new Stack<>();


        public void enqueue(int val) {

            stackNew.push(val);

        }

        public int dequeue() {

            prep();
            return stackOld.pop();

        }

        public int peek() {
            prep();
            return stackOld.peek();

        }

        public void prep() {
            if (stackOld.isEmpty())
                while (!stackNew.isEmpty())
                    stackOld.push(stackNew.pop());
        }

    }


    //stack using 2 queues
    public static class stackUsingQueue {
        Queue<Integer> q = new LinkedList<>();

        public void push(int val) {
        int size = q.size();
        q.add(val);


        for(int i=0;i<size;i++)
        {
            int x = q.remove();
            q.add(x);
        }

    }

    public int pop() {
    if(q.isEmpty())
        return -1;
    return q.remove();
    }

    public  int peek() {
    if(q.isEmpty())
        return -1;
    return q.peek();
    }

    }

    public static void main(String[] args) {
        String res = "java";
        String top = "caravan";
        //printDuplicate(res);

        //checkAnagram(res, top);

        //printFirstUnique(res);

        //reverseStringIteration(top);
         System.out.println(reverseStringRecursion(res));

        // maxCount("aabcdda");
        // System.out.println(removeChars("java",'a'));

//        QQueue queue = new QQueue();
//        queue.enqueue(10);
//        queue.enqueue(20);
//        System.out.println(queue.peek());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.peek());

        stackUsingQueue stack = new stackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }


}
