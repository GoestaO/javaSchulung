package de.eiting.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;

import de.eiting.shared.SystemData;

public class Client implements Runnable {
	private Socket connection	= null;
	private int port;
	private String ip;
	private PrintStream ps		= null;
	private boolean isRunning	= true;
	private JFrame frame		= null;
	private SystemData data 	= new SystemData();

	public Client(int port, String ip) {
		this.port = port;
		this.ip = ip;
		
		frame = new JFrame();
		frame.setSize(400, 400);
		frame.setTitle("Client");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new ClientPanel(data));
		
		frame.setVisible(true);
		
		RepaintManager rm = new RepaintManager(frame);
		
		Thread t = new Thread(rm);
		
		t.start();
	}

	@Override
	public void run() {
		

		try {
			connection = new Socket(ip, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("connection established ...");
		
		if(connection != null){
			ClientService cs = new ClientService(connection, data);
			
			Thread t = new Thread(cs);
			
			t.start();
		}
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

}
