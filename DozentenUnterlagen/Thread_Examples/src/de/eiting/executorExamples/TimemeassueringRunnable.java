package de.eiting.executorExamples;

import java.util.concurrent.TimeUnit;

public class TimemeassueringRunnable implements Runnable {
	private long startTime = 0;
	
	public TimemeassueringRunnable() {
		startTime = System.nanoTime();
	}

	@Override
	public void run() {
		System.out.println("Time since start in secconds: " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime));
	}
}
