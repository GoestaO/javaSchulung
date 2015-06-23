package com.goesta.pizzeria;

import java.util.ArrayList;

public class EntryPoint {

	public static void main(String[] args) {

		ArrayList<String> pizzaList = new ArrayList<>();

		Pizzeria p = new Pizzeria(pizzaList);
		Thread pizzaThread = new Thread(p);
		pizzaThread.start();

		FatGerman fg1 = new FatGerman("Werner", pizzaList);
		Thread fatGermanThread1 = new Thread(fg1);
		fatGermanThread1.start();
		fatGermanThread1.start();

		
		FatGerman fg2 = new FatGerman("Kalle", pizzaList);
		Thread fatGermanThread2 = new Thread(fg2);
		fatGermanThread2.start();

	}

}
