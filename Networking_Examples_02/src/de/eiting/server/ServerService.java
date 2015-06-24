package de.eiting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import de.eiting.shared.SystemData;
import de.eiting.shared.SystemObject;
import de.eiting.shared.SystemObjectListener;

public class ServerService implements Runnable, SystemObjectListener {
	private Socket client = null;
	private boolean isRunning = true;
	private BufferedReader br = null;
	private PrintStream ps = null;
	private final List<SystemObject> ADDED_OBJECTS = new ArrayList<SystemObject>();
	private final List<SystemObject> REMOVED_OBJECTS = new ArrayList<SystemObject>();
	private SystemData data;

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public ServerService(Socket client, SystemData data) {
		this.client = client;
		this.data = data;		
		this.data.add(this);
	}

	@Override
	public void run() {
		
		
		if(client != null){
			try {
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				ps = new PrintStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(br != null && ps != null){
				while(isRunning ){
					for (int index = 0; index < REMOVED_OBJECTS.size(); index++) {
						ps.println("REMOVED_OBJECT,"+ REMOVED_OBJECTS.get(index).ID);
					}
					
					REMOVED_OBJECTS.clear();
					
					for (int index = 0; index < ADDED_OBJECTS.size(); index++) {
						ps.println("ADDED_OBJECT,"+ ADDED_OBJECTS.get(index).ID +"," + ADDED_OBJECTS.get(index).getPosition().x +"," + ADDED_OBJECTS.get(index).getPosition().y);
					}
					
					ADDED_OBJECTS.clear();
				
					
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
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

	@Override
	public void onObjectAddition(SystemObject obj) {
		ADDED_OBJECTS.add(obj);
	}

	@Override
	public void onObjectRemoval(SystemObject obj) {
		REMOVED_OBJECTS.add(obj);
	}

}
