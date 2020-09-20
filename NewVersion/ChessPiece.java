import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Abstract class ChessPiece 
 *
 * @author waliyismail
 */
public abstract class ChessPiece
{
    String pieceName;
    String pieceColor;
    Point pieceLocation;
    ArrayList<Point> availableMoves;
    
	String orientation = "" ;

    public ChessPiece(String name, String color, int xCoord , int yCoord)
    {
        pieceName = name;
        pieceColor = color;
        pieceLocation = new Point();
        pieceLocation.x = xCoord;
        pieceLocation.y = yCoord;
        availableMoves = new ArrayList<>();
        
    }
    
    public ChessPiece(String name, String color, int xCoord , int yCoord, String orientation)
    {
        pieceName = name;
        pieceColor = color;
        pieceLocation.x = xCoord;
        pieceLocation.y = yCoord;
        availableMoves = new ArrayList<>();
        this.orientation = orientation;
    }

	/**
     * generate the possible coordinates for the piece movement
     */
    public abstract void generateMoves();
    public abstract ArrayList<Point> getAvailableMoves();

    
    //getters and setters
    public void setName(String name)
    {
        this.pieceName = name;

    }
    public String getName()
    {
        return this.pieceName;

    }
    public void setColor(String color)
    {
        this.pieceColor = color;
        
    }
    public String getColor()
    {
        return this.pieceColor;

    }
    public void setLocation(int x, int y)
    {
        this.pieceLocation.x = x;
        this.pieceLocation.y = y;
        
    }
    
    public Point getLocation()
    {
        return this.pieceLocation;
    }
    
    public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
}

