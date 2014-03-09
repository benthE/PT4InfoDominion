package model;

public class PaketDiscard extends Paket {

	private Card topCard=null;
	
	/**
	 * Constructor Init
	 */
	public PaketDiscard() {
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
