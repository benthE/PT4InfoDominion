package displayClass;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class JImagePanel extends JPanel {

private static final long serialVersionUID = 2290135195657623822L;
private Image _image;
private int _x;
private int _y;
private boolean _autoSize; 
private boolean _keepAspect;

public JImagePanel(File file, int x, int y, boolean autoSize, boolean keepAspect) throws IOException {
	super();
	
	setImage(ImageIO.read(file));
	setX(x);
	setY(y);
	setAutoSize(autoSize);
	setKeepAspect(keepAspect);
}

public JImagePanel(File file, int x, int y, boolean autoSize) throws IOException {
	super();
	
	setImage(ImageIO.read(file));
	setX(0);
	setY(0);
	setAutoSize(autoSize);
	setKeepAspect(false);
}

public JImagePanel(File file, int x, int y) throws IOException {
	super();
	
	try
	{
		setImage(ImageIO.read(file));
	}catch (IOException ex) { 
		System.out.println("impossible de charger l'image");
	} 
	
	setX(x);
	setY(y);
	setAutoSize(false);
	setKeepAspect(false);
}

public JImagePanel(String fileName) throws IOException {
	super();
	
	try
	{
		setImage(ImageIO.read(new File(fileName)));
	}catch (IOException ex) { 
		System.out.println("impossible de charger l'image");
	} 

	setX(0);
	setY(0);
	setAutoSize(false);
	setKeepAspect(false);
}

public JImagePanel(Image image, int x, int y, boolean autoSize, boolean keepAspect) {
	super();
	
	setImage(image);
	setX(x);
	setY(y);
	setAutoSize(autoSize);
	setKeepAspect(keepAspect);
}

public JImagePanel(Image image, int x, int y, boolean autoSize) {
	this(image, x, y, true, false);
}

public JImagePanel(Image image, int x, int y) {
	this(image, x, y, true);
}

public JImagePanel(Image image) {
	this(image, 0, 0, true);
}

public JImagePanel() {
	super();
	setX(0);
	setY(0);
	setImage(null);
	setAutoSize(false);
}

public void setImage(Image image) {
	_image = image;
}

public void setX(int x) {
	_x = x;
}

public void setY(int y) {
	_y = y;
}

public void setAutoSize(boolean autoSize) {
	_autoSize = autoSize;
}

public void setKeepAspect(boolean keepAspect) {
	_keepAspect = keepAspect;
}

public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	if (_image != null) {
		if (!_autoSize) {
			g.drawImage(_image, _x, _y, _image.getWidth(null), _image.getHeight(null), null);
		}
		else {
			Graphics2D g2d = (Graphics2D) g;
			Double scaleWidth = new Double(getWidth()) / new Double(_image.getWidth(null));
			Double scaleHeight = new Double(getHeight()) / new Double(_image.getHeight(null));
			if (_keepAspect) {
				if (scaleWidth > scaleHeight) {
					scaleWidth = scaleHeight;
				}
				else {
					scaleHeight = scaleWidth;
				}
			}
			g2d.scale(scaleWidth, scaleHeight);
			g2d.drawImage(_image, _x, _y, null);
		}
	}
}

}