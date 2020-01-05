/**
 * Created by Sharath Nagendra on 1/22/2018.
 */
public class switchCase {

    public static void main(String[] args) {


        char grade = 'B';
        final char a = 'A';
       final  char d = 'D';
        switch (grade) {
            case a:
            case 'B':
                System.out.println("great");
            case 'C':
                System.out.println("good");
                break;
            case d:
                System.out.println("bad");
        }

    }
}
