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
	int x,y;
	public Sun(String name, String color, int xCoord, int yCoord) {
		super(name, color, xCoord, yCoord);
		
		this.x = xCoord;
       	 	this.y = yCoord;
       		generateMoves();
        	getAvailableMoves();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void generateMoves() {
		// TODO generate the possible movement of sun (one step in any direction)
		//Point p = new Point(1,1);
		//this.availableMoves.add(p);
		
	availableMoves.clear();
        
        if(x>0 && y>0)
        {
            availableMoves.add(new Point(x+0, y-1));
            availableMoves.add(new Point(x+0, y+1));
            availableMoves.add(new Point(x-1, y+0));
            availableMoves.add(new Point(x-1, y+1));
            availableMoves.add(new Point(x-1, y-1));
            availableMoves.add(new Point(x+1, y+0));
            availableMoves.add(new Point(x+1, y-1));
            availableMoves.add(new Point(x+1, y+1));
        }
	while(friendlyPieces()!=null)
        {
            if(friendlyPieces(x,y) == true)
            {
          
                availableMoves.remove(Point(x-1, y+1));
                availableMoves.remove(Point(x-1, y-1));
         
                availableMoves.remove(Point(x+1, y-1));
                availableMoves.remove(Point(x+1, y+1)); 
            }
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
}
