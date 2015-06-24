package de.eiting.client;

public class ClientStart {
	public static void main(String[] args) {
		Client c = new Client(80, "10.10.150.17");
		
		Thread t = new Thread(c);
		
		t.start();
	}
}
