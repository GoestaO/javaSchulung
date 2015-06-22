package de.eiting.runnableExample;

public class Entrypoint {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		
		Thread t = new Thread(mt);
		
		t.start();
	}
}
