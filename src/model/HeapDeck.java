package model;

public class HeapDeck extends Heap {

	public HeapDeck() {
		super(); 
		System.out.println("Constructor Init HeapDeck");
	}

	public void initDeck() {
		for(int i=0; i<8; i++)
			myCards.add(new CardTreasure(TypeTreasure.COPPER));
		for(int i=0; i<4; i++)
			myCards.add(new CardVictory());
	}
	
	@Override
	public void addCard(Card c) {
		if(myCards.size()==0)
			myCards.add(c); /* a changer pour a la défausse */
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HeapDeck [myCards=" + myCards + "]";
	}

	
}
