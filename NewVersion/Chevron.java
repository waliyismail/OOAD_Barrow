import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Chevron moves in an L shape: 2 steps in one direction then 1 step perpendicular to it.
 * (Similar to the Knight in the normal chess.) 
 * It is the only piece that can skip over the other pieces.
 * @author WaliyIsmail and Ng Yoon Hin
 *
 */
public class Chevron extends ChessPiece{
        
	public Chevron(String name, String color, int xCoord , int yCoord, String orientation)
	{
		super(name, color, xCoord, yCoord);
		this.orientation = orientation;
		// TODO Auto-generated constructor stub
		
		
		generateMoves() ;
		getAvailableMoves();
		
	}
	
	@Override
	public void generateMoves() 
	{
	    
	availableMoves.clear();
	
	availableMoves.add(new Point(this.getLocation().x-2, this.getLocation().y+1));
        availableMoves.add(new Point(this.getLocation().x+2, this.getLocation().y+1));
        
        availableMoves.add(new Point(this.getLocation().x+1, this.getLocation().y+2));
        availableMoves.add(new Point(this.getLocation().x-1, this.getLocation().y+2));
        
        availableMoves.add(new Point(this.getLocation().x+2, this.getLocation().y-1));
        availableMoves.add(new Point(this.getLocation().x-2, this.getLocation().y-1));
        
        availableMoves.add(new Point(this.getLocation().x+1, this.getLocation().y-2));
        availableMoves.add(new Point(this.getLocation().x-1, this.getLocation().y-2));
		
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
