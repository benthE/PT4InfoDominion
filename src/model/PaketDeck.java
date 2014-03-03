package model;

public class PaketDeck extends Paket {

	public PaketDeck() {
		super(); 
		System.out.println("Constructor Init HeapDeck");
	}

	public void initDeck() {
		for(int i=0; i<7; i++)
			myCards.add(new CardTreasure(TypeTreasure.COPPER));
		for(int i=0; i<3; i++)
			myCards.add(new CardVictory());
	}
	
	@Override
	public void addCard(Card c) {
		myCards.add(c); /* cette fonction est inutile pour linstant */
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HeapDeck [myCards=" + myCards + "]";
	}

	
}
