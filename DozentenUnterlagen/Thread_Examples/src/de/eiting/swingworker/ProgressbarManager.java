package de.eiting.swingworker;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class ProgressbarManager extends SwingWorker {
	private Kunibert bert;
	private JProgressBar bar;
	private boolean isRunning = true;

	public ProgressbarManager(JProgressBar bar, Kunibert bert) {
		this.bert = bert;
		this.bar = bar;
		
		bar.setMaximum(100);
		bar.setMinimum(0);
	}

	@Override
	protected Object doInBackground() throws Exception {
		while(isRunning ){
			bar.setValue(bert.getProgress());
		}
		
		return null;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	public boolean isRunning(){
		return isRunning;
	}
}
