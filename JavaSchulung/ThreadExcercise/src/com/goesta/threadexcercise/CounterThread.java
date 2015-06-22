package com.goesta.threadexcercise;

public class CounterThread extends Thread {

	private int counter = 1;

	private long sleepTime = 0;

	private boolean isRunning = true;

	private boolean isSleeping = false;

	private boolean isSuspended = false;

	// Getter & Setter
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public boolean isSleeping() {
		return isSleeping;
	}

	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public boolean isSuspended() {
		return isSuspended;
	}

	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	// Konstruktor
	public CounterThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Ich laufe...");
			if (isSleeping) {
				System.out.println(this.getName() + ": Ich schlafe...");
				try {
					Thread.sleep(sleepTime);
					System.out.println(this.getName() + ": Bin wieder wach...");
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}

			isSleeping = false;

			while (isSuspended) {
				System.out.println(this.getName() + ": Ich pausiere...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				System.out.println("Ich laufe wieder...");
			}

		}
	}

	public void goToSleep(long millis) {
		isSleeping = true;
		sleepTime = millis;
	}

	public void goSuspended() {
		isSuspended = true;
	}

	public void resumeThread() {
		isSuspended = false;
		
	}
}
