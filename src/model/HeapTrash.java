package model;

public class HeapTrash extends Heap {

	private Card topCard=null;
	
	/**
	 * Constructor Init
	 */
	public HeapTrash() {
		super();
	}

	
	public void addCard(Card c) {
		topCard = c;
		myCards.add(c);
	}


	public Card getTopCard() {
		return topCard;
	}


	public void setTopCard(Card topCard) {
		this.topCard = topCard;
	}

}
