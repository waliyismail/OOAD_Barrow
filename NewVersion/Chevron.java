import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Chevron moves in an L shape: 2 steps in one direction then 1 step perpendicular to it.
 * (Similar to the Knight in the normal chess.) 
 * It is the only piece that can skip over the other pieces.
 * @author WaliyIsmail
 *
 */
public class Chevron extends ChessPiece{
        int x ,y;
	public Chevron(String name, String color, int xCoord, int yCoord) {
		super(name, color, xCoord, yCoord);
		// TODO Auto-generated constructor stub
		
		this.x=xCoord;
		this.y=yCoord;
		generateMoves() ;
		getAvailableMoves();
		
	}
	
	@Override
	public void generateMoves() 
	{
	    
	availableMoves.clear();
	
	availableMoves.add(new Point(x-2, y+1));
        availableMoves.add(new Point(x+2, y+1));
        
        availableMoves.add(new Point(x+1, y+2));
        availableMoves.add(new Point(x-1, y+2));
        
        availableMoves.add(new Point(x+2, y-1));
        availableMoves.add(new Point(x-2, y-1));
        
        availableMoves.add(new Point(x+1, y-2));
        availableMoves.add(new Point(x-1, y-2));
		
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

		return availableMoves;
	}
     
}
