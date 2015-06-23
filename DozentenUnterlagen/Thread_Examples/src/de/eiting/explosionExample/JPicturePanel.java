package de.eiting.explosionExample;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class JPicturePanel extends JPanel {
	private Image image = null;
	private Color borderColor = Color.BLACK;

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	@Override
	public void paint(Graphics g) {
		if(image != null){
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}
		
		g.setColor(borderColor);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
