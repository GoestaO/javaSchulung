package de.eiting.joinexample;

public class Entrypoint {
	public static void main(String[] args) {
		JoinThread jt = new JoinThread();
		
		jt.start();
		
		try {
			jt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main Thread end");
	}
}
