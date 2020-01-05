import java.util.Arrays;
/**
 * Created by Sharath Nagendra on 6/27/2017.
 */
public class anagram {


    public static void main(String[] args) {
        String word = "car";
        String anagram = "arc";
        if(checkanagram(word,anagram)==true){
            System.out.println("op from stringbuilder method ===============anagram");
        }
        else
            System.out.println("op from string builder methiod==============not an anagram");
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);



         if(Arrays.equals(charFromWord, charFromAnagram) == true)
             System.out.println(word+"\t and \t"+anagram+"\t are anagrams");
         else
             System.out.println("not anagrams");


    }

    private static boolean checkanagram(String word, String anagram) {
        char[] characters = word.toCharArray();
        StringBuilder sbSecond = new StringBuilder(anagram);
        for(char ch : characters){
            int index = sbSecond.indexOf("" + ch);
            if(index != -1)
            { sbSecond.deleteCharAt(index);
            }
            else
                { return false;
                }
        } return sbSecond.length()==0 ? true : false;
    }



    }





