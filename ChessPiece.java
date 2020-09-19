
/**
 * Abstract class ChessPiece 
 *
 * @author waliyismail
 */
public abstract class ChessPiece
{
    String pieceName;
    Color pieceColor;
    Point pieceLocation;

    public ChessPiece(String name, Color color, int xCoord , int yCoord)
    {
        pieceName = name;
        pieceColor = color;
        pieceLocation.x = xCoord;
        pieceLocation.y = yCoord;
    }

    public void setName(String name)
    {
        this.pieceName = name;

    }
    public String getName()
    {
        return this.pieceName;

    }
    public void setColor(Color color)
    {
        this.pieceColor = color;
        
    }
    public Color getColor()
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
}
