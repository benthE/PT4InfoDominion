package view;

import model.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.*;

@SuppressWarnings("serial")
public class Application extends JFrame implements ActionListener{

		JPanel myPanel;
		JButton myButton0;
		JButton buttonBuy;

		private int aideJoueurOr =0;
		
		public Application() {
			super();
		}
		
		private void debutPartie(JLayeredPane all, boardGame bG,ImageManager img){
	        setSize(new Dimension(1000,700));
	        
	        /**
	         * Affichage du fond
	         */
	        JLabel Background = new JLabel(img.getMyImgs().get("test"));
	        JPanel myBg = new JPanel();
	        myBg.setBounds(0, 0, 1000, 700);
	        myBg.add(Background);
	        myBg.add(Background);
	        all.add(myBg,new Integer(0));
	        
	        /**
	         * Affichage Aides (fonctionne pas)
	         */
	        //displayBoard(all, bG,img);
	        //JLabel aideOr = new JLabel();
	        //aideOr.setText("Pièces d'or : " + getJoueurOr());
	        
	        //buttonBuy = new JButton("+");
			//buttonBuy.addActionListener(this);
	        
	        
		}

		public static void main(String[] args) throws IOException {
			/**
			 * Initialisation model
			 */
			boardGame bG = new boardGame();
			bG.initPlayers();
			bG.initCards();
			
			/**
			 * Initialisation vue
			 */
			ImageManager iM = new ImageManager();
			Application app = new Application();
			JLayeredPane all = new JLayeredPane();
						
			
			app.debutPartie(all,bG,iM);
			DisplayBoard db = new DisplayBoard(all,bG,iM);
			DisplayPlayer dp = new DisplayPlayer(all,bG.getMyPlayers().get(0),iM,app);
			
			app.add(all);
	        
			app.show(true);
		}

		/**
		 * @return the myPanel
		 */
		public JPanel getMyPanel() {
			return myPanel;
		}

		/**
		 * @param myPanel the myPanel to set
		 */
		public void setMyPanel(JPanel myPanel) {
			this.myPanel = myPanel;
		}
		
		public int getJoueurOr(){
			return aideJoueurOr;
		}
		
		public void setJoueurOr(int a){
			aideJoueurOr+=a;
		}
		
		//***************** INUTILE ******************
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			
			if(source == myButton0){
				System.out.println("Vous avez cliqué ici.");
			} 
		}
		
		

	}

