import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Sharath Nagendra on 7/2/2017.
 */
public class balanced_brackets {
    static int count=0;
    public static boolean isBalanced(String expression) {
       Stack<Character> s  = new Stack<Character>();
       Queue<Character> q = new LinkedList<>();
       // stack<char> s;
        for (char c : expression.toCharArray()) {
            if      (c == '{') s.push('}');
            else if (c == '[') s.push(']');
            else if (c == '(') s.push(')');
            else {
                if (!s.empty() || c != s.peek()) {
                //    System.out.println(count++);
                    q.add(s.peek());
                    System.out.println(q.peek());

//                    System.out.println(s.peek());
                    //return false;
                }
                s.pop();
            }
        }
        return s.empty();

//        char[] c = expression.toCharArray();
//        for (int i = 0; i < c.length; i++) {
//            if (c[i] == '{' || c[i] == '[' || c[i] == '(') {
//                s.push(c[i]);
//            }
//
//            else if (c[i] == ')') {
//               if(s.isEmpty())
//                   return false;
//               if(s.pop() !='(')
//                   return false;
//            }
//            else if (c[i] == '}') {
//                if(s.isEmpty())
//                    return false;
//                if(s.pop() !='{')
//                    return false;
//            }
//
//            if (c[i] == ']') {
//                if(s.isEmpty())
//                    return false;
//                if(s.pop() !='[')
//                    return false;
//            }
//
////            if (s.size() == 0) {
////                return false;
////            }
//
//
//        }
//        return true;
    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int a0 = 0; a0 < t; a0++) {
//            String expression = in.next();
            System.out.println( (isBalanced("{([]}")) ? "YES" : "NO" );
            //System.out.println(count);
        }
    }

