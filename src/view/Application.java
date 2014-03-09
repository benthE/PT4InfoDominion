package view;

import model.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

@SuppressWarnings("serial")
public class Application extends JFrame implements ActionListener{

		private JButton myButton0;
		JButton buttonBuy;
		private ImageManager iM = new ImageManager();
		private JLayeredPane all = new JLayeredPane();
		private boardGame bG = new boardGame();
		private DisplayPlayer dp = new DisplayPlayer();
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
    
	        
	        
	        JPanel myButton = new JPanel();
	        myButton0 = new JButton("DONE");
	        myButton0.addActionListener(this);
	        myButton.add(myButton0);
	        myButton.setBounds(770, 450, 50, 30);
	        
	        all.add(myButton,new Integer(20)); 
	        
		}

		public static void main(String[] args) throws IOException {
			/**
			 * Initialisation model
			 */
			//boardGame bG = new boardGame();
			
			
			/**
			 * Initialisation vue
			 */
			
			Application app = new Application();
			
			app.getbG().initPlayers();
			app.getbG().initCards();
			
			app.debutPartie(app.getAll(),app.getbG(),app.getiM());
			DisplayBoard db = new DisplayBoard(app.getAll(),app.getbG(),app.getiM());
			
			app.getDp().initDisplayPlayer(app.getAll(),app.getbG().getMyPlayers().get(0),app.getiM(),app);
			
			app.add(app.getAll());
	        
			app.show(true);	
		}
		
		public int getJoueurOr(){
			return aideJoueurOr;
		}
		
		public void setJoueurOr(int a){
			aideJoueurOr+=a;
		}
		
		//***************** INUTILE ****************** sauf pour myButton0 (done)
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			
			if(source == myButton0)
			{
				System.out.println("Vous avez cliqué ici.");
				System.out.println(bG.getMyPlayers().get(0).getMyHand().getMyCards().size());
				bG.getMyPlayers().get(0).discardHand();
				System.out.println(bG.getMyPlayers().get(0).getMyHand().getMyCards().size());
				
				dp.initDisplayPlayer(all,bG.getMyPlayers().get(0), iM, this);
				
				bG.getMyPlayers().get(0).updateHand();
				dp.initDisplayPlayer(all,bG.getMyPlayers().get(0), iM, this);

			}
			
		}

		/**
		 * @return the bG
		 */
		public boardGame getbG() {
			return bG;
		}

		/**
		 * @param bG the bG to set
		 */
		public void setbG(boardGame bG) {
			this.bG = bG;
		}

		/**
		 * @return the dp
		 */
		public DisplayPlayer getDp() {
			return dp;
		}

		/**
		 * @param dp the dp to set
		 */
		public void setDp(DisplayPlayer dp) {
			this.dp = dp;
		}

		/**
		 * @return the all
		 */
		public JLayeredPane getAll() {
			return all;
		}

		/**
		 * @param all the all to set
		 */
		public void setAll(JLayeredPane all) {
			this.all = all;
		}

		/**
		 * @return the iM
		 */
		public ImageManager getiM() {
			return iM;
		}

		/**
		 * @param iM the iM to set
		 */
		public void setiM(ImageManager iM) {
			this.iM = iM;
		}
	}

