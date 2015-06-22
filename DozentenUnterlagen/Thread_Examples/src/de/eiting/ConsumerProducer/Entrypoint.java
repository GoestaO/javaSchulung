package de.eiting.ConsumerProducer;

import java.util.ArrayList;

public class Entrypoint {
	public static void main(String[] args) {
		ArrayList<String> stringList = new ArrayList<String>();
		
		Producer p =new Producer(stringList);
		
		p.start();
		
		Consumer c1 = new Consumer(stringList);
		Consumer c2 = new Consumer(stringList);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		t1.start();
		t2.start();
	}
}
