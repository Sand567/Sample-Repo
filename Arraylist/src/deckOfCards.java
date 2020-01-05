/**
 * Created by Sharath Nagendra on 10/17/2017.
 */
public class deckOfCards {

    public static void main(String[] args) {

        String[] suit ={"c","d","s","h"};
        String[] rank={"1","2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] deck = new String[52];

        //initialize deck of cards
        for(int i=0;i<deck.length;i++){
            deck[i]=rank[i%13]+suit[i%4];
           // System.out.println(deck[i]);
        }

        //shuffle deck of cards
        for(int i=0;i<deck.length;i++)
        {
            int index = (int) Math.random()*deck.length;

            String temp =deck[i];
            deck[i]=deck[index];
            deck[index]=temp;

        }

        //print deck
        for(int i=0;i<deck.length;i++)
            System.out.println(deck[i]);
    }
}
