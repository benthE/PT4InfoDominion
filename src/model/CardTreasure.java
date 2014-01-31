package model;

public class CardTreasure extends Card {

	private int value;
	
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
		System.out.println("Constructor Param CardTreasure");
		value = v;
	}
	
	/** 
	 * Constructor Copy 
	 */
	public CardTreasure(CardTreasure c) {
		super(c);
		System.out.println("Constructor Copy CardTreasure");
		value = c.getValue();
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
}
