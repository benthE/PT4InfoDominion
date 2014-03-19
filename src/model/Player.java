package model;

import java.util.ArrayList;

public class Player {

	private final int num;
	private PaketDeck myDeck=null;
	private PaketHand myHand=null;
	private PaketDiscard myDiscard=null;
	//private PaketTrash myTrash=null;
	private Points myPoints=null;
	private ArrayList<Card> played  = null;
    private int myBuy=0;
    private boolean isPlaying;
    private int nbaction;
    private boolean endAction;
    private boolean endBuy;
	
	/**
	 * Constructor Player
	 */
	public Player(int num) {
		this.num = num;
		System.out.println("Constructor Init Player");
		this.initPlayer();
	}

    public Player() {
        num = this.getNum();
        initPlayer();
    }

    public void initPlayer(){
		myDeck = new PaketDeck();
		myDeck.initDeck();
		myHand = new PaketHand();
		myDiscard = new PaketDiscard();
		myPoints = new Points();
		played = new ArrayList<Card>();
		//myTrash = new PaketTrash();
        this.setMyBuy(1);
        isPlaying = false;
        nbaction = 1;
        endAction = false;
        endBuy = false;
	}
	
	public void updateDeck(){
		myDeck.getMyCards().addAll(myDiscard.getMyCards());
		myDiscard.setMyCards( new ArrayList<Card>());
		myDiscard.setTopCard(null);
		myPoints = new Points();
	}
	
	public void updateHand(){
		int nb = 0;
		while(myHand.getMyCards().size() < 5)
			{
				if(myDeck.getMyCards().size()==0)
					updateDeck();
				else
				{
					nb = (int) (Math.random() * myDeck.getMyCards().size());
					myHand.addCard(myDeck.getMyCards().get(nb));
					myDeck.getMyCards().remove(nb);
				}
			}
	}
	
	public void playCard(Integer id){
		played.add(myHand.getMyCards().get(id));
		myHand.getMyCards().remove(id);
		
	}
	
	public void discardPlayed(){
		myDiscard.getMyCards().addAll(played);
		played = new ArrayList();
	}
	
	public void discardHand(){
		if(myHand.getMyCards().size() > 0)
		{
			myDiscard.getMyCards().addAll(myHand.getMyCards());
			myHand.setMyCards( new ArrayList<Card>());
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
	 *
	public PaketTrash getMyTrash() {
		return myTrash;
	}
	/**
	 * @param myTrash the myTrash to set
	 *
	public void setMyTrash(PaketTrash myTrash) {
		this.myTrash = myTrash;
	}*/
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
				+ myHand + ", myPoints=" + myPoints
				+ "]";
	}

	/**
	 * @return the myDiscard
	 */
	public PaketDiscard getMyDiscard() {
		return myDiscard;
	}

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }
    public int getNbAction() {
        return nbaction;
    }

    public void setNbAction(int action) {
        this.nbaction = action;
    }
    public int getMyBuy() {
        return myBuy;
    }

    public void setMyBuy(int myBuy) {
        this.myBuy = myBuy;
    }
    public boolean isEndAction() {
        return endAction;
    }

    public void setEndAction(boolean endAction) {
        this.endAction = endAction;
    }

    public boolean isEndBuy() {
        return endBuy;
    }

    public void setEndBuy(boolean endBuy) {
        this.endBuy = endBuy;
    }
}
