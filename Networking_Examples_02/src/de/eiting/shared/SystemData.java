package de.eiting.shared;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SystemData {
	private final List<SystemObject> OBJECTS = new ArrayList<SystemObject>();
	private final HashSet<SystemObjectListener> SO_LISTENERS = new HashSet<SystemObjectListener>();
	
	
	public void add(SystemObject obj){
		OBJECTS.add(obj);
		
		for (SystemObjectListener listener : SO_LISTENERS) {
			listener.onObjectAddition(obj);
		}
	}
	
	public void remove(SystemObject obj){
		OBJECTS.remove(obj);
		
		for (SystemObjectListener listener : SO_LISTENERS) {
			listener.onObjectRemoval(obj);
		}
	}
	
	public void remove(int index){
		SystemObject so = OBJECTS.remove(index);
		
		for (SystemObjectListener listener : SO_LISTENERS) {
			listener.onObjectRemoval(so);
		}
	}
	
	public void add(SystemObjectListener sol){
		SO_LISTENERS.add(sol);
	}
	
	public void remove(SystemObjectListener sol){
		SO_LISTENERS.remove(sol);
	}
	
	public int getSystemObjectCount(){
		return OBJECTS.size();
	}
	
	public SystemObject getSystemObject(int index){
		return OBJECTS.get(index);
	}
}
