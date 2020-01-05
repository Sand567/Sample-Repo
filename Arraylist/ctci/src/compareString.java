/**
 * Created by Sharath Nagendra on 11/2/2017.
 */
public class compareString {


    public static boolean oneEdit(String a, String b){
        if(a.length()==b.length()) {
            return oneReplace(a, b);
        }
        else if(a.length()+1==b.length())
            return oneInsertEdit(a,b);
        else if(a.length()-1==b.length())
            return oneInsertEdit(b,a);
        return false;
    }

    public static boolean oneInsertEdit(String a,String b){
        int index1=0;
        int index2=0;
        while(index2<b.length() && index1<a.length()){
            if(a.charAt(index1) != b.charAt(index2)){
                if(index1 !=index2){
                    return false;
                }
                index2++;

            }
            else{
                index1++;
                index2++;
                }
        }
        return true;
    }


    public static boolean oneReplace(String a,String b){
        boolean foundDifference = false;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)!=b.charAt(i)){
                if(foundDifference){
                    return false;
                }
                foundDifference=true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String a = "pale";
        String b = "bae";

        System.out.println(oneEdit(a,b));
    }
}
