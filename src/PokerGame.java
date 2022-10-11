import java.util.*;

public class PokerGame {
    public static void main(String[] args) {
        Card card;

        ArrayList<Card> hand = new ArrayList<>();
        ArrayList<Card> hand2 = new ArrayList<>();

        Deck deck = new Deck();
        deck.shuffle();
        for (int i = 0; i < 5; i++) {
            card = deck.draw();
            hand.add(card);
            card = deck.draw();
            hand2.add(card);
        }

        Collections.sort( hand );
        Collections.sort( hand2 );

        System.out.println(hand);
        System.out.println("=====================");

        System.out.println(hand2);
        System.out.println("=====================");

       Double phand =  Comparar(hand);
       Double phand2 =  Comparar(hand2);

       String manoG = null;

       if (phand== 0.0 && phand2 == 0.0){
           int ph1= cartaMayor(hand);
           int ph2= cartaMayor(hand2);

           if(ph1 == ph2)
           System.out.println("ES EMPATE ");


           if (ph1>ph2){
               System.out.println("LA MANO 1 ES LA GANADORA CON " + getWin(phand));
           }else if (ph2>ph1){
               System.out.println("LA MANO 2 ES LA GANADORA CON " + getWin(phand2));
           }
       }else if (phand>phand2){

           System.out.println("LA MANO 1 ES LA GANADORA CON " + getWin(phand) );
       }else {
           System.out.println("LA MANO 2 ES LA GANADORA CON " + getWin(phand2) );
       }
    }

    public static String getWin(Double phand){
        String manoG = "";
        if (phand == 3.0)
            manoG = "Par";
        if (phand == 4.0)
            manoG = "doble par";
        if (phand == 5.0)
            manoG = "tercia";
        if (phand >= 6.0 && phand<7.0)
            manoG = "escalera";
        if (phand == 7.0)
            manoG = "color";
        if (phand == 8.0)
            manoG = "FullHouse";
        if (phand == 9.0)
            manoG = "Poker";
        if (phand >10.0)
            manoG = "Escalera Real";
        if (phand==0.0)
            manoG = "Carta mas alta";

        return manoG;
    }
    public static int cartaMayor(ArrayList<Card> hand){
        Card c1 = hand.get(0);
        Card c2 = hand.get(1);
        Card c3 = hand.get(2);
        Card c4 = hand.get(3);
        Card c5 = hand.get(4);
        int [] cartas = new int[5];

        int pCarta=0;
        int mayor = cartas[0];
        // Recorrer arreglo y ver si no es así
        // (comenzar desde el 1 porque el 0 ya lo tenemos contemplado arriba)
        for (int x = 1; x < cartas.length; x++) {
            if (cartas[x] > mayor) {
                mayor = cartas[x];
            }
        }

        pCarta = mayor;

        if (c1.getRank() == 1 || c2.getRank()==1 || c3.getRank()==1|| c4.getRank()==1||c5.getRank()==1){
                pCarta = 14;
        }

        return pCarta;
    }
    public static Double Comparar (ArrayList<Card> hand){
        //Compare 2 decks to obtain the best result
        Card c1 = hand.get(0);
        Card c2 = hand.get(1);
        Card c3 = hand.get(2);
        Card c4 = hand.get(3);
        Card c5 = hand.get(4);


        String h = "" + c1.getRank() + " " + c2.getRank()+" "+ c3.getRank()+" "+c4.getRank()+" " + c5.getRank();
        System.out.println(h);
        //the points depends of how strong is your deck to decide who will win
        Double pHand = 0.0;


        if (c1.getSuit() == c2.getSuit()&&c2.getSuit()==c3.getSuit()&&c3.getSuit()==c4.getSuit()&&c4.getSuit()==c5.getSuit()) {

            switch (h){ //color real
                case "1 2 3 4 5":
                    pHand = 10.1;
                    break;
                case "2 3 4 5 6":
                    pHand = 10.2;
                    break;
                case "3 4 5 6 7":
                    pHand = 10.3;
                    break;
                case "4 5 6 7 8":
                    pHand = 10.4;
                    break;
                case "5 6 7 8 9":
                    pHand = 10.5;
                    break;
                case "6 7 8 9 10":
                    pHand = 10.6;
                    break;
                case "7 8 9 10 11":
                    pHand = 10.7;
                    break;
                case "8 9 10 11 12":
                    pHand = 10.8;
                    break;
                case "9 10 11 12 13":
                    pHand = 10.9;
                    break;
                case "1 10 11 12 13":
                    pHand = 11.0;
                    break;
                default:
                    pHand = 7.0; // color
                    break;

            }
        } else if (c1.getRank() != c2.getRank() && c1.getRank()!= c3.getRank()&& c1.getRank()!= c4.getRank()&& c1.getRank()!= c5.getRank()&& c2.getRank() != c3.getRank() && c2.getRank()!= c4.getRank()&& c2.getRank()!= c5.getRank()&& c3.getRank()!= c4.getRank()&&c3.getRank() != c5.getRank() && c4.getRank()!= c5.getRank()){

            switch (h){ //escalera
                case "1 2 3 4 5":
                    pHand = 6.1;
                    break;
                case "2 3 4 5 6":
                    pHand = 6.2;
                    break;
                case "3 4 5 6 7":
                    pHand = 6.3;
                    break;
                case "4 5 6 7 8":
                    pHand = 6.4;
                    break;
                case "5 6 7 8 9":
                    pHand = 6.5;
                    break;
                case "6 7 8 9 10":
                    pHand = 6.6;
                    break;
                case "7 8 9 10 11":
                    pHand = 6.7;
                    break;
                case "8 9 10 11 12":
                    pHand = 6.8;
                    break;
                case "9 10 11 12 13":
                    pHand = 6.9;
                    break;
                case "1 10 11 12 13":
                    pHand = 6.99;
                    break;
                default:
                    pHand = 0.0;
                    break;

            }

        }else{


            int[] ar = {c1.getRank(), c2.getRank(), c3.getRank(), c4.getRank(), c5.getRank()};
            int [] conta = new int[5];
            int contador = 0;
            for (int i = 0; i < ar.length; i++) {
                for (int j = 0 ; j < ar.length; j++)
                    if(ar[i] == ar[j])
                        contador++;

                conta[i] = contador;
                contador = 0;
            }
            int co2 = 0, co3 = 0,co4 = 0;
            for (int i = 0; i < conta.length; i++) {
                if (conta[i]==2){
                    co2++;
                }else if (conta[i]==3){
                    co3++;
                }else if (conta[i]==4){
                    co4++;
                }
            }
            if (co2 == 2 && co3 ==1){
                pHand = 8.0;
            }else if (co2==4) {
                pHand = 4.0;
            }else if (co2==2){
                pHand = 3.0;
            }else if (co3==3){
                pHand = 5.0;
            }else if (co4==4){
                pHand = 9.0;
            }



        }
        System.out.println(pHand);
        return pHand;
    }
}
