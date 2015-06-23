package de.eiting.swingworker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class Kunibert extends SwingWorker<String, String> {
	private JButton theButton = null;
	private long startTime = 0;
	private JProgressBar bar = null;
	
	public Kunibert(JButton button, JProgressBar bar) {
		this.theButton = button;
		this.startTime = System.nanoTime();
		this.bar = bar;
	}
	
	@Override
	protected String doInBackground() throws Exception {
		System.out.println("START[ " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime)+ " ]");
		
		List<String> list = new ArrayList<String>();
		
		for (int i = 1; i < 11; i++) {
			
			list.add("!" + (11 - i) + "!");
			
			process(list);
			
			setProgress(i * 10);
			
			System.out.println("STEP[ " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime)+ " ]");
			
			Thread.sleep(1000);
		}

		System.out.println("END[ " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime)+ " ]");
		
		return null;
	}

	@Override
	protected void done() {
		System.out.println("DONE[ " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime)+ " ]");
		
		theButton.setText("BOOM");
	}
	
	@Override
	protected void process(List<String> chunks) {
		theButton.setText(chunks.get(0));
		
		chunks.clear();
	}
}
