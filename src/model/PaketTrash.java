package model;

public class PaketTrash extends Paket {

	private Card topCard=null;
	
	/**
	 * Constructor Init
	 */
	public PaketTrash() {
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
