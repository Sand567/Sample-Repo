import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 7/6/2017.
 */
public class Checker implements Comparator<Checker.Player> {


    public int compare(Player p1, Player p2) {
        //multiple line comparison
        if (p1.score == p2.score) {
            return p1.name.compareTo(p2.name);
        } else
            return p2.score - p1.score;


        //-------------------------------------solution using compareTo

          /* return ((Integer) p2.score).compareTo(p1.score);*/


        //------------------------------------single line code for comparison(ternary operator)

        /* return p1.score!=p2.score? (p2.score-p1.score):p1.name.compareTo(p2.name);*/
    }

    static class Player {

        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
        //Collections.reverse(Arrays.asList(player));
        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
