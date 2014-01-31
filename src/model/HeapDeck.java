package model;

public class HeapDeck extends Heap {

	public HeapDeck() {

	}

	@Override
	public void addCard(Card c) {
		if(myCards.size() < 5)
			myCards.add(c);
	}

}
