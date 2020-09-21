import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * The Triangle can move any number of steps diagonally
 * @author waliyismail
 *
 */
public class Triangle extends ChessPiece{
int x,y;
	public Triangle(String name, String color, int xCoord , int yCoord, String orientation)
	{
		super(name, color, xCoord, yCoord);
		this.orientation = orientation;
		this.x=xCoord;
		this.y=yCoord;
		generateMoves() ;
		getAvailableMoves();
	}

	@Override
	public void generateMoves() {
		
	availableMoves.clear();
	 availableMoves.add(new Point(x-1, y+1));
	 availableMoves.add(new Point(x-2, y+2));
	 availableMoves.add(new Point(x-3, y+3));
	 availableMoves.add(new Point(x-4, y+4));
	 availableMoves.add(new Point(x-5, y+5));
	 
	 availableMoves.add(new Point(x+1, y-1));
	 availableMoves.add(new Point(x+2, y-2));
	 availableMoves.add(new Point(x+3, y-3));
	 availableMoves.add(new Point(x+4, y-4));
	 availableMoves.add(new Point(x+5, y-5));
	 
         availableMoves.add(new Point(x-1, y-1));
         availableMoves.add(new Point(x-2, y-2));
         availableMoves.add(new Point(x-3, y-3));
         availableMoves.add(new Point(x-4, y-4));
         availableMoves.add(new Point(x-5, y-5));
         availableMoves.add(new Point(x-6, y-6));
        
         availableMoves.add(new Point(x+1, y+1));
         availableMoves.add(new Point(x+2, y+2));
         availableMoves.add(new Point(x+3, y+3));
         availableMoves.add(new Point(x+4, y+4));
         availableMoves.add(new Point(x+5, y+5));
         availableMoves.add(new Point(x+6, y+6));
		
		// Iterate through all illegal possible moves (eg. a move that is outside the grid) and remove them	
        Iterator<Point> iter = availableMoves.iterator();

        while(iter.hasNext()){
            Point move = iter.next();
            if(move.x > 7 || move.x < 0 || move.y > 6 || move.y < 0){
                iter.remove();
		
	}
}}
	@Override
	public ArrayList<Point> getAvailableMoves() {
		// TODO Auto-generated method stub
		return availableMoves;
	}
	
}
