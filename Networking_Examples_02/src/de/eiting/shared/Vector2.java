package de.eiting.shared;

public class Vector2 {
	public static final Vector2 ZERO = new Vector2(0, 0);
	public static final Vector2 UP = new Vector2(0, -1);
	public static final Vector2 DOWN = new Vector2(0, 1);
	public static final Vector2 LEFT = new Vector2(-1, 0);
	public static final Vector2 RIGHT = new Vector2(1, 0);
	
	
	public final double x;
	public final double y;
	
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

}
