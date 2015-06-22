package de.eiting.synchronizeds;

import java.util.ArrayList;

public class Data {
	private ArrayList<String> characters = new ArrayList<String>();

	public void addCharacter(String character){
		synchronized (characters) {
			characters.add(character);	
		}
	}
	
	public void computateCharacter(int  index){
		String character = null;
		
		synchronized (characters) {
			character = characters.get(index);
		}

		for (int i = 0; i < 1000; i++) {
			character+= "a";
		}
	}
}
