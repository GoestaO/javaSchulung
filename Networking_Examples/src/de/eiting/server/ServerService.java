package de.eiting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerService implements Runnable {
	private Socket client = null;

	public ServerService(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		PrintStream ps = null;
		
		if(client != null){
			try {
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				ps = new PrintStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(br != null && ps != null){
				try {
					String message = br.readLine();
					
					message = "ECHO[ " + message + " ]";
					
					ps.println(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(ps != null){
				ps.close();
			}
	
			if(client != null){
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
