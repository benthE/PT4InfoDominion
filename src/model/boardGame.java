package model;

import java.util.ArrayList;
import java.util.HashMap;

public class boardGame {

	private ArrayList<Player> myPlayers=null;
	private HashMap<int[],Card> myCards=null;
	private int nbRound;
	
	
	public boardGame() {
		nbRound = 0;
	}

	public void initPlayers(){
		myPlayers = new ArrayList<Player>();
		myPlayers.add(new Player(1));
	}
	
	public void initCards(){
		myCards = new HashMap<int[],Card>();
		int[] num = new int[1];
		num[0] = 10;
		myCards.put(num,new CardTreasure(TypeTreasure.COPPER));
		myCards.put(num,new CardTreasure(TypeTreasure.SILVER));
		myCards.put(num,new CardTreasure(TypeTreasure.GOLD));
		myCards.put(num,new CardVictory());
	}
	
	public static void main(String[] args) {
		boardGame bG = new boardGame();
		bG.initPlayers();
		bG.initCards();

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
	public HashMap<int[], Card> getMyCards() {
		return myCards;
	}

	/**
	 * @param myCards the myCards to set
	 */
	public void setMyCards(HashMap<int[], Card> myCards) {
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
