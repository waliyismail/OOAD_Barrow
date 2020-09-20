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


	
	public Arrow(String name, String color, int xCoord, int yCoord, String orientation) {
		super(name, color, xCoord, yCoord);
		this.orientation = orientation;
	}

	@Override
	public void generateMoves() {
		// TODO Auto-generated method stub
		availableMoves.clear();
		availableMoves.add(new Point(x, y+1));
       		availableMoves.add(new Point(x, y+2));
	}

	@Override
	public ArrayList<Point> getAvailableMoves() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
