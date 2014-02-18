package model;

import java.util.ArrayList;
import java.util.HashMap;

public class BoardGame {

	private ArrayList<Player> myPlayers=null;
	private HashMap<Integer,Card> myCards=null;
	private int nbRound;
	
	
	public BoardGame() {
		nbRound = 0;
	}

	public void initPlayers(){
		myPlayers = new ArrayList<Player>();
		myPlayers.add(new Player(0));
		myPlayers.get(0).updateCards();
	}
	
	public void initCards(){
		
		myCards = new HashMap<Integer,Card>();
		
		/**
		 * Initialisation des cartes Tresor et Victoire du début
		 */
		myCards.put(10,new CardTreasure(TypeTreasure.COPPER));
		myCards.put(10,new CardTreasure(TypeTreasure.SILVER));
		myCards.put(10,new CardTreasure(TypeTreasure.GOLD));
		myCards.put(10,new CardVictory());
		myCards.put(10,new CardVictory("Duché",5,3,false));
		myCards.put(12,new CardVictory("Province",8,6,false));
		myCards.put(10,new CardVictory("Malédiction",0,-1,false));
		
		/** 
		 * Initialisation des 10 cartes Actions selon le premier groupe défini
		 */
		myCards.put(10,new CardAction("Atelier", 3, TypeAction.BASE, 0, 1, 4, 0));
	    myCards.put(10,new CardAction("Bucheron", 3, TypeAction.BASE, 0, 1, 2, 0));
	    myCards.put(10,new CardAction("Cave", 2, TypeAction.BASE, 1, 0, 0, 0));
	    myCards.put(10,new CardAction("Douves", 2, TypeAction.REACTION, 0, 0, 0, 2));
	    myCards.put(10,new CardAction("Forgeron", 4, TypeAction.BASE, 0, 0, 0, 3));
	    myCards.put(10,new CardAction("Marché", 5, TypeAction.BASE, 1, 1, 1, 1));
	    myCards.put(10,new CardAction("Milice", 4, TypeAction.ATTAQUE, 0, 0, 2, 0));
	    myCards.put(10,new CardAction("Mine", 5, TypeAction.BASE, 0, 0, 0, 0));
	    myCards.put(10,new CardAction("Rénovation", 4, TypeAction.BASE, 0, 0, 0, 0));
	    myCards.put(10,new CardAction("Village", 3, TypeAction.BASE, 2, 0, 0, 2));
	}
	
	public static void main(String[] args) {
		BoardGame bG = new BoardGame();
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
	public HashMap<Integer, Card> getMyCards() {
		return myCards;
	}

	/**
	 * @param myCards the myCards to set
	 */
	public void setMyCards(HashMap<Integer, Card> myCards) {
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

}
