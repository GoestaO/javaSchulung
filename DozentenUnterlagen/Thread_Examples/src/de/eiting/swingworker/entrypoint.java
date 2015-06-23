package de.eiting.swingworker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class entrypoint {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JProgressBar bar = new JProgressBar();
		
		frame.setLayout(null);
		
		frame.setSize(1024, 768);
		frame.setTitle("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = (JButton) frame.add(new JButton());
		
		button.setBounds(64, 64, 128, 32);
		button.setText("Start");
		
		bar.setBounds(64, 128, 128, 16);
		
		frame.add(bar);
		
		Kunibert k = new Kunibert(button, bar);
		ProgressbarManager pbm = new ProgressbarManager(bar, k);
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		service.submit(k);
		service.submit(pbm);
		
		frame.setVisible(true);
		
		
	}
}
