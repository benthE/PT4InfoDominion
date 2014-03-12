package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.boardGame;

public class DisplayBoard implements MouseListener{
	final static Integer nbCard = 17; 
    DisplayCard dc[];
    private int click=1;
    
	public DisplayBoard() {
		InitDisplayBoard();
	}

	public DisplayBoard(JLayeredPane all, boardGame bG, ImageManager img){
		InitDisplayBoard();
		UpdateBoard(all, bG, img);
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
	
	public void UpdateBoard(JLayeredPane all, boardGame bG, ImageManager img) {
		/**
		 * Affichage plateau
		 */
		for(int i=0; i<nbCard; i++)
        {
  			dc[i].updateDisplayCard(bG.getMyCards().get(i).getMyCard().getName(),img);
			all.add(dc[i],new Integer(i+1));//i "+1" car le fond est en 0.
       	}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		click++;
		DisplayCard source = new DisplayCard(new BorderLayout());
		source=(DisplayCard)e.getSource();
		//System.out.println(source.getComponents());
		
		if(click%2==0){
			source.setSize(400,800);
			source.updateBounds();
		source.setOpaque(true);}
		else
			source.setSize(100,200);
		
		source.revalidate();
		source.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Survol");
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
