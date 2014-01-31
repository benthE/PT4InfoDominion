package model;
/******* TEST TEST TEST TEST TEST TEST ********/
public class Application {

	public static void main(String[] args) {
		System.out.println("hi");
		Card c;
		c = new Card();
		c = new CardAction();
		c = new CardTreasure();
		c = new CardVictory();
		String tmp = "ha";
		if(((CardVictory) c).isGarden()){
			tmp = "hi";
		}else{
			tmp = "ho";
		}
		System.out.println(tmp);
	}

}
