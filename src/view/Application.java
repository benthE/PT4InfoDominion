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
		
		private void debutPartie(JLayeredPane tout, boardGame bG,HashMap<String,ImageIcon> img){
	        setSize(new Dimension(1000,700));
	        JLabel fond = new JLabel(img.get("test"));

	        JPanel board[] = new JPanel[20];
	        JLabel card[] = new JLabel[20];
	        
	        JLabel aideOr = new JLabel();
	        aideOr.setText("Pièces d'or : " + getJoueurOr());
	        
	        //buttonBuy = new JButton("+");
			//buttonBuy.addActionListener(this);
	        
	        board[0] = new JPanel();
	        board[0].setBounds(0, 0, 1000, 700);
	        board[0].add(fond);
	        board[0].add(fond);
	        tout.add(board[0],new Integer(0));
	        
	        for(int i=1; i<18; i++)
	        {
		        card[i-1] = new JLabel(img.get(bG.getMyCards().get(i).getMyCard().getName()));
	
		        board[i] = new JPanel();
		        if (i>14)
		    		board[i].setBounds(780, 20+(i-14)*50, 100, 200);
		        else if (i>10)
		    		board[i].setBounds(130, 20+(i-10)*50, 100, 200);
		        else if(i>5)
		        	board[i].setBounds(150+((i-5)*100), 240, 100, 200);
		        else
		        	board[i].setBounds(150+(i*100), 20, 100, 200);
		        board[i].add(card[i-1]);
		        
		        tout.add(board[i],new Integer(i));
	       	}
		}
		
		public static void main(String[] args) throws IOException {
			Application app = new Application();
			HashMap<String,ImageIcon> myImgs = new HashMap<String,ImageIcon>();
			
			/**
			 * Cartes Trésor
			 */
			myImgs.put("Cuivre",new ImageIcon(new ImageIcon("img/carteCuivre.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Argent",new ImageIcon(new ImageIcon("img/carteArgent.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Or",new ImageIcon(new ImageIcon("img/carteOr.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			
			/**
			 * Cartes Victoire
			 */
			myImgs.put("Domaine",new ImageIcon(new ImageIcon("img/carteDomaine.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Duche",new ImageIcon(new ImageIcon("img/carteDuche.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Province",new ImageIcon(new ImageIcon("img/carteProvince.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Malediction",new ImageIcon(new ImageIcon("img/carteMalediction.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			
			/**
			 * Cartes Action
			 */
			myImgs.put("Bucheron",new ImageIcon(new ImageIcon("img/carteBucheron.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Cave",new ImageIcon(new ImageIcon("img/carteCave.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Mine",new ImageIcon(new ImageIcon("img/carteMine.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Douves",new ImageIcon(new ImageIcon("img/carteDouves.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Milice",new ImageIcon(new ImageIcon("img/carteMilice.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Marche",new ImageIcon(new ImageIcon("img/carteMarche.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Forgeron",new ImageIcon(new ImageIcon("img/carteForgeron.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Atelier",new ImageIcon(new ImageIcon("img/carteAtelier.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Dos",new ImageIcon(new ImageIcon("img/dos.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("test",new ImageIcon("img/test.jpg"));
			
			JLayeredPane all = new JLayeredPane();
			
			boardGame bG = new boardGame();
			bG.initPlayers();
			bG.initCards();
			
			DisplayPlayer dp = new DisplayPlayer(all,bG.getMyPlayers().get(0),myImgs,app);
			app.debutPartie(all,bG,myImgs);
			
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

