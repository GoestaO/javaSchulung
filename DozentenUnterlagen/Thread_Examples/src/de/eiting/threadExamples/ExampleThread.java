package de.eiting.threadExamples;

public class ExampleThread extends Thread {
	private static int counter = 0;
	private String name ;
	private boolean isRunning = true;
	
	public ExampleThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		while (isInterrupted() == false) {
			System.out.println(name + " " + counter);
			counter++;
			
		}
	}
	
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
}
