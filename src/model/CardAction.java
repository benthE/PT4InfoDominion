package model;

public class CardAction extends Card{
	
	private TypeAction myTypeAction;
	private Points myPoints;
	
	/** 
	 * Constructor Init 
	 */
	public CardAction() {
		super();
		System.out.println("Constructor Init CardAction");
		myTypeAction = TypeAction.BASE;
		myPoints = new Points();
	}
	
	/** 
	 * Constructor Param 
	 */
	public CardAction(String n, int p, TypeAction ta, int pa, int pp, int pm) {
		super(n, p);
		System.out.println("Constructor Param CardAction");
		myTypeAction = ta;
		myPoints = new Points(pa,pp,pm);
		
	}
	
	/** 
	 * Constructor Copy 
	 */
	public CardAction(CardAction c, Points pts) {
		super(c);
		System.out.println("Constructor Copy CardAction");
		myTypeAction = c.getMyTypeAction();
		myPoints = new Points(pts);
	}

	/**
	 * @return the myTypeAction
	 */
	public TypeAction getMyTypeAction() {
		return myTypeAction;
	}

	/**
	 * @param myTypeAction the myTypeAction to set
	 */
	public void setMyTypeAction(TypeAction myTypeAction) {
		this.myTypeAction = myTypeAction;
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
}
