package view;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Player;

public class DisplayPlayer{


	private JLabel helpGold;
	private JPanel helpGoldPanel;
	
	private JLabel helpNbCard;
	private JLabel handCardLabel[] = new JLabel[20];
	private JPanel handCardPanel[] = new JPanel[20];

	
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
		all.add(handCardPanel[i+2],new Integer(i+2+8));
		
		helpGold = new JLabel();
		helpGold.setText("Pièces d'or : " + app.getJoueurOr());
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

	}
	
	
}
