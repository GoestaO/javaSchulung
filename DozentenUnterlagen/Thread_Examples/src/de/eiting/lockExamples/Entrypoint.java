package de.eiting.lockExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class Entrypoint {
	public static int counter = 0;
	
	public static void main(String[] args) {
		ExecutorService tp = Executors.newFixedThreadPool(3);
		
		tp.execute(new ExampleThread("Franz"));
		tp.execute(new ExampleThread("Benny"));
		tp.execute(new ExampleThread("Mark"));
	}
}
