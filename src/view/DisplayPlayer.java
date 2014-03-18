package view;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Player;
import model.boardGame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DisplayPlayer{


	private JLabel helpGold;
	private JPanel helpGoldPanel;
	
	private JLabel helpNbCard;
	
	private DisplayCard handCard[] = new DisplayCard[20];
	private ArrayList<DisplayCard> played = new ArrayList<DisplayCard>();
	
	public DisplayPlayer(){
		helpNbCard = new JLabel();
	}
	
	public DisplayPlayer(JLayeredPane all, Player p,ImageManager img, Application app)
	{
		helpNbCard = new JLabel();
		initDisplayPlayer(all,p,img,app);
	}
  
	
	public void initDisplayPlayer(JLayeredPane all, Player p,final ImageManager img,final Application app){
		String nameTmp;

		int i;
		if(p.getMyHand().getMyCards().size()>0)
		{
			for( i = 0; i<p.getMyHand().getMyCards().size(); i++)
			{
				handCard[i] = new DisplayCard();
				handCard[i].updateDisplayCard(i,p.getMyHand().getMyCards().get(i).getName(),img);
				
				handCard[i].setOpaque(false);
				handCard[i].setBounds((i+1)*150, 500, 100, 200);
				
				if( p.getMyHand().getMyCards().get(i).getName() == "Cuivre")
					app.setJoueurOr(1);
			
				all.add(handCard[i],new Integer(i+8));
				all.revalidate();
				all.add(handCard[i],new Integer(i+8));


			}
		handCard[i+1] = new DisplayCard();
		handCard[i+1].updateDisplayCard(i,"Dos",img);
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
		helpGold.setText("Pi�ces d'or : " + app.getJoueurOr());
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
		for( i = 0; i<p.getMyHand().getMyCards().size(); i++)
		{
		handCard[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                DisplayCard l = (DisplayCard) e.getSource();
                
                app.getBigCardPanel().setVisible(true);

                app.getBigCard().setIcon(img.getMyImgs().get(l.getMyName()+"BIG"));
            }
        });
        handCard[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {

                    DisplayCard l = (DisplayCard) e.getSource();

                    app.getBigCardPanel().setVisible(false);
                }
            });
        handCard[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                DisplayCard l = (DisplayCard) e.getSource();
                
                System.out.println(l.getMyId());
                handCard[l.getMyId()].setVisible(false);//enl�ve la carte � l'�cran
                
                app.getbG().getMyPlayers().get(0).playCard(l.getMyId());
                played.add(handCard[l.getMyId()]);//on en fait une carte jou�e
                app.getAll().add(played.get(played.size()-1));
                app.revalidate();
            }
        });
		}
	}
}
