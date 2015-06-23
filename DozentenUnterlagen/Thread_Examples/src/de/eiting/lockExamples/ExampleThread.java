package de.eiting.lockExamples;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ExampleThread implements Runnable {
	private static int counter = 0;
	private static ReadLock readlock = null;
	private static WriteLock writelock = null;
	private static ReentrantReadWriteLock lock = null;
	
	private String name = null;
	
	static {
		lock = new ReentrantReadWriteLock();
		
		writelock = lock.writeLock();
		readlock = lock.readLock();
	}
	
	public ExampleThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int index = 0; index < 10; index++) {
			writelock.lock();
			int value = counter;
			
			
			System.out.println(name + ":" + value);
			writelock.unlock();
			
			counter++;
		}
	}

}
