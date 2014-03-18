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
	
	public DisplayPlayer(){
		helpNbCard = new JLabel();
	}
	
	public DisplayPlayer(JLayeredPane all, Player p,ImageManager img, Application app)
	{
		helpNbCard = new JLabel();
		initDisplayPlayer(app);
	}
  
	public int calculGold(ArrayList<Card> c){
	int out = 0;
	for(int i=0; i<c.size(); i++ )
	{
		if( c.get(i).getName() == "Cuivre")
			out += 1;
		else if( c.get(i).getName() == "Argent")
			out+= 2;
		else if( c.get(i).getName() == "Or")
			out+= 3;
	}
	return out;
	}
	
	public void refreshGold(Application app){
		helpGold = new JLabel();
		helpGold.setText("Pièces d'or : " + app.getJoueurOr());
		helpGoldPanel = new JPanel();
		helpGoldPanel.add(helpGold);
		helpGoldPanel.setBounds(780, 400, 100, 30);
		app.getAll().add(helpGoldPanel, new Integer(5+3+8));
		app.getAll().revalidate();
	}
	
	public void initDisplayPlayer(final Application app){
		String nameTmp;

		int i;
		if(app.getbG().getMyPlayers().get(0).getMyHand().getMyCards().size()>0)
		{
			for( i = 0; i<app.getbG().getMyPlayers().get(0).getMyHand().getMyCards().size(); i++)
			{
				handCard[i] = new DisplayCard();
				handCard[i].updateDisplayCard(i,app.getbG().getMyPlayers().get(0).getMyHand().getMyCards().get(i).getName(),app.getiM());
				
				handCard[i].setOpaque(false);
				handCard[i].setBounds((i+1)*150, 500, 100, 200);
			
				app.getAll().add(handCard[i],new Integer(i+8));
				app.getAll().revalidate();
				app.getAll().add(handCard[i],new Integer(i+8));


			}
		handCard[i+1] = new DisplayCard();
		handCard[i+1].updateDisplayCard(i,"Dos",app.getiM());
		handCard[i+1].setOpaque(false);
		handCard[i+1].setBounds(10, 250, 100, 200);
		
		app.getAll().add(handCard[i+1],new Integer(i+1+8));
		
		handCard[i+2] = new DisplayCard();
		handCard[i+2].setBounds(50, 340, 20, 20);
		
		helpNbCard = new JLabel();
		helpNbCard.setText("" + app.getbG().getMyPlayers().get(0).getMyDeck().getMyCards().size());

		handCard[i+2].add(helpNbCard);
		app.getAll().add(handCard[i+2],new Integer(i+2+8));
		}
		else
		{
			for(int j=0; j<5; j++)
			{
				handCard[j].removeAll();
				handCard[j].repaint();	
			}
		}
		for( i = 0; i<app.getbG().getMyPlayers().get(0).getMyHand().getMyCards().size(); i++)
		{
		handCard[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                DisplayCard l = (DisplayCard) e.getSource();
                
                app.getBigCardPanel().setVisible(true);

                app.getBigCard().setIcon(app.getiM().getMyImgs().get(l.getMyName()+"BIG"));
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
                //app.getAll().add(played.get(played.size()-1));
                app.revalidate();
            }
        });
		}
	}
}
