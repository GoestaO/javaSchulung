package de.eiting.explosionExample;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.SwingWorker;

public class CountdownWorker extends SwingWorker<BufferedImage, BufferedImage>{
	private JPicturePanel jpp = null;
	
	public CountdownWorker(JPicturePanel jpp) {
		this.jpp = jpp;
	}
	
	@Override
	protected BufferedImage doInBackground() throws Exception {
		List<BufferedImage> images = new ArrayList<BufferedImage>();
		
		for (int i = 10; i > 0; i--) {
			BufferedImage image = ImageIO.read(new File("boom_" + i + ".png"));
			
			images.add(image);
			
			process(images);

			Thread.sleep(1000);
		}

		return null;
	}
	
	@Override
	protected void done() {
		List<BufferedImage> images = new ArrayList<BufferedImage>();		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("boom_0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		images.add(image);
		process(images);
	}
	
	@Override
	protected void process(List<BufferedImage> chunks) {
		jpp.setImage(chunks.get(0));		
		jpp.repaint();		
		chunks.clear();
	}
}
