package view;

import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayCard extends JPanel {
	
	private JLabel myImg;
	private String myName="";
	private Integer myId=0;
	
	public DisplayCard() {
		super();
	}

	public void updateDisplayCard(Integer id, String name, ImageManager img) {
		myName=name;
		myId=id;
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

	/**
	 * @return the myImg
	 */
	public JLabel getMyImg() {
		return myImg;
	}

	/**
	 * @param myImg the myImg to set
	 */
	public void setMyImg(JLabel myImg) {
		this.myImg = myImg;
	}

	/**
	 * @return the myName
	 */
	public String getMyName() {
		return myName;
	}

	/**
	 * @param myName the myName to set
	 */
	public void setMyName(String myName) {
		this.myName = myName;
	}

	/**
	 * @return the myId
	 */
	public Integer getMyId() {
		return myId;
	}

	/**
	 * @param myId the myId to set
	 */
	public void setMyId(Integer myId) {
		this.myId = myId;
	}
}