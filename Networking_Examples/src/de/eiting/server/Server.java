package de.eiting.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	private int port;
	private boolean isRunning = true;

	public Server(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		ServerSocket server = null;
		while (isRunning) {
			try {
				server = new ServerSocket(port);
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (server != null) {
				while (isRunning) {
					System.out.println("SERVER - waiting for clients ...");

					Socket client = null;
					try {
						client = server.accept();
					} catch (IOException e) {
						e.printStackTrace();
					}

					if (client != null) {
						System.out
								.println("SERVER - client found, starting service ...");
						ServerService service = new ServerService(client);

						Thread t = new Thread(service);

						t.start();
					}
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
