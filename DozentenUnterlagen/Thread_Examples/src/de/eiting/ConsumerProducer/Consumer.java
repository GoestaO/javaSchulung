package de.eiting.ConsumerProducer;

import java.util.ArrayList;

public class Consumer implements Runnable{

	private ArrayList<String> stringList = null;
	
	public Consumer(ArrayList<String> stringList) {
		this.stringList = stringList;
	}
	
	@Override
	public void run() {
		while(true){
			synchronized (stringList) {
				if(stringList.size() < 1){
					try {
						stringList.wait();
					} catch (InterruptedException e) {
						
					}
				}
				
				System.out.println("Consumer found: " + stringList.get(0));
				
				stringList.remove(0);
				
				System.out.println("List size[ " + stringList.size() + " ]");
			}
			
			try {
				Thread.sleep((long)(100 *  Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
