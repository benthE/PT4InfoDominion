package model;

public class PaketHand extends Paket {

	/**
	 * Constructor Init
	 */
	public PaketHand() {
		super();
		System.out.println("Constructor Init HeapHand");
	}

	public void addCard(Card c) {
		if(myCards.size() < 5)
			myCards.add(c);
	}

}
