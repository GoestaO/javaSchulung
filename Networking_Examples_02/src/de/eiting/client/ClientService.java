package de.eiting.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import de.eiting.shared.SystemData;
import de.eiting.shared.SystemObject;
import de.eiting.shared.Vector2;

public class ClientService implements Runnable {
	private Socket connection = null;
	private SystemData data = null;
	private BufferedReader br = null;
	private boolean isRunning = true;
	
	
	public ClientService(Socket connection, SystemData data) {
		this.connection = connection;
		this.data = data;
	}
	
	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String message = null;
		
		if(br != null){
			while(isRunning){
				try {
					message = br.readLine();
					
					System.out.println(message);
					
					String[] arguments = message.split(",");
					
					switch (arguments[0]) {
					case "ADDED_OBJECT":
						SystemObject so = new SystemObject(Integer.parseInt(arguments[1]));
						
						so.setPosition(new Vector2(Double.parseDouble(arguments[2]), Double.parseDouble(arguments[3])));
						
						data.add(so);
						break;
					case "REMOVE_OBJECT":
						boolean isSearching = true;
						int ID = Integer.parseInt(arguments[1]);
					
						for (int index = 0; index < data.getSystemObjectCount() && isSearching; index++) {
							if(data.getSystemObject(index).ID == ID){
								data.remove(index);
								
								isSearching = false;
							}
						}
						break;
					default:
						break;
					}
				} catch (IOException e) {
					e.printStackTrace();
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
