package view;

import model.*;
import displayClass.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.*;

@SuppressWarnings("serial")
public class Application extends JFrame implements ActionListener{

		JPanel myPanel;
		JButton myButton0;
		
		public Application() {
			super();
		}

		private void initializeMainMenu() {
			setTitle("Dominion - Menu Principal");
			setSize(800,600);
			setDefaultCloseOperation(3);
			setVisible(true);
			
			myPanel = new JPanel(); 
			myPanel.setBackground(Color.blue);
			myPanel.setLayout(null);
			myButton0 = new JButton("Jouer");
			myButton0.setBounds(80,80,100,60);
			myButton0.addActionListener(this);
			myPanel.add(myButton0);
			setContentPane(myPanel);
		}
		
		private void initializeGame() throws IOException{
			
			setTitle("Dominion - Game");
			setSize(1000,800);
			
			JImagePanel imageFond = new JImagePanel(new File("img/test.jpg"),0,0,true);
			getContentPane().add(imageFond);
			
			
			
		}
		
		private void debutPartie(JLayeredPane tout, BoardGame bG,HashMap<String,ImageIcon> img){
	        setSize(new Dimension(1000,700));
	        JLabel fond = new JLabel(img.get("test"));

	        JPanel board[] = new JPanel[17];
	        JLabel card[] = new JLabel[17];
	        
	        card[0] = new JLabel(img.get("Douves"));
	        
	        card[1] = new JLabel(img.get("Milice"));
	        
	        card[2] = new JLabel(img.get("Marche"));
	        	        
	        card[3] = new JLabel(img.get("Forgeron"));

	        card[4] = new JLabel(img.get("Atelier"));

	        board[0] = new JPanel();
	        board[1] = new JPanel();
	        board[2] = new JPanel();
	        board[3] = new JPanel();
	        board[4] = new JPanel();
	        board[5] = new JPanel();
	        
	        board[0].setBounds(0, 0, 1000, 700);
	        board[1].setBounds(150, 20, 100, 200);
	        board[2].setBounds(300, 20, 100, 200);
	        board[3].setBounds(450, 20, 100, 200);
	        board[4].setBounds(600, 20, 100, 200);
	        board[5].setBounds(750, 20, 100, 200);
	        
	        board[0].add(fond);
	        board[1].add(card[0]);
	        board[2].add(card[1]);
	        board[3].add(card[2]);
	        board[4].add(card[3]);
	        board[5].add(card[4]);
	        
	        tout.add(board[0], new Integer(0));
	        tout.add(board[1], new Integer(1));
	        tout.add(board[2], new Integer(2));
	        tout.add(board[3], new Integer(3));
	        tout.add(board[4], new Integer(4));
	        tout.add(board[5], new Integer(5));

	        //add(tout, BorderLayout.CENTER);
	        //getContentPane().add(carteEnMain);
		}
		
		public void displayPlayer(JLayeredPane all, Player p,HashMap<String,ImageIcon> img){
			String tmp;
			JLabel card[] = new JLabel[20];
			JPanel handCard[] = new JPanel[20];
			int i;
			for( i = 0; i<p.getMyHand().getMyCards().size(); i++)
			{
				handCard[i] = new JPanel();
				handCard[i].setBounds((i+1)*150, 250, 100, 200);
				
				tmp = p.getMyHand().getMyCards().get(i).getName();
				
				if( tmp == "Domaine")
					card[i] = new JLabel(img.get("Domaine"));
				else if( tmp == "Cuivre")
					card[i] = new JLabel(img.get("Cuivre"));
			
				handCard[i].add(card[i]);
				all.add(handCard[i],new Integer(i+5));
			}
			int tmp1 = i;
			for( int j = tmp1; j<p.getMyDeck().getMyCards().size()+tmp1; j++)
			{
				handCard[j] = new JPanel();
				handCard[j].setBounds(((j-tmp1)+1)*150, 550, 100, 200);
				
				tmp = p.getMyDeck().getMyCards().get((j-tmp1)).getName();
				
				if( tmp == "Domaine")
					card[j] = new JLabel(img.get("Domaine"));
				else if( tmp == "Cuivre")
					card[j] = new JLabel(img.get("Cuivre"));
			
				handCard[j].add(card[j]);
				all.add(handCard[j],new Integer(j+5));
			}
		}
		
		public static void main(String[] args) throws IOException {
			Application app = new Application();
			HashMap<String,ImageIcon> myImgs = new HashMap<String,ImageIcon>();
			
			myImgs.put("Cuivre",new ImageIcon(new ImageIcon("img/carteCuivre.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Domaine",new ImageIcon(new ImageIcon("img/carteDomaine.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Douves",new ImageIcon(new ImageIcon("img/carteDouves.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Milice",new ImageIcon(new ImageIcon("img/carteMilice.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Marche",new ImageIcon(new ImageIcon("img/carteMarche.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Forgeron",new ImageIcon(new ImageIcon("img/carteForgeron.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("Atelier",new ImageIcon(new ImageIcon("img/carteAtelier.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
			myImgs.put("test",new ImageIcon("img/test.jpg"));
			
			JLayeredPane all = new JLayeredPane();
			
			BoardGame bG = new BoardGame();
			bG.initPlayers();
			bG.initCards();
			
			app.debutPartie(all,bG,myImgs);
			app.displayPlayer(all,bG.getMyPlayers().get(0),myImgs);
			
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

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			
			if(source == myButton0){
				System.out.println("Vous avez cliqu� ici.");
				try {
					initializeGame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("exception");
					e1.printStackTrace();
				}
			} 
		}

	}

