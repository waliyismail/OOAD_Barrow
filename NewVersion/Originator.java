// Memento Design Pattern
// Sets the game state and store in memento
public class Originator{
	
	// All game setup here
	private GameState gameState;

	// Sets the value for the article
	
	public void saveGame(GameState newGameState) { 
		
	    this.gameState = newGameState; 
	}

	// Creates a new Memento with a new game
	
	public Memento storeInMemento() { 
	    
	    return new Memento(gameState); 
	}
	   
	// Gets the article currently stored in memento
	
	public GameState restoreFromMemento(Memento memento) {
		   
		gameState = memento.getSavedGame(); 
		
		return gameState;
	   
	}
	
}