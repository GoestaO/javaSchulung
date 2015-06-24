package de.eiting.shared;

public interface SystemObjectListener {
	public abstract void onObjectAddition(SystemObject obj);
	public abstract void onObjectRemoval(SystemObject obj);
}
