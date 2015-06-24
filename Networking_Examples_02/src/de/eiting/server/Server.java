package de.eiting.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import de.eiting.shared.SystemData;
import de.eiting.shared.SystemObject;

public class Server extends Thread{
	private int port;
	private boolean isRunning = true;
	private SystemData data = null;
	
	public Server(int port) {
		this.port = port;
		this.data = new SystemData();
	}
	
	@Override
	public void run() {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(server != null){
			while(isRunning){
				System.out.println("SERVER - waiting for clients ...");
				
				Socket client = null;
				try {
					client = server.accept();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if(client != null){
					System.out.println("SERVER - starting service ...");
					ServerService service = new ServerService(client, data);
					
					Thread t = new Thread(service);
					
					t.start();
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					data.add(new SystemObject(32,64));
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
