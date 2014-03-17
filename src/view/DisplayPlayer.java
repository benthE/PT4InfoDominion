package view;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Player;

import java.awt.*;

public class DisplayPlayer{


	private JLabel helpGold;
	private JPanel helpGoldPanel;
	
	private JLabel helpNbCard;
	
	private DisplayCard handCard[] = new DisplayCard[20];
	
	public DisplayPlayer(){
		helpNbCard = new JLabel();
	}
	
	public DisplayPlayer(JLayeredPane all, Player p,ImageManager img, Application app)
	{
		helpNbCard = new JLabel();
		initDisplayPlayer(all,p,img,app);
	}
  
	
	public void initDisplayPlayer(JLayeredPane all, Player p,ImageManager img, Application app){
		String nameTmp;

		int i;
		if(p.getMyHand().getMyCards().size()>0)
		{
			for( i = 0; i<p.getMyHand().getMyCards().size(); i++)
			{
				handCard[i] = new DisplayCard();
				handCard[i].updateDisplayCard(p.getMyHand().getMyCards().get(i).getName(),img);
				handCard[i].setOpaque(false);
				handCard[i].setBounds((i+1)*150, 500, 100, 200);
				
				if( p.getMyHand().getMyCards().get(i).getName() == "Cuivre")
					app.setJoueurOr(1);
			
				all.add(handCard[i],new Integer(i+8));
			}
			
		handCard[i+1] = new DisplayCard();
		handCard[i+1].updateDisplayCard("Dos",img);
		handCard[i+1].setOpaque(false);
		handCard[i+1].setBounds(10, 250, 100, 200);
		
		all.add(handCard[i+1],new Integer(i+1+8));
		
		handCard[i+2] = new DisplayCard();
		handCard[i+2].setBounds(50, 340, 20, 20);
		
		helpNbCard = new JLabel();
		helpNbCard.setText("" + p.getMyDeck().getMyCards().size());

		handCard[i+2].add(helpNbCard);
		all.add(handCard[i+2],new Integer(i+2+8));
		
		helpGold = new JLabel();
		helpGold.setText("Pièces d'or : " + app.getJoueurOr());
		helpGoldPanel = new JPanel();
		helpGoldPanel.add(helpGold);
		helpGoldPanel.setBounds(780, 400, 100, 30);
		all.add(helpGoldPanel, new Integer(i+3+8));
		all.revalidate();
		all.add(helpGoldPanel, new Integer(i+3+8));
		}
		else
		{
			for(int j=0; j<5; j++)
			{
				handCard[j].removeAll();
				handCard[j].repaint();	
			}
		}

		/*
		int i;
		if(p.getMyHand().getMyCards().size()>0)
		{
			for( i = 0; i<p.getMyHand().getMyCards().size(); i++)
			{
				handCardPanel[i] = new JPanel();
				handCardPanel[i].setOpaque(false);
				handCardPanel[i].setBounds((i+1)*150, 500, 100, 200);
			
				nameTmp = p.getMyHand().getMyCards().get(i).getName();
								
				handCardLabel[i] = new JLabel(img.getMyImgs().get(nameTmp));
				
				if( nameTmp == "Cuivre")
					app.setJoueurOr(1);
				
			
				handCardPanel[i].add(handCardLabel[i]);
				all.add(handCardPanel[i],new Integer(i+8));
			}
		
		
		handCardPanel[i+1] = new JPanel();
		handCardPanel[i+1].setBounds(10, 250, 100, 200);
		handCardPanel[i+1].setOpaque(false);
		
		handCardLabel[i+1] = new JLabel(img.getMyImgs().get("Dos"));
		handCardPanel[i+1].add(handCardLabel[i+1]);
		all.add(handCardPanel[i+1],new Integer(i+1+8));
		
		handCardPanel[i+2] = new JPanel();
		handCardPanel[i+2].setBounds(50, 340, 20, 20);
		
		helpNbCard = new JLabel();
		helpNbCard.setText("" + p.getMyDeck().getMyCards().size());

		handCardPanel[i+2].add(helpNbCard);
        handCardPanel[i+2].setOpaque(false);
		all.add(handCardPanel[i+2],new Integer(i+2+8));
        handCardPanel[i+2].revalidate();
        all.add(handCardPanel[i+2],new Integer(i+2+8));


            helpGold = new JLabel();
		helpGold.setText("PiÃ¨ces d'or : " + app.getJoueurOr());
		helpGoldPanel = new JPanel();
		helpGoldPanel.add(helpGold);
		helpGoldPanel.setBounds(800, 400, 100, 30);
		all.add(helpGoldPanel, new Integer(i+3+8));
		all.revalidate();
		all.add(helpGoldPanel, new Integer(i+3+8));
		}
		else
		{
			for(int j=0; j<5; j++)
			{
				handCardPanel[j].removeAll();
				handCardPanel[j].repaint();	
			}
		}
*/
	}
	
	
}
