package view;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class ImageManager {
	
	HashMap<String,ImageIcon> myImgs= new HashMap<String,ImageIcon>();
	
	public ImageManager() {
		initIM();
	}
	
	public void initIM() {
		/**
		 * Cartes Trésor
		 */
		myImgs.put("Cuivre",new ImageIcon(new ImageIcon("img/carteCuivre.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Argent",new ImageIcon(new ImageIcon("img/carteArgent.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Or",new ImageIcon(new ImageIcon("img/carteOr.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		
		/**
		 * Cartes Victoire
		 */
		myImgs.put("Domaine",new ImageIcon(new ImageIcon("img/carteDomaine.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Duche",new ImageIcon(new ImageIcon("img/carteDuche.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Province",new ImageIcon(new ImageIcon("img/carteProvince.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Malediction",new ImageIcon(new ImageIcon("img/carteMalediction.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		
		/**
		 * Cartes Action
		 */
		myImgs.put("Bucheron",new ImageIcon(new ImageIcon("img/carteBucheron.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Cave",new ImageIcon(new ImageIcon("img/carteCave.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Mine",new ImageIcon(new ImageIcon("img/carteMine.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Douves",new ImageIcon(new ImageIcon("img/carteDouves.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Milice",new ImageIcon(new ImageIcon("img/carteMilice.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Marche",new ImageIcon(new ImageIcon("img/carteMarche.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Forgeron",new ImageIcon(new ImageIcon("img/carteForgeron.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Atelier",new ImageIcon(new ImageIcon("img/carteAtelier.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		myImgs.put("Dos",new ImageIcon(new ImageIcon("img/dos.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
		/**
		 * Images Test
		 */
		myImgs.put("test",new ImageIcon("img/test.jpg"));
	}

	/**
	 * @return the myImgs
	 */
	public HashMap<String, ImageIcon> getMyImgs() {
		return myImgs;
	}

	/**
	 * @param myImgs the myImgs to set
	 */
	public void setMyImgs(HashMap<String, ImageIcon> myImgs) {
		this.myImgs = myImgs;
	}
}
