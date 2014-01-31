package model;

public class HeapHand extends Heap {

	/**
	 * Constructor Init
	 */
	public HeapHand() {
		super();
		System.out.println("Constructor Init HeapHand");
	}

	public void addCard(Card c) {
		if(myCards.size() < 5)
			myCards.add(c);
	}

}
