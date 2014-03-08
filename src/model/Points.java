package model;

public class Points {

	private int pAction;
	private int pPurchase;
	private int pMoney;
	private int pCard;
    private  boolean endBuy;

	/**
	 * Constructor Init
	 */
	public Points() {
		System.out.println("Constructor Init Points");
		pAction = 0;
		pPurchase = 0;
		pMoney = 9; // mise à 1 pour essai d'une IA
		pCard = 0;
        endBuy= false;
	}
	
	/**
	 * Constructor Param
	 */
	public Points(int pa, int pp, int pm, int pc, boolean endB) {
		System.out.println("Constructor Param Points");
		pAction = pa;
		pPurchase = pp;
		pMoney = pm;
		pCard = pc;
        endBuy = endB;
	}
	
	/**
	 * Constructor Copy
	 */
	public Points(Points pts) {
		System.out.println("Constructor Copy Points");
		pAction = pts.getPAction();
		pPurchase = pts.getPPurchase();
		pMoney = pts.getPMoney();
        endBuy = pts.isEndBuy();
	}
	
	/**
	 * @return the pAction
	 */
	public int getPAction() {
		return pAction;
	}

	/**
	 * @param pAction the pAction to set
	 */
	public void setPAction(int pAction) {
		this.pAction = pAction;
	}

	/**
	 * @return the pPurchase
	 */
	public int getPPurchase() {
		return pPurchase;
	}

	/**
	 * @param pPurchase the pPurchase to set
	 */
	public void setPPurchase(int pPurchase) {
		this.pPurchase = pPurchase;
	}

	/**
	 * @return the pMoney
	 */
	public int getPMoney() {
		return pMoney;
	}

	/**
	 * @param pMoney the pMoney to set
	 */
	public void setPMoney(int pMoney) {
		this.pMoney = pMoney;
	}

	/**
	 * @return the pCard
	 */
	public int getpCard() {
		return pCard;
	}

	/**
	 * @param pCard the pCard to set
	 */
	public void setpCard(int pCard) {
		this.pCard = pCard;
	}

    public boolean isEndBuy() {
        return endBuy;
    }

    public void setEndBuy(boolean endBuy) {
        this.endBuy = endBuy;
    }
}
