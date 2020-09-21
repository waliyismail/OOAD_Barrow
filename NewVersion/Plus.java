import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * The Plus can move any number of steps up and down, or left and right.
 * @author waliyismail
 *
 */
public class Plus extends ChessPiece {


    public Plus(String name, String color, int xCoord, int yCoord) {
        super(name, color, xCoord, yCoord);

        generateMoves() ;
        getAvailableMoves();
    }

    @Override
    public void generateMoves() {
        availableMoves.clear();
        
        availableMoves.add(new Point(this.getLocation().x, this.getLocation().y+1));
        availableMoves.add(new Point(this.getLocation().x, this.getLocation().y+2));
        availableMoves.add(new Point(this.getLocation().x, this.getLocation().y+3));
        availableMoves.add(new Point(this.getLocation().x, this.getLocation().y+4));
        availableMoves.add(new Point(this.getLocation().x, this.getLocation().y+5));
        availableMoves.add(new Point(this.getLocation().x, this.getLocation().y+6));
        
        availableMoves.add(new Point(this.getLocation().x, this.getLocation().y-1));
        availableMoves.add(new Point(this.getLocation().x, this.getLocation().y-2));
        availableMoves.add(new Point(this.getLocation().x, this.getLocation().y-3));
        availableMoves.add(new Point(this.getLocation().x, this.getLocation().y-4));
        availableMoves.add(new Point(this.getLocation().x, this.getLocation().y-5));
        availableMoves.add(new Point(this.getLocation().x, this.getLocation().y-6));
        
        availableMoves.add(new Point(this.getLocation().x+1, this.getLocation().y));
        availableMoves.add(new Point(this.getLocation().x+2, this.getLocation().y));
        availableMoves.add(new Point(this.getLocation().x+3, this.getLocation().y));
        availableMoves.add(new Point(this.getLocation().x+4, this.getLocation().y));
        availableMoves.add(new Point(this.getLocation().x+5, this.getLocation().y));
        availableMoves.add(new Point(this.getLocation().x+6, this.getLocation().y));
        availableMoves.add(new Point(this.getLocation().x+7, this.getLocation().y));
        
        availableMoves.add(new Point(this.getLocation().x-1, this.getLocation().y));
        availableMoves.add(new Point(this.getLocation().x-2, this.getLocation().y));
        availableMoves.add(new Point(this.getLocation().x-3, this.getLocation().y));
        availableMoves.add(new Point(this.getLocation().x-4, this.getLocation().y));
        availableMoves.add(new Point(this.getLocation().x-5, this.getLocation().y));
        availableMoves.add(new Point(this.getLocation().x-6, this.getLocation().y));
        availableMoves.add(new Point(this.getLocation().x-7, this.getLocation().y));
        
        
        
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
