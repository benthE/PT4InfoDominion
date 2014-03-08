package model;

import java.util.*;

/**
 * Created by souadi on 19/02/14.
 */
public class IAEngine extends Player {
    ;
    private boardGame BG = null;

    public IAEngine(){
        BG = new boardGame();
    }

    public IAEngine(boardGame BG) {
        this.BG = new boardGame();
        this.BG = BG;

    }

    public void buyCardEngine() {
        Set set = BG.getBuyableCards().entrySet();
        Iterator i = set.iterator();
        while (i.hasNext() && getMyPoints().getPMoney() >= 1 && !getMyPoints().isEndBuy()) {
            Map.Entry<Card, Integer> me = (Map.Entry) i.next();

            //Cartes qui donnnent 2 actions en plus
            if ((me.getKey().getName() == "Festival" || me.getKey().getName() == "Village") && me.getValue() != 0 && getMyPoints().getPMoney() >= me.getKey().getPrice()) {
                System.out.println("1");
                System.out.println(me.getKey().getName() + " ");
                setMyBuy(getMyBuy()-1);
                System.out.println("hand : " + getMyHand().toString() +" ; " + "deck : "+ getMyDeck().toString());
//                DiscardBuyCard(me.getKey(), );
                me.setValue(me.getValue()-1);
//                System.out.println("discard : " + .getMyDiscardC().toString());

            }
            if (me.getKey().getMyTypeAction() == TypeAction.ECART && me.getValue() != 0 && getMyPoints().getPMoney() >= me.getKey().getPrice()) {
                System.out.println("2");
                System.out.println(me.getKey().getName() + " ");
            }
            if (me.getKey().getName() == "Aventurier" && me.getValue() != 0 && getMyPoints().getPMoney() >= me.getKey().getPrice()) {
                System.out.println("3");
                System.out.println(me.getKey().getName() + " ");
            }
            if (me.getKey().getName() == "Bucheron" && me.getValue() != 0 && getMyPoints().getPMoney() >= me.getKey().getPrice()) {
                System.out.println("4");
                System.out.println(me.getKey().getName() + " ");
            }
            if (me.getKey().getName() == "ChambreDuConseil" && me.getValue() != 0 && getMyPoints().getPMoney() >= me.getKey().getPrice()) {
                System.out.println("5");
                System.out.println(me.getKey().getName() + " ");
            }
            if (me.getKey().getName() == "Forgeron" && me.getValue() != 0 && getMyPoints().getPMoney() >= me.getKey().getPrice()) {
                System.out.println("6");
                System.out.println(me.getKey().getName() + " ");
            }
            if (me.getKey().getName() == "Or" && me.getValue() != 0 && getMyPoints().getPMoney() >= me.getKey().getPrice()) {
                System.out.println("7");
                System.out.println(me.getKey().getName() + " ");
            }
            if (me.getKey().getName() == "Argent" && me.getValue() != 0 && getMyPoints().getPMoney() >= me.getKey().getPrice()) {
                System.out.println("8");
                System.out.println(me.getKey().getName() + " ");
            }


            /*System.out.println(me.getKey().getName() + ": ");
            System.out.println(me.getValue());*/

        }
    }

    private void DiscardBuyCard(Card buyCard, Player p) {
//        p.addDiscardCard(buyCard);
    }

}
