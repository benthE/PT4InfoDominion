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
        public static JPanel bigCardPanel;
        public static JLabel bigCard;

		public Application() {
			super();
		}

		private void debutPartie(JLayeredPane all, boardGame bG,ImageManager img){
	        setSize(new Dimension(1600,1080));

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
	        myButton.setBounds(800, 450, 100, 30);


	        all.add(myButton,new Integer(20));

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
			Application app = new Application();

			app.getbG().initPlayers();
			app.getbG().initCards();
            app.add(bigCardPanel);

            bigCardPanel.setVisible(false);

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

		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if(source == myButton0)
			{
				int resetOr = 0 - getJoueurOr();
				setJoueurOr(resetOr);

				System.out.println("Tour suivant");
				bG.getMyPlayers().get(0).discardHand();
				dp.initDisplayPlayer(all,bG.getMyPlayers().get(0), iM, this);
				bG.getMyPlayers().get(0).updateHand();
				dp.initDisplayPlayer(all,bG.getMyPlayers().get(0), iM, this);
				System.out.println("Or = " + getJoueurOr());
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

