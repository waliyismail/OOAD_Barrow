import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Arrow can only move 1 or 2 steps forward each time,
 * but when it reaches the other edge of the board,
 * it turns around and heads back in the opposite direction.
 * (The icon should also turn around when that happens.)
 * @author waliyismail & Liew Chin Onn
 *
 */
public class Arrow extends ChessPiece {
	//Used to determine the way of moving
	private int moveType;

	//wrote by Liew Chin Onn. Constructor
	public Arrow(String name, String color, int xCoord, int yCoord, String orientation, int moveType) {
		super(name, color, xCoord, yCoord);
		this.orientation = orientation;
		this.moveType = moveType;
	}
	
	//wrote by Liew Chin Onn. Determine possible moves
	@Override
	public void generateMoves() {
		// TODO Auto-generated method stub
		availableMoves.clear();
		if( this.moveType == 1 ){
			availableMoves.add(new Point(this.getLocation().x-1, this.getLocation().y ));
       			availableMoves.add(new Point(this.getLocation().x-2, this.getLocation().y ));
		}
		
		if( this.moveType == 2 ){
			availableMoves.add(new Point(this.getLocation().x-1, this.getLocation().y ));
       			availableMoves.add(new Point(this.getLocation().x-2, this.getLocation().y ));
		}
		
		 // Iterate through all illegal possible moves (eg. a move that is outside the grid) and eliminate them	
		Iterator<Point> iter = availableMoves.iterator();
		
		while(iter.hasNext()){
			Point move = iter.next();
       			if(move.x > 7 || move.x < 0 || move.y > 8 || move.y < 0){
        	        	iter.remove();
          		}
			
		}
        }	

	//wrote by Liew Chin Onn
	@Override
	public ArrayList<Point> getAvailableMoves() {
		// TODO Auto-generated method stub
		return this.availableMoves;
	}
	
	////wrote by Liew Chin Onn. A method to be called when flipping the board to change the movement of arrow pieces
	public void changeArrowMovement(){
		if ( this.moveType == 1 ){
			this.moveType = 2;
		}
		
		if ( this.moveType == 2 ){
			this.moveType = 1;
		}
	}
	
	////wrote by Liew Chin Onn. check piece's location to see whether the Arrow piece is in the last roll, if so flip it
	public void checkLocation(){
		if ( this.getLocation().y == 8 ){
			this.changeArrowMovement();
			this.orientation = "down";
		}
		
		if ( this.getLocation().y == 1 ){
			this.changeArrowMovement();
			this.orientation = "up";
		}
	}
}
