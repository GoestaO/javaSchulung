package de.eiting.ConsumerProducer;

import java.util.ArrayList;

public class Producer extends Thread {
	private ArrayList<String> stringList = new ArrayList<String>();
	
	public Producer(ArrayList<String> stringList){
		this.stringList = stringList;
	}
	
	@Override
	public void run() {
		String s;
		
		while(true){
			synchronized (stringList) {
				s = "Wert " + Math.random();
				stringList.add(s);
				
				System.out.println("Produkt erzeugt[ " + s + " ]");
				
				stringList.notify();
			}
			
			try {
				Thread.sleep((long) (100 * Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
