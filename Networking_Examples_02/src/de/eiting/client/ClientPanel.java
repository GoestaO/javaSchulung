package de.eiting.client;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import de.eiting.shared.SystemData;
import de.eiting.shared.SystemObject;

public class ClientPanel extends JPanel{
	private SystemData data = null;
	
	public ClientPanel(SystemData data) {
		this.data = data;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.RED);
		
		for (int index = 0; index < data.getSystemObjectCount(); index++) {
			SystemObject so = data.getSystemObject(index);
			
			g.fillRect((int)(so.getPosition().x - 8), (int)(so.getPosition().y - 8), 16, 16);
		}
	}
}
