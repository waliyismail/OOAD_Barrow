// Memento Design Pattern
// Used stores an objects state at a point in time
// so it can be returned to that state later. It
// simply allows you to undo/redo changes on an Object

public class Memento {
	
	// The game stored in memento Object
	
	private GameState gameState;

	// Save a new article String to the memento Object
	
	public Memento(GameState g) { gameState = g; }
	
	// Return the value stored in article 
	
	public GameState getSavedGame() { return gameState; }
	
}