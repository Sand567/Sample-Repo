import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 10/29/2017.
 */
public class swap {
    public static void main(String ar[]){
//        Scanner in = new Scanner(System.in);
//        String s = in.next();
//        System.out.println(new StringBuffer(s.substring(0,2)).reverse().toString().concat(s.substring(2)));

        String[] str1 = { "cdab", "dcba"};
        String[] str2 = { "abcd", "abcd" };
     //
        //   String[] str3 = { "Crunchify", "dot", "com" };


        if(str1.length!=str2.length){
            System.out.println("NO");
        }

        String newstr1 = str1[0];
        String newstr2 = str1[1];


        char[] c =str1[0].toCharArray();

        for(int i=0;i<c.length;i++)
            System.out.println(str1.toString().charAt(i));
        char temp=' ';
//        for(int x=0;x<str1[0].length;x++)
//        {
//            if(x%2==0)
//            {
//                System.out.println(str1[x].charAt(x));
//            }
//                temp=str1[x].charAt(x+2);
//        }
      //  System.out.println(temp);

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        scan.nextLine();
        for (int i = 0; i <= T; i++) {
            String myString = scan.nextLine();
            String even = "";
            String odd = "";
            for (int j = 0; j < myString.length(); j++) {
                if (j % 2 == 0) {
                 //   String str2 = swap(myString,p,i);

                  //  myString.charAt(j)=myString.charAt(j%2);
                //    System.out.println(myString.charAt(j));
                    //char temp2 = myString.charAt(j++);
                    myString = myString.replace(myString.charAt(j),myString.charAt(j%2));
               //     myString = myString.replace(myString.charAt(j%2),temp);
//                    myString.charAt()=myString.charAt(j);

                    //even += myString.charAt(j%4);
                } else{
                    odd += myString.charAt(j);
                }
            }
            String res = even;

          //  System.out.println(myString);
        }
    }
//    public static String swap(String str, int p, int i)
//
//    {
//
//
//        str.charAt(p) = str.charAt(i);
//
//        return str;
//
//    }

}
