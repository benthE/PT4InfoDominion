package model;

public class Player {

	private final int num;
	private PaketDeck myDeck=null;
	private PaketHand myHand=null;
	private PaketTrash myTrash=null;
	private Points myPoints=null;
	
	/**
	 * Constructor Player
	 */
	public Player(int num) {
		this.num = num;
		System.out.println("Constructor Init Player");
		this.initPlayer();
	}
	
	public void initPlayer(){
		myDeck = new PaketDeck();
		myDeck.initDeck();
		myHand = new PaketHand();
		myTrash = new PaketTrash();
	}
	
	public void updateCards(){
		int nb = 0;
			while(myHand.getMyCards().size() < 5)
			{
				nb = (int) (Math.random() * myDeck.getMyCards().size());
				myHand.addCard(myDeck.getMyCards().get(nb));
				myDeck.getMyCards().remove(nb);
			}		
	}
	
	/**
	 * @return the myDeck
	 */
	public PaketDeck getMyDeck() {
		return myDeck;
	}
	/**
	 * @param myDeck the myDeck to set
	 */
	public void setMyDeck(PaketDeck myDeck) {
		this.myDeck = myDeck;
	}
	/**
	 * @return the myHand
	 */
	public PaketHand getMyHand() {
		return myHand;
	}
	/**
	 * @param myHand the myHand to set
	 */
	public void setMyHand(PaketHand myHand) {
		this.myHand = myHand;
	}
	/**
	 * @return the myTrash
	 */
	public PaketTrash getMyTrash() {
		return myTrash;
	}
	/**
	 * @param myTrash the myTrash to set
	 */
	public void setMyTrash(PaketTrash myTrash) {
		this.myTrash = myTrash;
	}
	/**
	 * @return the myPoints
	 */
	public Points getMyPoints() {
		return myPoints;
	}
	/**
	 * @param myPoints the myPoints to set
	 */
	public void setMyPoints(Points myPoints) {
		this.myPoints = myPoints;
	}
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [num=" + num + ", myDeck=" + myDeck.toString() + ", myHand="
				+ myHand + ", myTrash=" + myTrash + ", myPoints=" + myPoints
				+ "]";
	}
}
