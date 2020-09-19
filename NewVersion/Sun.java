import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
/**
 * The Sun can only move one step in any direction. 
 * The game ends when the Sun is captured by the other side.
 * @author WaliyIsmail
 *
 */
public class Sun extends ChessPiece{

	public Sun(String name, String color, int xCoord, int yCoord) {
		super(name, color, xCoord, yCoord);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void generateMoves() {
		// TODO generate the possible movement of sun (one step in any direction)
		Point p = new Point(1,1);
		this.availableMoves.add(p);
		
		
	}

	@Override
	public ArrayList<Point> getAvailableMoves() {
		// TODO Auto-generated method stub
		return this.availableMoves;
	}
}
