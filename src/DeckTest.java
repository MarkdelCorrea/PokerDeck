public class DeckTest {

    public static void main(String args[] ) {
        Deck baraja = new Deck();

        System.out.printf("Cartas en la baraja: %d%n", baraja.size());

        for (int i=0; i < 5; i++) {
            Card c = baraja.draw();
            System.out.println( c);
        }

        System.out.printf("Cartas en la baraja: %d%n", baraja.size());

        baraja.shuffle();

        for (int i=0; i < 5; i++) {
            Card c = baraja.draw();
            System.out.println( c);
        }
        System.out.printf("Cartas en la baraja: %d%n", baraja.size());

    }
}
