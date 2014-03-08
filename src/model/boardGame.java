package model;

import java.util.ArrayList;
import java.util.HashMap;

public class boardGame {

	private ArrayList<Player> myPlayers=null;
	private HashMap<Integer, PaketBoard> myCards=null;
    private HashMap<Card, Integer> buyableCards=null;
	private int nbRound;
	
	
	public boardGame() {
		nbRound = 0;
	}

	public void initPlayers(){
		myPlayers = new ArrayList<Player>();
		myPlayers.add(new Player(0));
		myPlayers.get(0).updateCards();
        buyableCards = new HashMap<Card, Integer>();
	}
	
	public void initCards(){
		
		myCards = new HashMap<Integer,PaketBoard>();

		/** 
		 * Initialisation des 10 cartes Actions selon le premier groupe d�fini
		 */
		myCards.put(0,new PaketBoard(new CardAction("Atelier", 3, TypeAction.BASE, 0, 1, 4, 0),10));
	    myCards.put(1,new PaketBoard(new CardAction("Bucheron", 3, TypeAction.BASE, 0, 1, 2, 0),10));
	    myCards.put(2,new PaketBoard(new CardAction("Cave", 2, TypeAction.BASE, 1, 0, 0, 0),10));
	    myCards.put(3,new PaketBoard(new CardAction("Douves", 2, TypeAction.REACTION, 0, 0, 0, 2),10));
	    myCards.put(4,new PaketBoard(new CardAction("Forgeron", 4, TypeAction.BASE, 0, 0, 0, 3),10));
	    myCards.put(5,new PaketBoard(new CardAction("Marche", 5, TypeAction.BASE, 1, 1, 1, 1),10));
	    myCards.put(6,new PaketBoard(new CardAction("Milice", 4, TypeAction.ATTAQUE, 0, 0, 2, 0),10));
	    myCards.put(7,new PaketBoard(new CardAction("Mine", 5, TypeAction.BASE, 0, 0, 0, 0),10));
	    myCards.put(8,new PaketBoard(new CardAction("R�novation", 4, TypeAction.BASE, 0, 0, 0, 0),10));
	    myCards.put(9,new PaketBoard(new CardAction("Village", 3, TypeAction.BASE, 2, 0, 0, 2),10));
	    
	    /**
		 * Initialisation des cartes Tresor et Victoire du d�but
		 */
		myCards.put(10,new PaketBoard(new CardVictory(),10));
		myCards.put(11,new PaketBoard(new CardVictory("Duche",5,3,false),10));
		myCards.put(12,new PaketBoard(new CardVictory("Province",8,6,false),12));
		myCards.put(13,new PaketBoard(new CardVictory("Mal�diction",0,-1,false),10));
		myCards.put(14,new PaketBoard(new CardTreasure(TypeTreasure.COPPER),10));
		myCards.put(15,new PaketBoard(new CardTreasure(TypeTreasure.SILVER),10));
		myCards.put(16,new PaketBoard(new CardTreasure(TypeTreasure.GOLD),10));

        /**
         * On ajoute les cartes que le joueur peut acheter
         */
        buyableCards.put(new CardAction("Atelier", 3, TypeAction.BASE, 0, 1, 4, 0),10);
        buyableCards.put(new CardAction("Bucheron", 3, TypeAction.BASE, 0, 1, 2, 0),10);
        buyableCards.put(new CardAction("Cave", 2, TypeAction.BASE, 1, 0, 0, 0),10);
        buyableCards.put(new CardAction("Douves", 2, TypeAction.REACTION, 0, 0, 0, 2),10);
        buyableCards.put(new CardAction("Forgeron", 4, TypeAction.BASE, 0, 0, 0, 3),10);
        buyableCards.put(new CardAction("Marche", 5, TypeAction.BASE, 1, 1, 1, 1),10);
        buyableCards.put(new CardAction("Milice", 4, TypeAction.ATTAQUE, 0, 0, 2, 0),10);
        buyableCards.put(new CardAction("Mine", 5, TypeAction.BASE, 0, 0, 0, 0),10);
        buyableCards.put(new CardAction("Renovation", 4, TypeAction.BASE, 0, 0, 0, 0),10);
        buyableCards.put(new CardAction("Village", 3, TypeAction.BASE, 2, 0, 0, 2), 10);
        buyableCards.put(new CardAction("Festin", 4, TypeAction.ECART, 0, 0, 5, 0), 10);
        buyableCards.put(new CardAction("Festival", 5, TypeAction.BASE, 2, 1, 2, 0), 10);
        buyableCards.put(new CardTreasure(TypeTreasure.SILVER), 10);
        buyableCards.put(new CardTreasure(TypeTreasure.GOLD), 10);

    }
	
	public static void main(String[] args) {
		boardGame bG = new boardGame();
		bG.initPlayers();
		bG.initCards();
		System.out.println(bG.myPlayers.toString());

	}

	/**
	 * @return the myPlayers
	 */
	public ArrayList<Player> getMyPlayers() {
		return myPlayers;
	}

	/**
	 * @param myPlayers the myPlayers to set
	 */
	public void setMyPlayers(ArrayList<Player> myPlayers) {
		this.myPlayers = myPlayers;
	}

	/**
	 * @return the myCards
	 */
	public HashMap<Integer, PaketBoard> getMyCards() {
		return myCards;
	}

	/**
	 * @param myCards the myCards to set
	 */
	public void setMyCards(HashMap<Integer, PaketBoard> myCards) {
		this.myCards = myCards;
	}

	/**
	 * @return the nbRound
	 */
	public int getNbRound() {
		return nbRound;
	}

	/**
	 * @param nbRound the nbRound to set
	 */
	public void setNbRound(int nbRound) {
		this.nbRound = nbRound;
	}

    public HashMap<Card, Integer> getBuyableCards() {
        return buyableCards;
    }

    public void setBuyableCards(HashMap<Card, Integer> buyableCards) {
        this.buyableCards = buyableCards;
    }

}
