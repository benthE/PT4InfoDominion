package model;

import java.util.ArrayList;

/**
 * Created by steward on 26/02/14.
 */
public class PaketDiscard extends Paket{


    public void addCard(Card c) {
        myCards.add(c);
    }

    public PaketDiscard() {
        super();
        System.out.println("Constructor HeapDiscard()");
    }

    public String toString(){
        for (Card c: myCards){
            return c.getName();
        }
        return "Aucun résultat";
    }
}
