package model;

import java.util.ArrayList;

public abstract class Heap {

	ArrayList<Card> myCards = null;

	/**
	 * @return the myCards
	 */
	public ArrayList<Card> getMyCards() {
		return myCards;
	}

	/**
	 * @param myCards the myCards to set
	 */
	public void setMyCards(ArrayList<Card> myCards) {
		this.myCards = myCards;
	}
	
	public abstract void addCard(Card c);

}
