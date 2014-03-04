package view;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Player;

public class DisplayPlayer{
	JLabel helpNbCard;
	JLabel handCardLabel[] = new JLabel[20];
	JPanel handCardPanel[] = new JPanel[20];
	
	DisplayPlayer(JLayeredPane all, Player p,ImageManager img, Application app)
	{
		String nameTmp;
		
		int i;
		for( i = 0; i<p.getMyHand().getMyCards().size(); i++)
		{
			handCardPanel[i] = new JPanel();
			handCardPanel[i].setBounds((i+1)*150, 500, 100, 200);
		
			nameTmp = p.getMyHand().getMyCards().get(i).getName();
			
			if( nameTmp == "Domaine")
				handCardLabel[i] = new JLabel(img.getMyImgs().get("Domaine"));
			else if( nameTmp == "Cuivre")
			{
				handCardLabel[i] = new JLabel(img.getMyImgs().get("Cuivre"));
				app.setJoueurOr(1);
			}
		
			handCardPanel[i].add(handCardLabel[i]);
			all.add(handCardPanel[i],new Integer(i+8));
		}
		handCardPanel[i+1] = new JPanel();
		handCardPanel[i+1].setBounds(10, 250, 100, 200);
		
		handCardLabel[i+1] = new JLabel(img.getMyImgs().get("Dos"));
		handCardPanel[i+1].add(handCardLabel[i+1]);
		all.add(handCardPanel[i+1],new Integer(i+1+8));
		
		handCardPanel[i+2] = new JPanel();
		handCardPanel[i+2].setBounds(50, 340, 20, 20);
		
		helpNbCard = new JLabel();
		helpNbCard.setText("" + p.getMyDeck().getMyCards().size());

		handCardPanel[i+2].add(helpNbCard);
		all.add(handCardPanel[i+2],new Integer(i+2+8));	
	}
}
