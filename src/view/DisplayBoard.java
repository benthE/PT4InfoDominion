package view;

import model.boardGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.boardGame;

public class DisplayBoard{
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
<<<<<<< HEAD
        	board[i] = new JPanel();
        	board[i].setOpaque(false);
	        if (i>nbCard-4)//Carte trï¿½sor
	    		board[i].setBounds(780, (i-13)*50, 100, 200);
=======
        	dc[i] = new DisplayCard();
        	dc[i].addMouseListener(this);
        	dc[i].setOpaque(false);
	        if (i>nbCard-4)//Carte trésor
	    		dc[i].setBounds(780, (i-13)*50, 100, 200);
>>>>>>> f82e8ed487144ef17b4c90347c9750e5245c4adc
	        else if (i>nbCard-8)//Carte Victoire
	    		dc[i].setBounds(130, (i-9)*50, 100, 200);
	        else if(i>nbCard-13)//2eme ligne de carte action
	        	dc[i].setBounds(150+((i-4)*100), 240, 100, 200);
	        else
	        	dc[i].setBounds(150+((i+1)*100), 20, 100, 200);
        }
	}
	
	public void UpdateBoard(JLayeredPane all, boardGame bG, final ImageManager img) {
		/**
		 * Affichage plateau
		 */
<<<<<<< HEAD
=======
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
>>>>>>> f82e8ed487144ef17b4c90347c9750e5245c4adc

        for(int i=0; i<nbCard; i++)
        {
            card[i] = new JLabel(img.getMyImgs().get(bG.getMyCards().get(i).getMyCard().getName()));
            card[i].setName(bG.getMyCards().get(i).getMyCard().getName());
            board[i].add(card[i]);
            all.add(board[i],new Integer(i+1));//i "+1" car le fond est en 0.
        }
		/*On ajoute les listeners aux cartes contenues dans card[]*/
        for (int i=0; i<card.length; i++){
            card[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println(e.getSource().toString());
                    JLabel l = (JLabel) e.getSource();

                    Application app = new Application();
                    app.getBigCardPanel().setVisible(true);
                    //ImageIcon nn = (ImageIcon) l.getIcon();
//                    l.setIcon(img.getMyImgs().get(l.getName()+"BIG"));


                    //ImageIcon ll = new ImageIcon(nn.getImage().getScaledInstance(300,500,Image.SCALE_DEFAULT));
                    app.getBigCard().setIcon(img.getMyImgs().get(l.getName()+"BIG"));
                }
            });
            card[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    System.out.println(e.getSource().toString());
                    JLabel l = (JLabel) e.getSource();
                    Application app = new Application();
                    app.getBigCardPanel().setVisible(false);
                }
            });
        }
    }
}
