package view;

import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayCard extends JPanel {
	
	private JLabel myImg;
	private String myName;
	
	public DisplayCard() {
		super();
	}

	public void updateDisplayCard(String name, ImageManager img) {
		myName=name;
		myImg = new JLabel(img.getMyImgs().get(name));
		
		this.add(myImg);
	}
	
	//fonctionne aps
	public void updateBounds(){
		myImg.setBounds(this.getBounds());
	}
	
	public DisplayCard(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public DisplayCard(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public DisplayCard(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	//surcharge
	/*
	public void setSize(int w, int h){
		//setSize(w,h);
		//this.removeAll();
		myImg.setSize(w, h);
		myImg.validate();
		this.add(myImg);
		
	}*/
}
