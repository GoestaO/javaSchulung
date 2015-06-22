package de.eiting.ressourceLoader;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImageProxy {
	private static final BufferedImage MISSING = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
	
	static {
		Graphics g = MISSING.getGraphics();
		
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, 32, 32);
	}
	
	private BufferedImage source = null;
	
	public BufferedImage getImage(){
		if(source != null){
			return source;
		} else {
			return MISSING;
		}
	}
	
	public void setImage(BufferedImage source){
		this.source = source;
	}
}
