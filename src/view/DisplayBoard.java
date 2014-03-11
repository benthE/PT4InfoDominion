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
	JPanel board[];
    JLabel card[];
    private int click=1;
    
	public DisplayBoard() {
		InitDisplayBoard();
	}

	public DisplayBoard(JLayeredPane all, boardGame bG, ImageManager img){
		InitDisplayBoard();
		UpdateBoard(all, bG, img);
	}
	
	public void InitDisplayBoard(){
		board = new JPanel[nbCard];
        card = new JLabel[nbCard];
        
        /**
         * Initialisation position carte plateau
         */
        for(int i=0; i<nbCard; i++)
        {
        	board[i] = new JPanel();
        	board[i].addMouseListener(this);
        	board[i].setOpaque(false);
	        if (i>nbCard-4)//Carte trésor
	    		board[i].setBounds(780, (i-13)*50, 100, 200);
	        else if (i>nbCard-8)//Carte Victoire
	    		board[i].setBounds(130, (i-9)*50, 100, 200);
	        else if(i>nbCard-13)//2eme ligne de carte action
	        	board[i].setBounds(150+((i-4)*100), 240, 100, 200);
	        else
	        	board[i].setBounds(150+((i+1)*100), 20, 100, 200);
        }
	}
	
	public void UpdateBoard(JLayeredPane all, boardGame bG, ImageManager img) {
		/**
		 * Affichage plateau
		 */
		for(int i=0; i<nbCard; i++)
        {
	        card[i] = new JLabel(img.getMyImgs().get(bG.getMyCards().get(i).getMyCard().getName()));
	        board[i].add(card[i]);
	        all.add(board[i],new Integer(i+1));//i "+1" car le fond est en 0.
       	}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		click++;
		JPanel source = new JPanel(new BorderLayout());
		source=(JPanel)e.getSource();
		//System.out.println(source.getComponents());
		
		if(click%2==0)
			source.setSize(400,800);
		
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
