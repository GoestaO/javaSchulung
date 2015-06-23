package com.goesta.pizzeria;

import java.util.ArrayList;

public class FatGerman implements Runnable {

	private final ArrayList<String> pizzaList;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FatGerman(String name, ArrayList<String> pizzaList) {
		this.name = name;
		this.pizzaList = pizzaList;
	}

	public synchronized ArrayList<String> eatPizza(ArrayList<String> pizzaList) {
		synchronized (pizzaList) {
			while (pizzaList.size() > 0) {
				String pizza = pizzaList.get(0);
				pizzaList.remove(0);
				System.out.println(this.name + ": I had a nice pizza "
						+ pizza + "; new list size is " + pizzaList.size());
			}
		}
		return pizzaList;

	}

	@Override
	public void run() {
		while (true) {
			eatPizza(pizzaList);
			try {
				Thread.sleep((int) (10000 * Math.random() + 1));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
