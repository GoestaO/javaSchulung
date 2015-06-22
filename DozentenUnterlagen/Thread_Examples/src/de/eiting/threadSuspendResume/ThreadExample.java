package de.eiting.threadSuspendResume;

public class ThreadExample extends Thread {
	private boolean isSuspended = false;
	private boolean doSleep = false;
	private long sleepTime = 0;
	
	@Override
	public void run() {
		while(true){
			if(doSleep){
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				doSleep = false;
			}
			
			while(isSuspended){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("Running");
		}
	}
	
	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}
	
	public boolean getSuspended(){
		return isSuspended;
	}
	
	public void goToSleep(long millies){
		doSleep = true;
		
		sleepTime = millies;
	}
}
