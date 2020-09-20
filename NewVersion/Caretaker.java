// saved game state in here

import java.util.ArrayList;

class Caretaker {
   
	// Where all mementos are saved
	
	ArrayList<Memento> savedGames = new ArrayList<Memento>();

	// Adds memento to the ArrayList
	
	public void addMemento(Memento m) { savedGames.add(m); }
   
	// Gets the memento requested from the ArrayList
	
	public Memento getMemento(int index) { return savedGames.get(index); }
} 