package de.eiting.Philosophen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Entrypoint {
	public static void main(String[] args) {

		Plate plate = new Plate(100);
		Table theTable = new Table(plate);

		Philosoph p1 = new Philosoph("Platon", theTable);
		Philosoph p2 = new Philosoph("Aristoteles", theTable);
		Philosoph p3 = new Philosoph("Precht", theTable);
		Philosoph p4 = new Philosoph("Hegel", theTable);
		Philosoph p5 = new Philosoph("Karl Marx", theTable);

		p1.setNext(p2);
		p2.setNext(p3);
		p3.setNext(p4);
		p4.setNext(p5);
		p5.setNext(p1);

		ExecutorService restaurantManager = Executors.newFixedThreadPool(5);

		restaurantManager.submit(p1);
		restaurantManager.submit(p2);
		restaurantManager.submit(p3);
		restaurantManager.submit(p4);
		restaurantManager.submit(p5);
		restaurantManager.shutdown();
	}
}
