package de.eiting.shared;

import java.awt.Point;

public class SystemObject {
	private static int IDCounter = 0;
	
	public final int ID;
	private Vector2 position = Vector2.ZERO;
	
	public SystemObject(double x, double y) {
		this.ID = IDCounter;
		this.position = new Vector2(x, y);
		
		IDCounter++;
	}
	
	public SystemObject(int ID){
		this.ID = ID;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}
}
