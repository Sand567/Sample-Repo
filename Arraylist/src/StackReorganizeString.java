//import java.util.Stack;
//
///**
// * Created by Sharath Nagendra on 8/28/2018.
// */
//public class StackReorganizeString {
//
//    public static void  main(String[] args){
//
//        String input = "aaab";
//        System.out.println(reorganizeHelper(input));
//    }
//
//    static String reorganizeHelper(String str){
//
//        Stack<Character> s = new Stack<>();
//
//        StringBuilder sb = new StringBuilder();
//        if(str.isEmpty())
//            return str;
//
//        for(int i=0;i<str.length();i++){
//            if(s.isEmpty()){
//                int count=0;
//                s.push(str.charAt(i));
//                count+=1;
//            }
//            else
//            {
//                if(!s.isEmpty() && str.charAt(i) == s.peek() && count<=2)
//                {
//                    count+=1;
//                    s.push(str.charAt(i));
//
//                }
//                else if(!s.isEmpty() && str.charAt(i)!=s.peek()){
//
//                    s.push(str.charAt(i));
//                }
//
//
////                else{
////                    if(s.peek()==str.charAt(i)){
////                        return " ";
////                    }
////                    else if(flag == true && s.peek()!=str.charAt(i)){
////
////                        char c = s.pop();
////                        s.push(str.charAt(i));
////                        s.push(c);
////                    }
////
////                }
//            }
//
//
//        }
//        while(!s.isEmpty()){
//            sb.append(s.pop());
//        }
//        return sb.reverse().toString();
//    }
//}
