import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
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
	availableMoves.add(new Point(x+1, y+1));
        availableMoves.add(new Point(x+2, y+2));
        availableMoves.add(new Point(x-1, y-1));
        availableMoves.add(new Point(x-2, y-2));
        availableMoves.add(new Point(x+1, y-1));
        availableMoves.add(new Point(x+2, y-2));
        availableMoves.add(new Point(x-1, y+1));
        availableMoves.add(new Point(x-2, y+2));
		
		// Iterate through all illegal possible moves (eg. a move that is outside the grid) and remove them	
        Iterator<Point> iter = availableMoves.iterator();

        while(iter.hasNext()){
            Point move = iter.next();
            if(move.x > 7 || move.x < 0 || move.y > 8 || move.y < 0){
                iter.remove();
		
	}

	@Override
	public ArrayList<Point> getAvailableMoves() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
