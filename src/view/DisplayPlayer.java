package view;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Card;
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
	
	private DisplayCard cardDiscard = new DisplayCard();
	
	public DisplayPlayer(){
		helpNbCard = new JLabel();
	}
	
	public DisplayPlayer(JLayeredPane all, Player p,ImageManager img, Application app)
	{
		helpNbCard = new JLabel();
		initDisplayPlayer(all,p,img,app,true);
	}
	

	
	public void initDisplayPlayer(JLayeredPane all, Player p,final ImageManager img,final Application app,boolean calcul){
		String nameTmp;

		int i;
		if(p.getMyHand().getMyCards().size()>0)
		{
			if(app.getbG().getMyPlayers().get(0).getMyDiscard().getTopCard()!=null){
		
			}
			for( i = 0; i<p.getMyHand().getMyCards().size(); i++)
			{
				handCard[i] = new DisplayCard();
				handCard[i].updateDisplayCard(i,p.getMyHand().getMyCards().get(i).getName(),img);
				handCard[i].setOpaque(false);
				handCard[i].setBounds((i+1)*150, 500, 100, 200);
				if(calcul){
				if( p.getMyHand().getMyCards().get(i).getName() == "Cuivre")
					app.setJoueurOr(app.getJoueurOr()+1);
				if( p.getMyHand().getMyCards().get(i).getName() == "Argent")
					app.setJoueurOr(app.getJoueurOr()+2);
				if( p.getMyHand().getMyCards().get(i).getName() == "Or")
					app.setJoueurOr(app.getJoueurOr()+3);
				}
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
		all.revalidate();
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
		
		if(p.getMyDiscard().getTopCard()!=null)
		{
			cardDiscard.removeAll();
			cardDiscard.repaint();
			cardDiscard = new DisplayCard();
			cardDiscard.updateDisplayCard(0,app.getbG().getMyPlayers().get(0).getMyDiscard().getTopCard().getName(),app.getiM());
			cardDiscard.setOpaque(false);
			cardDiscard.setBounds(10, 450, 100, 200);
			app.getAll().add(cardDiscard,new Integer(17));
			app.getAll().revalidate();
		}
		else
		{
			cardDiscard.removeAll();
			cardDiscard.repaint();
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
                handCard[l.getMyId()].setVisible(false);//enlève la carte à l'écran
                
                app.getbG().getMyPlayers().get(0).playCard(l.getMyId());
                played.add(handCard[l.getMyId()]);//on en fait une carte jouée
                
                app.revalidate();
            }
        });
		}
	}
}
