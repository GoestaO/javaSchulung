package com.goesta.swingworkerExample;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class AnswerWorker extends SwingWorker<Integer, Integer> {
	private JFrame frame = null;

	public AnswerWorker(JFrame frame) {
		this.frame = frame;
	}

	public JFrame getF() {
		return frame;
	}

	public void setF(JFrame frame) {
		this.frame = frame;
	}

	protected Integer doInBackground() throws Exception {
		// Do a time-consuming task.
		Thread.sleep(1000);
		return 42;
	}

	protected void done() {
		try {
			JOptionPane.showMessageDialog(frame, get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
