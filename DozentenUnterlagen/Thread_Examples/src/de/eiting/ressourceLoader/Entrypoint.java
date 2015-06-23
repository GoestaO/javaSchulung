package de.eiting.ressourceLoader;

import java.awt.Point;

public class Entrypoint {
	public static void main(String[] args) {
		ExampleFrame frame = new ExampleFrame();
		
		Thread t = new Thread(frame);
		
		t.start();
		
		frame.addImage("file_01.png", new Point(32, 32));
		frame.addImage("file_01.png", new Point(256, 256));
		frame.addImage("file_02.png", new Point(256, 128));
		frame.addImage("file_03.png", new Point(512, 32));
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		frame.removeImage(2);
	}
}
