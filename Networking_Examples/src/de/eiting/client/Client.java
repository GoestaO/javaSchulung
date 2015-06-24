package de.eiting.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
	private Socket connection = null;
	private int port;
	private String ip;
	private PrintStream ps = null;
	private BufferedReader br = null;
	private boolean isRunning = true;

	public Client(int port, String ip) {
		this.port = port;
		this.ip = ip;
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
			try {
				br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				ps = new PrintStream(connection.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("reader and writer established");
			
			if(br != null && ps != null){
				Scanner input = new Scanner(System.in);
				
				while(isRunning){
					String message = input.nextLine();					
					ps.println(message);					
					try {
						message = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}					
					System.out.println(message);
				}
			}
		}
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

}
