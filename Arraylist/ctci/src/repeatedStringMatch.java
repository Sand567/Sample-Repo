/**
 * Created by Sharath Nagendra on 11/13/2017.
 */
public class repeatedStringMatch {

    public static int stringMatch(String a,String b){

        StringBuilder sb = new StringBuilder();
        sb.append(a);
        int count=1;
        while(sb.indexOf(b)<0){
            sb.append(a);
            if(sb.length()>b.length() && sb.indexOf(b)<0){
                return -1;
            }
            else
                count++;
        }
        return count;
    }


    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";

        System.out.println(stringMatch(a,b));
    }
}
