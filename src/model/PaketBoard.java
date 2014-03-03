package model;

public class PaketBoard extends Paket {

	private Card myCard;
	private Integer myNbCard;
	
	public PaketBoard() {
		
	}

	public PaketBoard( Card c, Integer i) {
		myCard = c;
		myNbCard = i;
	}
	
	@Override
	public void addCard(Card c) {
		System.out.println("impossible addCard sur paket board");
	}

	/**
	 * @return the myCard
	 */
	public Card getMyCard() {
		return myCard;
	}

	/**
	 * @param myCard the myCard to set
	 */
	public void setMyCard(Card myCard) {
		this.myCard = myCard;
	}

	/**
	 * @return the myNbCard
	 */
	public Integer getMyNbCard() {
		return myNbCard;
	}

	/**
	 * @param myNbCard the myNbCard to set
	 */
	public void setMyNbCard(Integer myNbCard) {
		this.myNbCard = myNbCard;
	}

}
