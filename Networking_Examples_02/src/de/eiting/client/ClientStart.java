package de.eiting.client;

public class ClientStart {
	public static void main(String[] args) {
		Client c = new Client(80, "127.0.0.1");
		
		Thread t = new Thread(c);
		
		t.start();
	}
}
