import java.util.ArrayList;
import java.util.Collections;

public class CardTest {

    public static void main(String args[] ) {

        ArrayList<Card> hand = new ArrayList<>();

        for (int i=0; i < 5; i++) {
            Card c = Card.getCard();
           hand.add(c);
        }

        System.out.println( hand );

        Card min = Collections.min(hand);
        Card max = Collections.max(hand);


        System.out.println( min );
        System.out.println( max );

        Collections.sort( hand );

        System.out.println( hand );
    }
}
