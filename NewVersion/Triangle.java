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
	 availableMoves.add(new Point(this.getLocation().x-1, this.getLocation().y+1));
	 availableMoves.add(new Point(this.getLocation().x-2, this.getLocation().y+2));
	 availableMoves.add(new Point(this.getLocation().x-3, this.getLocation().y+3));
	 availableMoves.add(new Point(this.getLocation().x-4, this.getLocation().y+4));
	 availableMoves.add(new Point(this.getLocation().x-5, this.getLocation().y+5));
	 
	 availableMoves.add(new Point(this.getLocation().x+1, this.getLocation().y-1));
	 availableMoves.add(new Point(this.getLocation().x+2, this.getLocation().y-2));
	 availableMoves.add(new Point(this.getLocation().x+3, this.getLocation().y-3));
	 availableMoves.add(new Point(this.getLocation().x+4, this.getLocation().y-4));
	 availableMoves.add(new Point(this.getLocation().x+5, this.getLocation().y-5));
	 
         availableMoves.add(new Point(this.getLocation().x-1, this.getLocation().y-1));
         availableMoves.add(new Point(this.getLocation().x-2, this.getLocation().y-2));
         availableMoves.add(new Point(this.getLocation().x-3, this.getLocation().y-3));
         availableMoves.add(new Point(this.getLocation().x-4, this.getLocation().y-4));
         availableMoves.add(new Point(this.getLocation().x-5, this.getLocation().y-5));
         availableMoves.add(new Point(this.getLocation().x-6, this.getLocation().y-6));
        
         availableMoves.add(new Point(this.getLocation().x+1, this.getLocation().y+1));
         availableMoves.add(new Point(this.getLocation().x+2, this.getLocation().y+2));
         availableMoves.add(new Point(this.getLocation().x+3, this.getLocation().y+3));
         availableMoves.add(new Point(this.getLocation().x+4, this.getLocation().y+4));
         availableMoves.add(new Point(this.getLocation().x+5, this.getLocation().y+5));
         availableMoves.add(new Point(this.getLocation().x+6, this.getLocation().y+6));
		
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
