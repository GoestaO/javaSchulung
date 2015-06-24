package de.eiting.client;

import javax.swing.JFrame;

public class RepaintManager implements Runnable {
	private JFrame frame;
	private boolean isRunning = true;

	public RepaintManager(JFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void run() {
		while(isRunning){
			frame.repaint();
			
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
