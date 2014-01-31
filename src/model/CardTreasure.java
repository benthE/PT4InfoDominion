package model;

public class CardTreasure extends Card {

	private int value;
	private TypeTreasure myType=TypeTreasure.COPPER;
	
	/** 
	 * Constructor Init 
	 */
	public CardTreasure() {
		super();
		System.out.println("Constructor Init CardTreasure");
		value = 0;
	}
	
	/** 
	 * Constructor Param 
	 */
	public CardTreasure(String n, int p, int v) {
		super(n, p);
		System.out.println("Constructor Param n,p,v CardTreasure");
		value = v;
	}
	
	public CardTreasure(TypeTreasure tt){
		super();
		System.out.println("Constructor Param tt CardTreasure");
		this.initTreasure(tt);
	}
	
	/** 
	 * Constructor Copy 
	 */
	public CardTreasure(CardTreasure c) {
		super(c);
		System.out.println("Constructor Copy CardTreasure");
		value = c.getValue();
	}

	public void initTreasure(TypeTreasure tt) {
		this.setMyType(tt);
		switch(tt){
			case COPPER :
				this.setName("Cuivre");
				this.setPrice(0);
				this.setValue(1);
				break;
			case SILVER :
				this.setName("Argent");
				this.setPrice(3);
				this.setValue(2);
				break;
			case GOLD :
				this.setName("Or");
				this.setPrice(6);
				this.setValue(3);
				break;
		}
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the myType
	 */
	public TypeTreasure getMyType() {
		return myType;
	}

	/**
	 * @param myType the myType to set
	 */
	public void setMyType(TypeTreasure myType) {
		this.myType = myType;
	}
}
