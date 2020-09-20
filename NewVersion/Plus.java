import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 * The Plus can move any number of steps up and down, or left and right.
 * @author waliyismail
 *
 */
public class Plus extends ChessPiece {

	int x ,y;
	public Plus(String name, String color, int xCoord, int yCoord) {
		super(name, color, xCoord, yCoord);
		this.x=xCoord;
		this.y=yCoord;
		generateMoves() ;
		getAvailableMoves();
	}

	@Override
	public void generateMoves() {
		availableMoves.clear();
	
	
		
	
		
	// Iterate through all illegal possible moves (eg. a move that is outside the grid) and remove them	
        Iterator<Point> iter = availableMoves.iterator();

        while(iter.hasNext()){
            Point move = iter.next();
            if(move.x > 7 || move.x < 0 || move.y > 8 || move.y < 0){
                iter.remove();
		
	}

	@Override
	public ArrayList<Point> getAvailableMoves() {
		// TODO Auto-generated method stub
		return availableMoves;
	}

}
