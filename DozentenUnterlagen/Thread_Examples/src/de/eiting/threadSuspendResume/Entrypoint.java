package de.eiting.threadSuspendResume;

public class Entrypoint {
	public static void main(String[] args) {
		ThreadExample t1 = new ThreadExample();
		
		t1.start();
		
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		t1.setSuspended(true);
//		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		t1.setSuspended(false);
		
		t1.goToSleep(100000);
		
		System.out.println("Main Thread end");
	}
}
