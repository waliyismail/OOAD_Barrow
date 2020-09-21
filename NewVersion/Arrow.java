import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
/**
 * The Arrow can only move 1 or 2 steps forward each time,
 * but when it reaches the other edge of the board,
 * it turns around and heads back in the opposite direction.
 * (The icon should also turn around when that happens.)
 * @author waliyismail
 *
 */
public class Arrow extends ChessPiece {
	//Used to determine the way of moving
	private int moveType;

	
	public Arrow(String name, String color, int xCoord, int yCoord, String orientation, int moveType) {
		super(name, color, xCoord, yCoord);
		this.orientation = orientation;
		this.moveType = moveType
	}

	@Override
	public void generateMoves() {
		// TODO Auto-generated method stub
		availableMoves.clear();
		if( this.moveType == 1 ){
			availableMoves.add(new Point(xCoord, yCoord+1));
       			availableMoves.add(new Point(xCoord, yCoord+2));
		}
		
		if( this.moveType == 2 ){
			availableMoves.add(new Point(xCoord, yCoord-1));
       			availableMoves.add(new Point(xCoord, yCoord-2));
		}
		
		 // Iterate through all illegal possible moves (eg. a move that is outside the grid) and remove them	
		Iterator<Point> iter = availableMoves.iterator();
		
		while(iter.hasNext()){
			Point move = iter.next();
       			if(move.x > 7 || move.x < 0 || move.y > 8 || move.y < 0){
        	        	iter.remove();
          		}
		}
        }	

	@Override
	public ArrayList<Point> getAvailableMoves() {
		// TODO Auto-generated method stub
		return this.availableMoves;
	}
	
	//to be called when flipping the board
	public void changeArrowMovement(){
		if ( this.moveType == 1 ){
			this.moveType = 2;
		}
		
		if( this.moveType == 2 ){
			this.moveType = 1;
		}
	}
}
