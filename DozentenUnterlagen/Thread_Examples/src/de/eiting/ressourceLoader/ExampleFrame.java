package de.eiting.ressourceLoader;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

public class ExampleFrame extends JFrame implements Runnable {
	private final ArrayList<ImageProxy> IMAGES = new ArrayList<ImageProxy>();
	private final ArrayList<Point> POINTS = new ArrayList<Point>();

	public ExampleFrame() {
		setSize(1024, 768);
		setTitle("An example title");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		BufferedImage representation = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g2 = representation.getGraphics();
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, 1024, 768);

		for (int index = 0; index < IMAGES.size(); index++) {
			g2.drawImage(IMAGES.get(index).getImage(), POINTS.get(index).x,
					POINTS.get(index).y, null);
		}
		
		g.drawImage(representation, 0, 0, null);
	}

	public void addImage(String filename, Point position) {
		IMAGES.add(RessourceArchive.load(filename));

		POINTS.add(position);
	}

	@Override
	public void run() {
		while (true) {
			repaint();

			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("RESOURCES[ " + ImageLoader.IMAGES.size() + " ]" );
			
			ArrayList<String> keys = new ArrayList<String>(ImageLoader.IMAGES.keySet());
			
			for (String string : keys) {
				if(ImageLoader.IMAGES.containsKey(string) && ImageLoader.IMAGES.get(string).get() == null){
					ImageLoader.IMAGES.remove(string);
				}
			}
			
			System.gc();
			
			
		}
	}

	public void removeImage(int i) {
		IMAGES.remove(i);
		POINTS.remove(i);
	}
}
