package de.eiting.ressourceLoader;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class RessourceArchive {
	public static ImageProxy load(String filename) {
		ImageProxy proxy = new ImageProxy();
		
		new Thread(new ImageLoader(proxy, filename)).start();
		
		return proxy;
	}

}
