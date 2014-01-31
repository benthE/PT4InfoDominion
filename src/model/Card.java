package model;

public class Card {
		private String name;
		private int price;
		
		/** 
		 * Constructor Init 
		 */
		public Card() {
			System.out.println("Constructor Init Card");
			name = "unknow";
			price = 0;
		}
		
		/** 
		 * Constructor Param 
		 */
		public Card(String n, int p){
			System.out.println("Constructor Param Card");
			name = n;
			if(p>=0)
				price = p;
			else
				price = 0;
		}
		
		/** 
		 * Constructor Copy 
		 */
		public Card(Card c){
			System.out.println("Constructor Copy Card");
			name = c.getName();
			price = c.getPrice();
		}
		
		/**
		 * @return the name
		 */
		public String getName(){
			return name;
		}
		
		/**
		 * @return the price
		 */
		public int getPrice(){
			return price;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @param price the price to set
		 */
		public void setPrice(int price) {
			this.price = price;
		}
}
