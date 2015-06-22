package de.eiting.threadExamples;

public class Entrypoint {
	public static void main(String[] args) {
		ExampleThread e1 = new ExampleThread("Hugo");
		ExampleThread e2 = new ExampleThread("Anne");
		
		e1.start();
		e2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		e1.interrupt();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		e2.interrupt();
		
		
		System.out.println("Main Exit");
	}
}
