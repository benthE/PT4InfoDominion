package view;

import model.boardGame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.boardGame;

public class DisplayBoard implements MouseListener{
	final static Integer nbCard = 17; 
    DisplayCard dc[];
    private int click=1;
    
	public DisplayBoard() {
		InitDisplayBoard();
	}

	public DisplayBoard(Application app, boardGame bG, ImageManager img){
		InitDisplayBoard();
		UpdateBoard(app, bG, img);
	}
	
	public void InitDisplayBoard(){
		dc = new DisplayCard[nbCard];
		
		/**
         * Initialisation position carte plateau
         */
        for(int i=0; i<nbCard; i++)
        {
        	dc[i] = new DisplayCard();
        	dc[i].addMouseListener(this);
        	dc[i].setOpaque(false);
	        if (i>nbCard-4)//Carte trésor
	    		dc[i].setBounds(780, (i-13)*50, 100, 200);
	        else if (i>nbCard-8)//Carte Victoire
	    		dc[i].setBounds(130, (i-9)*50, 100, 200);
	        else if(i>nbCard-13)//2eme ligne de carte action
	        	dc[i].setBounds(150+((i-4)*100), 240, 100, 200);
	        else
	        	dc[i].setBounds(150+((i+1)*100), 20, 100, 200);
        }
	}
	
	public void UpdateBoard(final Application app,final boardGame bG, final ImageManager img) {
		/**
		 * Affichage plateau
		 */
        for(int i=0; i<nbCard; i++)
        {
            dc[i].updateDisplayCard(i,bG.getMyCards().get(i).getMyCard().getName(),img);
            app.getAll().add(dc[i],new Integer(i+1));//i "+1" car le fond est en 0.
        }
		/*On ajoute les listeners aux cartes contenues dans card[]*/
        for (int i=0; i<dc.length; i++){
            dc[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    //System.out.println(e.getSource().toString());
                    DisplayCard l = (DisplayCard) e.getSource();

                    //Application app = new Application();
                    app.getBigCardPanel().setVisible(true);

                    app.getBigCard().setIcon(img.getMyImgs().get(l.getMyName()+"BIG"));
                }
            });
            dc[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    DisplayCard l = (DisplayCard) e.getSource();
                    app.getBigCardPanel().setVisible(false);
                }
            });
            dc[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                   DisplayCard l = (DisplayCard) e.getSource();
                    if(bG.getMyCards().get(l.getMyId()).getMyCard().getPrice()<=app.getJoueurOr())
                    {
                    	app.setJoueurOr(app.getJoueurOr()-(bG.getMyCards().get(l.getMyId()).getMyCard().getPrice()));
                    	System.out.println("or joueur : " + app.getJoueurOr());
                    	bG.buyCard(l.getMyId());
                    	app.setJoueurOr(app.getDp().calculGold(bG.getMyPlayers().get(0).getMyHand().getMyCards()));
                    	app.getDp().refreshGold(app);
                    	app.revalidate();
                    }
                }
            });
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
