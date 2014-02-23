package view;

import model.*;
import displayClass.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.xml.transform.Source;

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
		
		public static void main(String[] args) throws IOException {
			Application app = new Application();
			//app.initializeMainMenu();
			//app.initializeGame();
			
			JFrame appli = new JFrame();
	        appli.setSize(new Dimension(1000,800));
 
	        JPanel carteEnMain = new JPanel();
	 
	        JLabel label = new JLabel();
	        ImageIcon emp1 = new ImageIcon(new ImageIcon("img/carteMilice.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
	        label.setIcon(emp1);
	        label.setBounds(500, 200, 100, 200);
	        //carteEnMain.add(new JLabel(emp1));
	        carteEnMain.add(label);
	        
	        ImageIcon emp2 = new ImageIcon(new ImageIcon("img/carteDouves.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
	        carteEnMain.add(new JLabel(emp2));
	 
	        ImageIcon emp3 = new ImageIcon(new ImageIcon("img/carteMarche.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
	        carteEnMain.add(new JLabel(emp3));
	        
	        ImageIcon emp4 = new ImageIcon(new ImageIcon("img/carteCave.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
	        carteEnMain.add(new JLabel(emp4));
	        
	        ImageIcon emp5 = new ImageIcon(new ImageIcon("img/carteForgeron.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
	        carteEnMain.add(new JLabel(emp5));
	        
	        appli.setContentPane(carteEnMain);
	        appli.setVisible(true);
			
			//((JButton) app.getMyPanel().getComponent(0)).addActionListener( new ActionListener() 
			//{	public void actionPerformed(ActionEvent e) { System.out.println("j'ai cliqu� !");app.initializeGame(); }		} );
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

