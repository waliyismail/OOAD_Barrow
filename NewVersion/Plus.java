import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 * The Plus can move any number of steps up and down, or left and right.
 * @author waliyismail
 *
 */
public class Plus extends ChessPiece {

	int x ,y;
	public Plus(String name, String color, int xCoord, int yCoord) {
		super(name, color, xCoord, yCoord);
		this.x=xCoord;
		this.y=yCoord;
		generateMoves() ;
		getAvailableMoves();
	}

	@Override
	public void generateMoves() {
		availableMoves.clear();
	
	availableMoves.add(new Point(x, y+1));
        availableMoves.add(new Point(x, y+2));
        availableMoves.add(new Point(x, y+3));
        availableMoves.add(new Point(x, y+4));
        availableMoves.add(new Point(x, y+5));
        availableMoves.add(new Point(x, y+6));
        
        availableMoves.add(new Point(x, y-1));
        availableMoves.add(new Point(x, y-2));
        availableMoves.add(new Point(x, y-3));
        availableMoves.add(new Point(x, y-4));
        availableMoves.add(new Point(x, y-5));
        availableMoves.add(new Point(x, y-6));
        
        availableMoves.add(new Point(x+1, y));
        availableMoves.add(new Point(x+2, y));
        availableMoves.add(new Point(x+3, y));
        availableMoves.add(new Point(x+4, y));
        availableMoves.add(new Point(x+5, y));
        availableMoves.add(new Point(x+6, y));
        availableMoves.add(new Point(x+7, y));
        
        availableMoves.add(new Point(x-1, y));
        availableMoves.add(new Point(x-2, y));
        availableMoves.add(new Point(x-3, y));
        availableMoves.add(new Point(x-4, y));
        availableMoves.add(new Point(x-5, y));
        availableMoves.add(new Point(x-6, y));
        availableMoves.add(new Point(x-7, y));
        
		
	
		
	// Iterate through all illegal possible moves (eg. a move that is outside the grid) and remove them	
        Iterator<Point> iter = availableMoves.iterator();

        while(iter.hasNext()){
            Point move = iter.next();
            if(move.x > 7 || move.x < 0 || move.y > 6|| move.y < 0){
                iter.remove();
		
	}

	@Override
	public ArrayList<Point> getAvailableMoves() {
		// TODO Auto-generated method stub
		return availableMoves;
	}

}
