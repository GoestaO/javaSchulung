package com.goesta.threadexcercise;

public class ThreadImplementation {
	public static void main(String[] args) {

		// Thread c1 = new Thread(new Counter("Thread 1"));
		//
		// Thread c2 = new Thread(new Counter("Thread 2"));
		//
		// c1.start();
		// c2.start();

		CounterThread c1 = new CounterThread("Thread 1");
		CounterThread c2 = new CounterThread("Thread 2");

		c1.start();
		c1.goSuspended();
		c1.resumeThread();
		c1.goToSleep(5000);
		
//		c2.start();
//		c2.
	}
}
