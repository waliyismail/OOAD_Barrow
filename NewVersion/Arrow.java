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
	private static int turn = 1;

	
	public Arrow(String name, String color, int xCoord, int yCoord, String orientation) {
		super(name, color, xCoord, yCoord);
		this.orientation = orientation;
	}

	@Override
	public void generateMoves() {
		// TODO Auto-generated method stub
		availableMoves.clear();
		if( (turn == 1 && this.color == blue) ){
			availableMoves.add(new Point(xCoord, yCoord+1));
       			availableMoves.add(new Point(xCoord, yCoord+2));
		}
		
		if( (turn == 1 && this.color == red) ){
			availableMoves.add(new Point(xCoord, yCoord-1));
       			availableMoves.add(new Point(xCoord, yCoord-2));
		}
		
		if( (turn == 2 && this.color == blue) ){
			availableMoves.add(new Point(xCoord, yCoord-1));
       			availableMoves.add(new Point(xCoord, yCoord-2));
		}
		
		if( (turn == 2 && this.color == red) ){
			availableMoves.add(new Point(xCoord, yCoord+1));
       			availableMoves.add(new Point(xCoord, yCoord+2));
		}
	}

	@Override
	public ArrayList<Point> getAvailableMoves() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//to be called when flipping the board
	public void changeArrowMovement(){
		if(Arrow.turn == 1){
			Arrow.turn = 2;
		}
		else{
			Arrow.turn = 1;
		}
	}
}
