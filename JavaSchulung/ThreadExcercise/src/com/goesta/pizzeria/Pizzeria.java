package com.goesta.pizzeria;

import java.util.ArrayList;

public class Pizzeria implements Runnable {

	private final String[] PIZZAS = new String[] { "Salami", "Margharita",
			"Calzone" };

	private final ArrayList<String> pizzaList;

	public Pizzeria(ArrayList<String> pizzaList) {
		this.pizzaList = pizzaList;
	}

	public synchronized ArrayList<String> makePizza(ArrayList<String> pizzaList) {
		int randomInt = (int) (Math.random() * 3);
		String pizza = PIZZAS[randomInt];
		pizzaList.add(pizza);
		System.out.println("Pizza " + pizza + " prepared. New list size is "
				+ pizzaList.size());
		return pizzaList;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (pizzaList) {
				makePizza(pizzaList);
				pizzaList.notify();
			}
			try {
				Thread.sleep((long) (5000 * Math.random() + 1));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
