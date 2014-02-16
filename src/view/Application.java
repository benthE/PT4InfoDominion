package view;

import model.*;
import displayClass.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

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
		
		private void debutPartie(JLayeredPane tout){
	        setSize(new Dimension(1000,700));
	        
	        //JLayeredPane tout = new JLayeredPane();
	        JPanel carteEnMain1 = new JPanel();
	        JPanel carteEnMain2 = new JPanel();
	        JPanel carteEnMain3 = new JPanel();
	        JPanel carteEnMain4 = new JPanel();
	        JPanel carteEnMain5 = new JPanel();
	        JPanel carteEnMain6 = new JPanel();

	        ImageIcon image = new ImageIcon("img/test.jpg");
	        JLabel fond = new JLabel(image);
	 
	        ImageIcon emp2 = new ImageIcon(new ImageIcon("img/carteDouves.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
	        JLabel img = new JLabel(emp2);
	        
	        ImageIcon emp3 = new ImageIcon(new ImageIcon("img/carteMilice.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
	        JLabel milice = new JLabel(emp3);
	        
	        ImageIcon emp4 = new ImageIcon(new ImageIcon("img/carteMarche.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
	        JLabel marche = new JLabel(emp4);
	        
	        ImageIcon emp5 = new ImageIcon(new ImageIcon("img/carteForgeron.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
	        JLabel forgeron = new JLabel(emp5);
	        
	        ImageIcon emp6 = new ImageIcon(new ImageIcon("img/carteAtelier.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
	        JLabel atelier = new JLabel(emp6);

	        carteEnMain1.setBounds(0, 0, 1000, 700);
	        carteEnMain2.setBounds(150, 20, 100, 200);
	        carteEnMain3.setBounds(300, 20, 100, 200);
	        carteEnMain4.setBounds(450, 20, 100, 200);
	        carteEnMain5.setBounds(600, 20, 100, 200);
	        carteEnMain6.setBounds(750, 20, 100, 200);
	        
	        carteEnMain1.add(fond);
	        carteEnMain2.add(img);
	        carteEnMain3.add(milice);
	        carteEnMain4.add(marche);
	        carteEnMain5.add(forgeron);
	        carteEnMain6.add(atelier);
	        
	        tout.add(carteEnMain1, new Integer(0));
	        tout.add(carteEnMain2, new Integer(1));
	        tout.add(carteEnMain3, new Integer(2));
	        tout.add(carteEnMain4, new Integer(3));
	        tout.add(carteEnMain5, new Integer(4));
	        tout.add(carteEnMain6, new Integer(5));

	        //add(tout, BorderLayout.CENTER);
	        //getContentPane().add(carteEnMain);
		}
		
		public static void main(String[] args) throws IOException {
			Application app = new Application();

			JLayeredPane all = new JLayeredPane();
			
			app.debutPartie(all);
			
			Player p = new Player(0);
			p.initPlayer();
			p.updateCards();
						
			ImageIcon empCuivre = new ImageIcon(new ImageIcon("img/carteCuivre.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
			ImageIcon empDomaine = new ImageIcon(new ImageIcon("img/carteDomaine.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
			
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
					card[i] = new JLabel(empDomaine);
				else if( tmp == "Cuivre")
					card[i] = new JLabel(empCuivre);
			
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
					card[j] = new JLabel(empDomaine);
				else if( tmp == "Cuivre")
					card[j] = new JLabel(empCuivre);
			
				handCard[j].add(card[j]);
				all.add(handCard[j],new Integer(j+5));
			}
			
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

