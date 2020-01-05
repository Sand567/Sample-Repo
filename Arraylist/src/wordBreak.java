/**
 * Created by Sharath Nagendra on 2/23/2018.
 */
public class wordBreak {

    static String res = "";

        static boolean dictionaryContains(String word)
    {
        String dictionary[] = {"a","quick","brown","fox","bro"};
        int size = dictionary.length;
        for (int i = 0; i < size; i++)
            if (dictionary[i].compareTo(word) == 0) {

                return true;
            }
        return false;
    }

    // returns true if string can be segmented into space
// separated words, otherwise returns false
    static boolean wordBreak(String str)
    {

        int size = str.length();

        // Base case
        if (size == 0) return true;

        // Try all prefixes of lengths from 1 to size
        for (int i=1; i<=size; i++)
        {
            // The parameter for dictionaryContains is
            // str.substr(0, i) which is prefix (of input
            // string) of length 'i'. We first check whether
            // current prefix is in dictionary. Then we
            // recursively check for remaining string
            // str.substr(i, size-i) which is suffix of
            // length size-i
            if (dictionaryContains( str.substring(0, i) ) &&
                    wordBreak( str.substring(i) )) {
                return true;
            }

        }

        // If we have tried all prefixes and
        // none of them worked
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("aquickbrownfox"));
        System.out.println(res);

//        wordBreak("");
//        wordBreak("ilikelikeimangoiii");
//        wordBreak("samsungandmango");
//        wordBreak("samsungandmangok");
    }

}
