package view;

import model.*;
import displayClass.*;

import java.awt.*;
import java.awt.event.*;
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
			
			
			JImagePanel imgPnl = new JImagePanel(new File("C://img.jpg"),10,10);
			//Container cp = getContentPane();
			//cp.add(imgPnl);	
			add(imgPnl);
			show(true);
		}
		
		@SuppressWarnings("deprecation")
		public static void main(String[] args) throws IOException {
			Application app = new Application();
			app.initializeMainMenu();
			//app.initializeGame();
			//((JButton) app.getMyPanel().getComponent(0)).addActionListener( new ActionListener() 
			//{	public void actionPerformed(ActionEvent e) { System.out.println("j'ai cliqué !");app.initializeGame(); }		} );
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
				System.out.println("Vous avez cliqué ici.");
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

