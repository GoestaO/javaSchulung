package com.goesta.threadexcercise;

public class Counter implements Runnable {

	private int counter = 1;
	private String name;
	

	public Counter(String name) {
		this.name = name;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		while (counter < 2001) {
			System.out.println("Name: " + name + "; Zähler: " + counter);
			counter++;
		}

	}

}
