package de.eiting.ressourceLoader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageLoader implements Runnable {
	public static final HashMap<String, WeakReference<BufferedImage>> IMAGES = new HashMap<String, WeakReference<BufferedImage>>();
	
	private ImageProxy proxy = null;
	private String filename = null;
	
	public ImageLoader(ImageProxy proxy, String filename) {
		this.proxy = proxy;
		this.filename = filename;
	}
	
	@Override
	public void run() {
		BufferedImage image = null;
		
		try {
			Thread.sleep((long) (5000 * Math.random()));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(!IMAGES.containsKey(filename) || (IMAGES.containsKey(filename) && IMAGES.get(filename).get() == null)){	
			try {
				image = ImageIO.read(new File(filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			IMAGES.put( filename, new WeakReference<BufferedImage>(image));
		} else {
			image = IMAGES.get(filename).get();
		}
		
		proxy.setImage(image);
	}

}
