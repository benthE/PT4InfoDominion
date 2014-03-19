package view;

import model.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class Application extends JFrame implements ActionListener{

	    static Application app = new Application();
		private JButton myButton0;
		JButton buttonBuy;
		private ImageManager iM = new ImageManager();
		private JLayeredPane all = new JLayeredPane();
		private static boardGame bG = new boardGame();
		private DisplayPlayer dp = new DisplayPlayer();
		private int aideJoueurOr =0;
        public static JPanel bigCardPanel;
        public static JLabel bigCard;
        JPanel buttonPlay = new JPanel();
		JPanel buttonQuit = new JPanel();
		JPanel buttonStat = new JPanel();
		JPanel titre = new JPanel();

		private JButton play;
		private JButton quit;
		private JButton stat;

		public Application() {
			super();
		}

		private void debutPartie(JLayeredPane all, boardGame bG,ImageManager img){

	        /**
	         * Affichage du fond
	         */
	        JLabel Background = new JLabel(img.getMyImgs().get("test"));
	        JPanel myBg = new JPanel();
	        myBg.setBounds(0, 0, 1600, 1080);
	        myBg.add(Background);
	        all.add(myBg,new Integer(0));

	        JPanel myButton = new JPanel();
	        myButton0 = new JButton("Tour Suivant");
	        myButton0.addActionListener(this);
	        myButton.add(myButton0);
	        myButton.setBounds(780, 450, 100, 30);
	        myButton.setOpaque(false);
	        all.add(myButton,new Integer(20));

		}
		
		private void affichageMenu(JLayeredPane all, ImageManager img){
			setSize(new Dimension(1600,1080));
		     Font s = new Font("Serif", Font.PLAIN, 24);
		     Font f = new Font("Serif", Font.PLAIN, 36); 
			
			 JLabel Background = new JLabel(img.getMyImgs().get("test"));
			 JPanel myBg = new JPanel();
		     myBg.setBounds(0, 0, 1600, 1080);
		     myBg.add(Background);
		     myBg.add(Background);
		     all.add(myBg,new Integer(0));
		     
		     play = new JButton();
		     play.setText("JOUER");
		     play.setFont(s);
		     play.addActionListener(this);
		     buttonPlay.add(play);
		     buttonPlay.setBounds(570, 200, 300, 200);
		     buttonPlay.setOpaque(false);
		     all.add(buttonPlay,new Integer(1)); 
		     
		     quit = new JButton();
		     quit.setText("QUITTER");
		     quit.setFont(s);
		     quit.addActionListener(this);
		     buttonQuit.add(quit);
		     buttonQuit.setBounds(570, 400, 300, 200);
		     buttonQuit.setOpaque(false);
		     all.add(buttonQuit,new Integer(2)); 
		     
		     stat = new JButton();
		     stat.setText("STATISTIQUES");
		     stat.setFont(s);
		     stat.addActionListener(this);
		     buttonStat.add(stat);
		     buttonStat.setBounds(565, 300, 300, 200);
		     buttonStat.setOpaque(false);
		     all.add(buttonStat,new Integer(3)); 
		     
		     JLabel txtTitre = new JLabel();
		     txtTitre.setFont(f); 
		     txtTitre.setText("MENU JEU DOMINION");
		     txtTitre.setForeground(Color.BLACK);
		     titre.add(txtTitre);
		     titre.setBounds(500, 25, 500, 200);
		     titre.setOpaque(false);
		     all.add(titre, new Integer(4));
		}

		public static void main(String[] args) throws IOException {
			/**
			 * Initialisation vue
			 */
            bigCardPanel = new JPanel();
            bigCard = new JLabel();
            bigCardPanel.setBounds(950,30,300,700);
            bigCardPanel.setOpaque(false);
            bigCardPanel.add(bigCard);
            
            app.add(bigCardPanel);
            bigCardPanel.setVisible(false);

            app.affichageMenu(app.getAll(), app.getiM());
            
			app.add(app.getAll());


			app.show(true);
		}

		public int getJoueurOr(){
			return aideJoueurOr;
		}

		public void setJoueurOr(int a){
			aideJoueurOr=a;
		}

		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if(source == myButton0)
			{
				//int resetOr = 0 - getJoueurOr();
				//setJoueurOr(resetOr);
				//setJoueurOr(dp.calculGold(bG.getMyPlayers().get(0).getMyHand().getMyCards()));
				
				System.out.println("Tour suivant");
				bG.getMyPlayers().get(0).discardHand();
				//dp.initDisplayPlayer(all,bG.getMyPlayers().get(0), iM, this);
				dp.initDisplayPlayer(app);
				bG.getMyPlayers().get(0).updateHand();
				//dp.initDisplayPlayer(all,bG.getMyPlayers().get(0), iM, this);
				dp.initDisplayPlayer(app);
				setJoueurOr(dp.calculGold(bG.getMyPlayers().get(0).getMyHand().getMyCards()));
				dp.refreshGold(app);
				System.out.println("Or = " + getJoueurOr());
			}
			
			else if(source == play){
				buttonPlay.setVisible(false);
				buttonQuit.setVisible(false);
				buttonStat.setVisible(false);
				titre.setVisible(false);
				app.revalidate();
				
				app.getbG().initPlayers();
				app.getbG().initCards();
				app.debutPartie(app.getAll(),app.getbG(),app.getiM());
				DisplayBoard db = new DisplayBoard(app,app.getbG(),app.getiM());
				//app.getDp().initDisplayPlayer(app.getAll(),app.getbG().getMyPlayers().get(0),app.getiM(),app);
				app.getDp().initDisplayPlayer(app);
				setJoueurOr( dp.calculGold(bG.getMyPlayers().get(0).getMyHand().getMyCards()));
				dp.refreshGold(app);
				app.add(app.getAll());
                IAEngine Ia = new IAEngine(bG);
                Ia.actionPhaseEngine();
                Ia.buyCardEngine();
				app.show(true);	
			}
			
			else if(source == quit){
				app.dispose();
			}
			
			else if(source == stat){
				buttonPlay.setVisible(false);
				buttonQuit.setVisible(false);
				buttonStat.setVisible(false);
				titre.setVisible(false);
				app.revalidate();
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

    public static JPanel getBigCardPanel() {
        return bigCardPanel;
    }

    public static void setBigCardPanel(JPanel bigCardPanel) {
        Application.bigCardPanel = bigCardPanel;
    }

    public JLabel getBigCard() {
        return bigCard;
    }

    public void setBigCard(JLabel bigCard) {
        this.bigCard = bigCard;
    }
	}

