package de.eiting.Philosophen;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Philosoph implements Runnable {
	private boolean isSittingAtTable = true;
	private String name = null;
	private Table table = null;

	private Fork myFork = null;
	private Philosoph next = null;
	private ReentrantReadWriteLock lockObj = new ReentrantReadWriteLock();

	public Philosoph(String name, Table table) {
		this.name = name;
		this.table = table;
		this.myFork = new Fork();
	}

	@Override
	public void run() {
		System.out
				.println("Der Philospoh " + name + " setzt sich an den Tisch");
		while (isSittingAtTable) {
			System.out.println(name + " möchte etwas essen ...");

			synchronized (myFork) {
				Plate plate = table.getPlate();
				myFork.setInUse(true);
				System.out.println(name + " nimmt sich seine Gabel ...");
				Fork theOtherFork = next.getMyFork();
				if (!theOtherFork.isInUse()) {
					synchronized (theOtherFork) {
						theOtherFork.setInUse(true);
						if (plate.getFoodAmount() > 0) {
							synchronized (plate) {
								lockObj.writeLock().lock();
								eat(plate);
								System.out.println(name + " isst etwas ...");
								lockObj.writeLock().unlock();
							}
						} else {
							System.out.println("Essen ist alle...");
							isSittingAtTable = false;	
						}
						try {
							Thread.sleep((long) (200 * Math.random()));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						theOtherFork.setInUse(false);
					}
					myFork.setInUse(false);
				} else {
					System.out.println(name + " sieht, dass " + next.name
							+ " seine Gabel benutzt und kann nicht essen...");
					myFork.setInUse(false);
					try {
						Thread.sleep((long) (100 * Math.random()));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println("TEST");

	}

	private Plate eat(Plate plate) {
		int foodLeft = plate.getFoodAmount();
		int consumedFood = 0;
		if (foodLeft > 3) {
			consumedFood = (int) (3 * Math.random() + 1);
		} else {
			consumedFood = (int) (foodLeft * Math.random() + 1);
		}
		plate.setFoodAmount(foodLeft - consumedFood);
		return plate;
	}

	public Philosoph getNext() {
		return next;
	}

	public void setNext(Philosoph next) {
		this.next = next;
	}

	public Fork getMyFork() {
		return myFork;
	}
}
