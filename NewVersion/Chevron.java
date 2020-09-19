import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 * The Chevron moves in an L shape: 2 steps in one direction then 1 step perpendicular to it.
 * (Similar to the Knight in the normal chess.) 
 * It is the only piece that can skip over the other pieces.
 * @author WaliyIsmail
 *
 */
public class Chevron extends ChessPiece{

	public Chevron(String name, String color, int xCoord, int yCoord) {
		super(name, color, xCoord, yCoord);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void generateMoves() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Point> getAvailableMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
