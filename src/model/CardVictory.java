package model;

public class CardVictory extends Card{

	private int nbPoint;
	private boolean isGarden = false;
	
	/** 
	 * Constructor Init 
	 */
	public CardVictory() {
		super("Domaine",2);
		System.out.println("Constructor Init CardVictory");
		nbPoint = 1;
	}

	/** 
	 * Constructor Param
	 */
	public CardVictory(String n, int p, int np, boolean ig) {
		super(n, p);
		System.out.println("Constructor Param CardVictory");
		nbPoint = np;
		isGarden = ig;
	}

	/** 
	 * Constructor Copy 
	 */
	public CardVictory(CardVictory c) {
		super(c);
		System.out.println("Constructor Copy CardVictory");
		nbPoint = c.getNbPoint();
		isGarden = c.isGarden();
	}

	/**
	 * @return the nbPoint
	 */
	public int getNbPoint() {
		return nbPoint;
	}

	/**
	 * @param nbPoint the nbPoint to set
	 */
	public void setNbPoint(int nbPoint) {
		this.nbPoint = nbPoint;
	}

	/**
	 * @return the isGarden
	 */
	public boolean isGarden() {
		return isGarden;
	}

	/**
	 * @param isGarden the isGarden to set
	 */
	public void setGarden(boolean isGarden) {
		this.isGarden = isGarden;
	}
}
